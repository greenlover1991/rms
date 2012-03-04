/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rms.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rms.ProjectConstants;

/**
 * Credits to Mr. Ruselo Asentista for the idea of a generic ORM style of generating SQL.
 * DBModel will allow the user to generate sql without typing sql themselves.
 * @author squeekyclean
 */
public abstract class DBTable {

    protected abstract String getTableName();
    protected abstract String[] getColumns();
    protected abstract String[] getColumnsDefaultAliases();
    protected abstract String[] getPrimaryColumns();
    protected abstract String[] getUniqueColumns();
    protected abstract String[] getUneditableColumns();
    protected abstract String[] getInvisibleColumns();
    protected abstract String[] getNonNullableColumns();


    /**
     * Generates the SELECT * all from the dbTable.
     * @return the generated SELECT * FROM table with the delimiter ;
     */
    public String generateSelectAllSql(){
        String result = "SELECT * FROM " + getTableName() + ";";
        return result;
    }

    /**
     * Generates the SELECT * with default aliases from the dbTable.
     * @return the generated SELECT * FROM table with aliases with the delimiter ;
     */
    public String generateSelectAllWithDefaultAliasesSql(){
        return generateSelectColumnsWithAliases(Arrays.asList(getColumns()), Arrays.asList(getColumnsDefaultAliases()));
    }

     /**
     * Generates the SELECT * with default aliases from the dbTable whose status is active.
     * @return the generated SELECT * FROM table with aliases with the delimiter ;
     */
    public String generateSelectAllActiveWithDefaultAliasesSql(){
        String query = generateSelectColumnsWithAliases(Arrays.asList(getColumns()), Arrays.asList(getColumnsDefaultAliases()));
        // remove delimiter, append WHERE status = 'Active';
        return query.substring(0, query.length()-1) + String.format(" WHERE status = '%s';", ProjectConstants.STATUS_ACTIVE);
    }

    /**
     * Generates the SELECT sql from the given list of select columns, and their aliases.
     * @param selectColumns list of column names to be selected
     * @param selectAliases list of aliases
     * @return the generated SELECT selected_columns FROM table with aliases with the delimiter ;
     */
    public String generateSelectColumnsWithAliases(List<String> selectColumns, List<String> selectAliases){
        StringBuffer result = new StringBuffer("SELECT ");
        String[] columns = selectColumns.toArray(new String[0]);
        String[] aliases = selectAliases.toArray(new String[0]);
        for(int i = 0; i<columns.length;i++){
            String cleaned = columns[i] + " AS '" + aliases[i] + "' ";
            result.append((i == columns.length - 1) ? cleaned + " " : cleaned + ",");
        }

        result.append("FROM " + getTableName());
        return result.toString() + ";";
    }

    /**
     * Generates the INSERT sql given a mapping of data.
     * @param insertList mapping of column_name, value to be inserted
     * @return the generated INSERT sql with the delimiter ;
     */
    public String generateInsertSql(Map<String, String> insertList){
        StringBuffer result = new StringBuffer("INSERT INTO ");
        result.append(getTableName() + "(");
        String[] insertColumns = insertList.keySet().toArray(new String[0]);

        for (int i = 0; i < insertColumns.length; i++)
        {
            CharSequence delims = ".".subSequence(0, 1) ;
            String cleaned = (insertColumns[i].contains(delims) ? (insertColumns[i].split(delims.toString()))[1] : insertColumns[i]);
            result.append((i == insertColumns.length - 1) ? cleaned + ") " : cleaned + ",");
        }

        result.append("VALUES(");

        for (int i = 0; i < insertColumns.length; i++)
        {
            String first = "'" + insertList.get(insertColumns[i]).replace("'", "''") + "')";
            String last = "'" + insertList.get(insertColumns[i]).replace("'", "") + "',";
//            if("'null')".equals(first))
//                first = first.replace("'", "'");
//            if("'null',".equals(last))
//                last = last.replace("'", "'");
            result.append((i == insertColumns.length - 1) ?  first : last);

        }

        return result.toString() + ";";
    }


    /**
     * This is to filter UPDATEs and DELETEs based on the primary keys
     * @param primaryValues mapping of primaryColumn, value to be filtered
     * @return the generated INSERT sql
     */
    private String generateDeleteUpdateFilterSql(Map<String, String> primaryValues){
        StringBuffer result = new StringBuffer(" WHERE 1=1 ");
        String[] primaryKeys = primaryValues.keySet().toArray(new String[0]);
        CharSequence delims = new String(".");
        for(String key : primaryKeys){
            String cleaned = (key.contains(delims) ? key.split(delims.toString())[1] : key);
            result.append(String.format(" AND %s = '%s'", cleaned, primaryValues.get(key)));
        }

        return result.toString();
    }

    /**
     * Generates the UPDATE sql given a mapping of data and primary values
     * @param updateList mapping of column_name, value to be updated
     * @param primaryValues  mapping of primaryColumn, value of the primary column
     * @return the generated UPDATED sql with the delimiter ;
     */
    public String generateUpdateSql(Map<String, String> updateList, Map<String, String> primaryValues){
        StringBuffer result = new StringBuffer(String.format("UPDATE %s SET",getTableName()));
        CharSequence delim = new String(".");

        String[] columns = updateList.keySet().toArray(new String[0]);
        for (int i = 0; i < columns.length; i++)
        {
            String cleaned = columns[i].contains(delim) ? (columns[i].split(delim.toString())[1]) : columns[i];
            result.append(String.format(" %s = '%s' " + ((i == columns.length - 1) ? "" : ","), cleaned, updateList.get(columns[i]).replace("'","''")));
        }
        result.append(generateDeleteUpdateFilterSql(primaryValues));

        return result.toString() + ";";
    }

    /**
     * Generates the INSERT INTO ... ON DUPLICATE KEY ... UPDATE sql given a maping of data and columns.
     * Include the primary/unique columns in the mapping.
     * Ex:
     *     upsertList = {"id"=>1, "name=>'Hello'"}
     *     uniqueList = {"id"}
     * Result:
     *     If there exists a record with ID 1, the record's name will be updated to 'Hello'
     *     else a new record with name 'Hello' will be created.
     * @param upsertList mapping of columnName, value to be 'upserted' (UPdate if it exists, inSERT if it does not).
     * columnName should include the primary/unique columns
     * @param uniqueList list of primary/unique columns that will serve as the basis of upserting
     * @return generated INSERT INTO ... ON DUPLICATE KEY UPDATE ... sql with the delimter ;
     */
    public String generateCreateUpdateSql(Map<String, String> upsertList, List<String> uniqueList){
        StringBuffer result = new StringBuffer();
        if(!upsertList.isEmpty()){
            String insertSql = generateInsertSql(upsertList);
            result.append(insertSql.substring(0, insertSql.length()-1));
            result.append(" ON DUPLICATE KEY UPDATE");
            CharSequence delim = new String(".");

            // do not include the uniquelist in updating
            List<String> filteredColumns = new ArrayList<String>(upsertList.keySet());
            filteredColumns.removeAll(uniqueList);
            String[] columns = filteredColumns.toArray(new String[0]);
            for (int i = 0; i < columns.length; i++)
            {
                String cleaned = columns[i].contains(delim) ? (columns[i].split(delim.toString())[1]) : columns[i];
                result.append(String.format(" %s = '%s' " + ((i == columns.length - 1) ? "" : ","), cleaned, upsertList.get(columns[i]).replace("'","''")));
            }
        }
        return result.toString() + ";";
        
    }

    /**
     * Generates the INSERT INTO ... ON DUPLICATE KEY ... UPDATE sql given a maping of data and columns.
     * Include the primary/unique columns in the mapping.
     * Will use the getUniqueColumns() as the uniqueList
     * Ex:
     *     upsertList = {"id"=>1, "name=>'Hello'"}
     *     uniqueList = {"id"}
     * Result:
     *     If there exists a record with ID 1, the record's name will be updated to 'Hello'
     *     else a new record with name 'Hello' will be created.
     * @param upsertList mapping of columnName, value to be 'upserted' (UPdate if it exists, inSERT if it does not).
     * columnName should include the primary/unique columns
     * @return generated INSERT INTO ... ON DUPLICATE KEY UPDATE ... sql without the delimiter ;
     */
    public String generateCreateUpdateSql(Map<String, String> upsertList){
        Map<String, String> realUpsertList = new HashMap<String, String>(upsertList);
        for(String key : upsertList.keySet()){
            String value = upsertList.get(key);
            if(value == null || value.isEmpty() || value.equals("null")){
                realUpsertList.remove(key);
            }
        }
        return generateCreateUpdateSql(realUpsertList, Arrays.asList(getUniqueColumns()));
    }

}

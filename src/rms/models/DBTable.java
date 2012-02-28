/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rms.models;

import java.util.Map;

/**
 *
 * @author squeekyclean
 */
public abstract class DBTable {

    protected abstract String getTableName();
    protected abstract String[] getColumns();
    protected abstract String[] getPrimaryColumns();

    /**
     * Generates the INSERT sql given a mapping of data.
     * @param insertList mapping of column_name, value to be inserted
     * @return the generated INSERT sql
     */
    public String generateInsertSQL(Map<String, String> insertList){
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
            result.append((i == insertColumns.length - 1) ? "'" + insertList.get(insertColumns[i]).replace("'", "''") + "');" : "'" + insertList.get(insertColumns[i]).replace("'", "") + "',");
        }

        return result.toString();
    }


    /**
     * This is to filter UPDATEs and DELETEs based on the primary keys
     * @param primaryValues mapping of primaryColumn, value to be filtered
     * @return the generated INSERT sql
     */
    public String generateDeleteUpdateFilter(Map<String, String> primaryValues){
        StringBuffer result = new StringBuffer(" WHERE 1=1 ");
        String[] primaryKeys = primaryValues.keySet().toArray(new String[0]);
        CharSequence delims = new String(".");
        for(String key : primaryKeys){
            String cleaned = (key.contains(delims) ? key.split(delims.toString())[1] : key);
            result.append(String.format(" AND %s = '%s'", cleaned, primaryValues.get(key)));
        }

        return result.toString();
    }

    public String generateUpdate(Map<String, String> updateList, Map<String, String> primaryValues){
        StringBuffer result = new StringBuffer(String.format("UPDATE %s SET ",getTableName()));
        CharSequence delim = new String(".");

        String[] columns = updateList.keySet().toArray(new String[0]);
        for (int i = 0; i < columns.length; i++)
        {
            String cleaned = columns[i].contains(delim) ? (columns[i].split(delim.toString())[1]) : columns[i];
            result.append(String.format(" %s = '%s' " + ((i == columns.length - 1) ? "" : ","), cleaned, updateList.get(columns[i]).replace("'","''")));
        }
        result.append(generateDeleteUpdateFilter(primaryValues));

        return result.toString();
    }

//    public String generateCreateUpdate(Map<String, String> valueList, Map<String, String> primaryValues){
//        StringBuffer result = new StringBuffer();
//        result.append(String.format("IF EXISTS (SELECT TOP 1 * FROM %s %s) ", getTableName(), generateDeleteUpdateFilter(primaryValues)));
//        result.append(String.format("THEN %s;", generateUpdate(valueList, primaryValues)));
//        result.append("\n");
//        result.append(String.format("ELSE %s", generateInsertSQL(valueList)));
//        result.append("\n");
//        result.append("END IF;");
//
//        return result.toString();
//    }

}

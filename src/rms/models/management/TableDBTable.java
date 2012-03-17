/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rms.models.management;

import rms.models.DBTable;

/**
 *
 * @author Mark Taveros
 */
public class TableDBTable extends DBTable{
    public static final String TABLE_NAME = "restaurant_tables";

    public static final String ID = "id";
    public static final String TABLE_NUMBER = "table_number";
    public static final String DESCRIPTION = "description";
    public static final String CAPACITY = "capacity";
    public static final String TABLE_STATUS = "table_status";
    public static final String STATUS = "status";

    public static final String ALIAS_ID = "ID";
    public static final String ALIAS_TABLE_NUMBER = "Table Number";
    public static final String ALIAS_DESCRIPTION = "Description";
    public static final String ALIAS_CAPACITY = "Capacity";
    public static final String ALIAS_TABLE_STATUS = "Table Status";
    public static final String ALIAS_STATUS = "Status";
    
    public static final String TABLE_STATUS_VACANT = "Vacant";
    public static final String TABLE_STATUS_OCCUPIED = "Occupied";
    public static final String TABLE_STATUS_RESERVED = "Reserved";
    public static final String TABLE_STATUS_UNAVAILABLE = "Unavailable";

    private static final String[] columns = {TABLE_NUMBER, ID, DESCRIPTION, CAPACITY, TABLE_STATUS, STATUS};
    private static final String[] columnsAliases = {ALIAS_TABLE_NUMBER, ALIAS_ID, ALIAS_DESCRIPTION, ALIAS_CAPACITY, ALIAS_TABLE_STATUS, ALIAS_STATUS};
    private static final String[] primaryColumns = {ID};
    private static final String[] uniqueColumns = {ID};
    private static final String[] invisibleColumns = {ALIAS_ID, ALIAS_TABLE_STATUS, ALIAS_STATUS};
    private static final String[] uneditableColumns = {ID, STATUS};
    private static final String[] nonNullableColumns = {TABLE_NUMBER, CAPACITY, TABLE_STATUS, STATUS};

    private static TableDBTable INSTANCE;
    private TableDBTable(){}
    public static TableDBTable getInstance(){
        if(INSTANCE == null)
            INSTANCE = new TableDBTable();
        return INSTANCE;
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }


    @Override
    public String[] getColumns() {
        return columns;
    }

    @Override
    public String[] getPrimaryColumns() {
        return primaryColumns;
    }

    @Override
    public String[] getUniqueColumns() {
        return uniqueColumns;
    }

    @Override
    public String[] getColumnsDefaultAliases() {
        return columnsAliases;
    }

    @Override
    public String[] getInvisibleColumns() {
        return invisibleColumns;
    }

    @Override
    public String[] getNonNullableColumns() {
        return nonNullableColumns;
    }

    @Override
    public String[] getUneditableColumns() {
        return uneditableColumns;
    }


}
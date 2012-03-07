/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rms.models.inventory;

import rms.models.DBTable;

/**
 *
 * @author squeekyclean
 */
public class SpoilageReportDBTable extends DBTable{
    public static final String TABLE_NAME = "spoilage_reports";

    public static final String ID = "id";
    public static final String DATE_OF_SPOILAGE = "date_of_spoilage";
    public static final String STATUS = "status";

    public static final String ALIAS_ID = "ID";
    public static final String ALIAS_DATE = "Date";
    public static final String ALIAS_STATUS = "Status";

    private static final String[] columns = {DATE_OF_SPOILAGE, ID, STATUS};
    private static final String[] columnsAliases = {ALIAS_DATE, ALIAS_ID, ALIAS_STATUS};
    private static final String[] primaryColumns = {ID};
    private static final String[] uniqueColumns = {ID};
    private static final String[] invisibleColumns = {ALIAS_ID, ALIAS_STATUS};
    private static final String[] uneditableColumns = {ID, DATE_OF_SPOILAGE, STATUS};
    private static final String[] nonNullableColumns = {DATE_OF_SPOILAGE, STATUS};

    private static SpoilageReportDBTable INSTANCE;
    private SpoilageReportDBTable(){}
    public static SpoilageReportDBTable getInstance(){
        if(INSTANCE == null)
            INSTANCE = new SpoilageReportDBTable();
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
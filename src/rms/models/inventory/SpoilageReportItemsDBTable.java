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
public class SpoilageReportItemsDBTable extends DBTable{
    public static final String TABLE_NAME = "spoilage_report_items";

    public static final String ID = "id";
    public static final String SPOILAGE_REPORT_ID = "spoilage_report_id";
    public static final String QUANTITY = "quantity";
    public static final String INGREDIENT_ID = "ingredient_id";
    public static final String DESCRIPTION = "description";
    public static final String STATUS = "status";

    public static final String ALIAS_ID = "ID";
    public static final String ALIAS_SPOILAGE_REPORT_ID = "Spoilage Report ID";
    public static final String ALIAS_QUANTITY = "Quantity";
    public static final String ALIAS_INGREDIENT_ID = "Ingredient ID";
    public static final String ALIAS_DESCRIPTION = "Reason/Remarks";
    public static final String ALIAS_STATUS = "Status";

    private static final String[] columns = {QUANTITY, ID, SPOILAGE_REPORT_ID, INGREDIENT_ID, DESCRIPTION, STATUS};
    private static final String[] columnsAliases = {ALIAS_QUANTITY, ALIAS_ID, ALIAS_SPOILAGE_REPORT_ID, ALIAS_INGREDIENT_ID, ALIAS_DESCRIPTION, ALIAS_STATUS};
    private static final String[] primaryColumns = {ID};
    private static final String[] uniqueColumns = {ID};
    private static final String[] invisibleColumns = {ALIAS_ID, ALIAS_STATUS, ALIAS_SPOILAGE_REPORT_ID, ALIAS_INGREDIENT_ID};
    private static final String[] uneditableColumns = {ID, STATUS, SPOILAGE_REPORT_ID, INGREDIENT_ID};
    private static final String[] nonNullableColumns = {QUANTITY,SPOILAGE_REPORT_ID, INGREDIENT_ID, STATUS};

    private static SpoilageReportItemsDBTable INSTANCE;
    private SpoilageReportItemsDBTable(){}
    public static SpoilageReportItemsDBTable getInstance(){
        if(INSTANCE == null)
            INSTANCE = new SpoilageReportItemsDBTable();
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
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rms.models.ordering;

import rms.models.DBTable;

/**
 *
 * @author squeekyclean
 */
public class OrderSlipDBTable extends DBTable{
    public static final String TABLE_NAME = "order_slips";

    public static final String ID = "id";
    public static final String DATETIME_OF_ORDER = "date_of_spoilage";
    public static final String DATETIME_OF_TENDER = "date_of_spoilage";
    public static final String TOTAL_AMOUNT = "date_of_spoilage";
    public static final String TOTAL_DISCOUNT_AMOUNT = "date_of_spoilage";
    public static final String GRAND_TOTAL = "date_of_spoilage";
    public static final String WAITED_BY = "date_of_spoilage";
    public static final String TENDERED_BY = "date_of_spoilage";
    public static final String NUMBER_OF_CUSTOMERS = "date_of_spoilage";
    public static final String ORDER_STATUS = "date_of_spoilage";
    public static final String IS_TAKEOUT = "date_of_spoilage";
    public static final String STATUS = "status";

    public static final String ALIAS_ID = "ID";
    public static final String ALIAS_DATE = "Date";
    public static final String ALIAS_STATUS = "Status";

    private static final String[] columns = {DATETIME_OF_ORDER, ID, STATUS};
    private static final String[] columnsAliases = {ALIAS_DATE, ALIAS_ID, ALIAS_STATUS};
    private static final String[] primaryColumns = {ID};
    private static final String[] uniqueColumns = {ID};
    private static final String[] invisibleColumns = {ALIAS_ID, ALIAS_STATUS};
    private static final String[] uneditableColumns = {ID, DATETIME_OF_ORDER, STATUS};
    private static final String[] nonNullableColumns = {DATETIME_OF_ORDER, STATUS};

    private static OrderSlipDBTable INSTANCE;
    private OrderSlipDBTable(){}
    public static OrderSlipDBTable getInstance(){
        if(INSTANCE == null)
            INSTANCE = new OrderSlipDBTable();
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
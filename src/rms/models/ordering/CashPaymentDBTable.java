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
public class CashPaymentDBTable extends DBTable{
    public static final String TABLE_NAME = "cash_payments";

    public static final String ID = "id";
    public static final String ORDER_SLIP_ID = "order_slip_id";
    public static final String AMOUNT = "amount";
    public static final String OR_NUMBER = "or_number";
    public static final String STATUS = "status";

    public static final String ALIAS_ID = "ID";
    public static final String ALIAS_DATE = "Date";
    public static final String ALIAS_STATUS = "Status";

    private static final String[] columns = {ORDER_SLIP_ID, ID, STATUS};
    private static final String[] columnsAliases = {ALIAS_DATE, ALIAS_ID, ALIAS_STATUS};
    private static final String[] primaryColumns = {ID};
    private static final String[] uniqueColumns = {ID};
    private static final String[] invisibleColumns = {ALIAS_ID, ALIAS_STATUS};
    private static final String[] uneditableColumns = {ID, ORDER_SLIP_ID, STATUS};
    private static final String[] nonNullableColumns = {ORDER_SLIP_ID, STATUS};

    private static CashPaymentDBTable INSTANCE;
    private CashPaymentDBTable(){}
    public static CashPaymentDBTable getInstance(){
        if(INSTANCE == null)
            INSTANCE = new CashPaymentDBTable();
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
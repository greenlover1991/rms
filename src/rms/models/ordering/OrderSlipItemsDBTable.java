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
public class OrderSlipItemsDBTable extends DBTable{
    public static final String TABLE_NAME = "order_slip_items";

    public static final String ID = "id";
    public static final String ORDER_SLIP_ID = "order_slip_id";
    public static final String QUANTITY = "quantity";
    public static final String MENU_ITEM_ID = "menu_item_id";
    public static final String UNIT_COST = "unit_cost";
    public static final String AMOUNT = "amount";
    public static final String DESCRIPTION = "description";
    public static final String ORDER_STATUS = "order_status";
    public static final String DISCOUNTED_ITEMS = "discounted_items";
    public static final String DISCOUNT_FIXED_AMOUNT = "discount_fixed_amount";
    public static final String DISCOUNT_RATE = "discount_rate";
    public static final String DISCOUNT_DESCRIPTION = "discount_description";
    public static final String NET_AMOUNT = "net_amount";
    public static final String DATETIME_OF_ORDER = "datetime_of_order";
    public static final String DATETIME_OF_COOK = "datetime_of_cook";
    public static final String DATETIME_OF_SERVE = "datetime_of_serve";
    public static final String STATUS = "status";

    public static final String ALIAS_ID = "ID";
    public static final String ALIAS_SPOILAGE_REPORT_ID = "Spoilage Report ID";
    public static final String ALIAS_QUANTITY = "Quantity";
    public static final String ALIAS_INGREDIENT_ID = "Ingredient ID";
    public static final String ALIAS_DESCRIPTION = "Reason/Remarks";
    public static final String ALIAS_STATUS = "Status";

    private static final String[] columns = {QUANTITY, ID, ORDER_SLIP_ID, MENU_ITEM_ID, DESCRIPTION, STATUS};
    private static final String[] columnsAliases = {ALIAS_QUANTITY, ALIAS_ID, ALIAS_SPOILAGE_REPORT_ID, ALIAS_INGREDIENT_ID, ALIAS_DESCRIPTION, ALIAS_STATUS};
    private static final String[] primaryColumns = {ID};
    private static final String[] uniqueColumns = {ID};
    private static final String[] invisibleColumns = {ALIAS_ID, ALIAS_STATUS, ALIAS_SPOILAGE_REPORT_ID, ALIAS_INGREDIENT_ID};
    private static final String[] uneditableColumns = {ID, STATUS, ORDER_SLIP_ID, MENU_ITEM_ID};
    private static final String[] nonNullableColumns = {QUANTITY,ORDER_SLIP_ID, MENU_ITEM_ID, STATUS};

    private static OrderSlipItemsDBTable INSTANCE;
    private OrderSlipItemsDBTable(){}
    public static OrderSlipItemsDBTable getInstance(){
        if(INSTANCE == null)
            INSTANCE = new OrderSlipItemsDBTable();
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
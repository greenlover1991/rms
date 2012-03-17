/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rms.models.management;
import rms.models.DBTable;

/**
 *
 * @author xmiez
 */
public class MenuItemsDBTable extends DBTable{
     public static final String TABLE_NAME = "menu_items";

     public static final String ID="id";
     public static final String NAME="name";
     public static final String DESCRIPTION="description";
     public static final String RECIPE_PROC="recipe_procedure";
     public static final String SECONDS_TO_COOK="seconds_to_cook";
     public static final String MENU_CAT_ID="menu_category_id";
     public static final String PRICE="price";
     public static final String STATUS="status";

     public static final String ALIAS_ID="ID";
     public static final String ALIAS_NAME="Name";
     public static final String ALIAS_DESCRIPTION="Description";
     public static final String ALIAS_RECIPE_PROC="Prodecure";
     public static final String ALIAS_SECONDS_TO_COOK="Time to cook";
     public static final String ALIAS_MENU_CAT_ID="Menu category";
     public static final String ALIAS_PRICE="price";
     public static final String ALIAS_STATUS="status";

     private static final String[] columns = { NAME,ID, DESCRIPTION, RECIPE_PROC, SECONDS_TO_COOK, MENU_CAT_ID,PRICE, STATUS};
     private static final String[] columnsAliases = { ALIAS_NAME,ALIAS_ID, ALIAS_DESCRIPTION,ALIAS_RECIPE_PROC ,ALIAS_SECONDS_TO_COOK, ALIAS_MENU_CAT_ID,ALIAS_PRICE ,ALIAS_STATUS };
     private static final String[] primaryColumns = {ID};
     private static final String[] uniqueColumns = {ID};
     private static final String[] invisibleColumns = {ALIAS_ID, ALIAS_STATUS,ALIAS_MENU_CAT_ID,ALIAS_RECIPE_PROC};
     private static final String[] uneditableColumns = {ID, STATUS};
     private static final String[] nonNullableColumns = { NAME,PRICE,STATUS,MENU_CAT_ID,};



     private static MenuItemsDBTable INSTANCE;
     private MenuItemsDBTable(){}
     public static MenuItemsDBTable getInstance(){
        if(INSTANCE == null)
            INSTANCE = new MenuItemsDBTable();
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
    public String[] getColumnsDefaultAliases() {
        return columnsAliases;
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
    public String[] getUneditableColumns() {
        return uneditableColumns;
    }

    @Override
    public String[] getInvisibleColumns() {
        return invisibleColumns;
    }

    @Override
    public String[] getNonNullableColumns() {
        return nonNullableColumns;
    }
}

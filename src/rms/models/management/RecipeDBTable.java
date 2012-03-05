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
public class RecipeDBTable extends DBTable{
    public static final String TABLE_NAME = "recipes";

    public static final String INGREDIENT_ID = "ingredient_id";
    public static final String MENU_ITEM_ID = "menu_item_id";
    public static final String QTY = "quantity";


    public static final String ALIAS_INGREDIENT_ID = "Ingredient Id";
    public static final String ALIAS_MENU_ITEM_ID = "Menu Item Id";
    public static final String ALIAS_QTY = "Quantity";


    private static final String[] columns = {INGREDIENT_ID,MENU_ITEM_ID,QTY};
    private static final String[] columnsAliases = {ALIAS_INGREDIENT_ID,ALIAS_MENU_ITEM_ID,ALIAS_QTY};
    private static final String[] primaryColumns = {INGREDIENT_ID,MENU_ITEM_ID,QTY};
    private static final String[] uniqueColumns = {INGREDIENT_ID,MENU_ITEM_ID};
    private static final String[] invisibleColumns = {ALIAS_INGREDIENT_ID, ALIAS_MENU_ITEM_ID};
    private static final String[] uneditableColumns = {ALIAS_INGREDIENT_ID, ALIAS_MENU_ITEM_ID};
    private static final String[] nonNullableColumns = {INGREDIENT_ID,MENU_ITEM_ID,QTY};

    private static RecipeDBTable INSTANCE;
    private RecipeDBTable(){}
    public static RecipeDBTable getInstance(){
        if(INSTANCE == null)
            INSTANCE = new RecipeDBTable();
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

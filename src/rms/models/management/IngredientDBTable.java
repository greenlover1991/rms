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
public class IngredientDBTable extends DBTable{
    public static final String TABLE_NAME = "ingredients";

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String UNIT_OF_MEASURE = "unit_of_measure";
    public static final String MINIMUM_QUANTITY = "minimum_quantity";
    public static final String QUANTITY = "quantity";
    public static final String STATUS = "status";

    public static final String ALIAS_ID = "ID";
    public static final String ALIAS_NAME = "Ingredient";
    public static final String ALIAS_DESCRIPTION = "Description";
    public static final String ALIAS_UNIT_OF_MEASURE = "Unit";
    public static final String ALIAS_MINIMUM_QUANTITY = "Minimum Quantity";
    public static final String ALIAS_QUANTITY = "Quantity";
    public static final String ALIAS_STATUS = "Status";

    private static final String[] columns = {NAME, ID, DESCRIPTION, UNIT_OF_MEASURE, MINIMUM_QUANTITY, QUANTITY, STATUS};
    private static final String[] columnsAliases = {ALIAS_NAME, ALIAS_ID, ALIAS_DESCRIPTION, ALIAS_UNIT_OF_MEASURE, ALIAS_MINIMUM_QUANTITY, ALIAS_QUANTITY, ALIAS_STATUS};
    private static final String[] primaryColumns = {ID};
    private static final String[] uniqueColumns = {ID};
    private static final String[] invisibleColumns = {ALIAS_ID, ALIAS_STATUS};
    private static final String[] uneditableColumns = {ID, STATUS};
    private static final String[] nonNullableColumns = {ID, NAME, STATUS};

    private static IngredientDBTable INSTANCE;
    private IngredientDBTable(){}
    public static IngredientDBTable getInstance(){
        if(INSTANCE == null)
            INSTANCE = new IngredientDBTable();
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
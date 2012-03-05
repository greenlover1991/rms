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
public class SupplierPriceListDBTable extends DBTable{
     public static final String TABLE_NAME="supplier_price_lists";

      public static final String ID="id";
      public static final String INGREDIENT_ID="ingredient_id";
      public static final String PRICE="price";
      public static final String SUPPLIER_ID="supplier_id";
      public static final String STATUS="status";

      public static final String ALIAS_ID="ID";
      public static final String ALIAS_INGREDIENT_ID="Ingredient Id";
      public static final String ALIAS_PRICE="price";
      public static final String ALIAS_SUPPLIER_ID="supplier id";
      public static final String ALIAS_STATUS="status";

      private static final String[] columns = {ID,INGREDIENT_ID, PRICE,SUPPLIER_ID, STATUS};
      private static final String[] columnsAliases = {ALIAS_ID,ALIAS_INGREDIENT_ID,ALIAS_PRICE ,SUPPLIER_ID,ALIAS_STATUS };
      private static final String[] primaryColumns = {ID};
      private static final String[] uniqueColumns = {ID};
      private static final String[] invisibleColumns = {ALIAS_ID,ALIAS_INGREDIENT_ID,ALIAS_SUPPLIER_ID,ALIAS_STATUS};
      private static final String[] uneditableColumns = {ID, STATUS};
      private static final String[] nonNullableColumns = {INGREDIENT_ID,SUPPLIER_ID, PRICE, STATUS};

      private static SupplierPriceListDBTable INSTANCE;
      private SupplierPriceListDBTable(){}
      public static SupplierPriceListDBTable getInstance(){
        if(INSTANCE == null)
            INSTANCE = new SupplierPriceListDBTable();
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

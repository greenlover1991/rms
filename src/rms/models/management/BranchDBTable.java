/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rms.models.management;

import rms.models.DBTable;

/**
 *
 * @author squeekyclean
 */
public class BranchDBTable extends DBTable{
    public static final String TABLE_NAME = "branches";

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String ADDRESS = "address";
    public static final String STATUS = "status";

    public static final String ALIAS_ID = "ID";
    public static final String ALIAS_NAME = "Branch";
    public static final String ALIAS_ADDRESS = "Address";
    public static final String ALIAS_STATUS = "Status";

    private static final String[] columns = {ID, NAME, ADDRESS, STATUS};
    private static final String[] columnsAliases = {ALIAS_ID, ALIAS_NAME, ALIAS_ADDRESS, ALIAS_STATUS};
    private static final String[] primaryColumns = {ID};
    private static final String[] uniqueColumns = {ID};
    private static final String[] invisibleColumns = {ID, STATUS};
    private static final String[] uneditableColumns = {ID, STATUS};
    private static final String[] nonNullableColumns = {ID, NAME, STATUS};

    private static BranchDBTable INSTANCE;
    private BranchDBTable(){}
    public static BranchDBTable getInstance(){
        if(INSTANCE == null)
            INSTANCE = new BranchDBTable();
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
    protected String[] getUniqueColumns() {
        return uniqueColumns;
    }

    @Override
    protected String[] getColumnsDefaultAliases() {
        return columnsAliases;
    }

    @Override
    protected String[] getInvisibleColumns() {
        return invisibleColumns;
    }

    @Override
    protected String[] getNonNullableColumns() {
        return nonNullableColumns;
    }

    @Override
    protected String[] getUneditableColumns() {
        return uneditableColumns;
    }


}
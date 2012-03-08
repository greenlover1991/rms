/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class RoleDBTable extends DBTable{
    public static final String TABLE_NAME = "roles";

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String STATUS = "status";

    public static final String ALIAS_ID = "ID";
    public static final String ALIAS_NAME = "Role";
    public static final String ALIAS_DESCRIPTION = "Description";
    public static final String ALIAS_STATUS = "Status";

    private static final String[] columns = {NAME, ID, DESCRIPTION, STATUS};
    private static final String[] columnsAliases = {ALIAS_NAME, ALIAS_ID, ALIAS_DESCRIPTION, ALIAS_STATUS};
    private static final String[] primaryColumns = {ID};
    private static final String[] uniqueColumns = {ID};
    private static final String[] invisibleColumns = {ALIAS_ID, ALIAS_STATUS};
    private static final String[] uneditableColumns = {ID, STATUS};
    private static final String[] nonNullableColumns = {ID, NAME, STATUS};

    private static RoleDBTable INSTANCE;
    private RoleDBTable(){}
    public static RoleDBTable getInstance(){
        if(INSTANCE == null)
            INSTANCE = new RoleDBTable();
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
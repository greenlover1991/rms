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
public class EmployeeDBTable extends DBTable{
    public static final String TABLE_NAME = "employees";

    public static final String ID = "id";
    public static final String F_NAME = "first_name";
    public static final String L_NAME = "last_name";
    public static final String M_NAME = "middle_name";
    public static final String BIRTHDATE = "birthdate";
    public static final String LANDLINE = "landline_number";
    public static final String MOBILE = "mobile_number";
    public static final String ADDRESS = "address";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String ROLE_ID = "role_id";
    public static final String STATUS = "status";

    public static final String ALIAS_ID = "ID";
    public static final String ALIAS_F_NAME = "First Name";
    public static final String ALIAS_L_NAME = "Last Name";
    public static final String ALIAS_M_NAME = "Middle Name";
    public static final String ALIAS_BIRTHDATE = "Birthdate";
    public static final String ALIAS_LANDLINE = "Landline Number";
    public static final String ALIAS_MOBILE = "Mobile Number";
    public static final String ALIAS_ADDRESS = "Address";
    public static final String ALIAS_LOGIN = "Login";
    public static final String ALIAS_PASSWORD = "Password";
    public static final String ALIAS_ROLE_ID = "Role";
    public static final String ALIAS_STATUS = "Status";


    private static final String[] columns = {F_NAME,ID,  L_NAME, M_NAME,  BIRTHDATE, LANDLINE,MOBILE, ADDRESS, LOGIN, PASSWORD, ROLE_ID, STATUS};
    private static final String[] columnsAliases = { ALIAS_F_NAME, ALIAS_ID,ALIAS_L_NAME, ALIAS_M_NAME, ALIAS_BIRTHDATE, ALIAS_LANDLINE, ALIAS_MOBILE, ALIAS_ADDRESS, ALIAS_LOGIN, ALIAS_PASSWORD, ALIAS_ROLE_ID, ALIAS_STATUS};
    private static final String[] primaryColumns = {ID};
    private static final String[] uniqueColumns = {ID};
    private static final String[] invisibleColumns = {ALIAS_ID, ALIAS_STATUS};
    private static final String[] uneditableColumns = {ID, STATUS};
    private static final String[] nonNullableColumns = {F_NAME, L_NAME, M_NAME,LOGIN,PASSWORD, ROLE_ID, STATUS};

    private static EmployeeDBTable INSTANCE;
    private EmployeeDBTable(){}
    public static EmployeeDBTable getInstance(){
        if(INSTANCE == null)
            INSTANCE = new EmployeeDBTable();
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

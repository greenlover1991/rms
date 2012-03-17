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
public class SupplierDBTable extends DBTable{
    public static final String TABLE_NAME = "suppliers";

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String ADDRESS = "address";
    public static final String LANDLINE = "landline_number";
    public static final String MOBILE = "mobile_number";
    public static final String CONTACT_PERSON = "contact_person";
    public static final String EMAIL_ADD = "email_address";
    public static final String STATUS = "status";

    public static final String ALIAS_ID = "ID";
    public static final String ALIAS_NAME = "NAME";
    public static final String ALIAS_ADDRESS = "Address";
    public static final String ALIAS_LANDLINE = "Landline Number";
    public static final String ALIAS_MOBILE = "Mobile Number";
    public static final String ALIAS_CONTACT_PERSON = "Contact Person";
    public static final String ALIAS_EMAIL_ADD = "Email Eddress";
    public static final String ALIAS_STATUS = "Status";


    private static final String[] columns = {NAME,ID,ADDRESS, LANDLINE,MOBILE, CONTACT_PERSON,EMAIL_ADD, STATUS};
    private static final String[] columnsAliases = {ALIAS_NAME,ALIAS_ID, ALIAS_ADDRESS,ALIAS_LANDLINE,ALIAS_MOBILE,ALIAS_CONTACT_PERSON,ALIAS_EMAIL_ADD,ALIAS_STATUS};
    private static final String[] primaryColumns = {ID};
    private static final String[] uniqueColumns = {ID};
    private static final String[] invisibleColumns = {ALIAS_ID, ALIAS_STATUS};
    private static final String[] uneditableColumns = {ID, STATUS};
    private static final String[] nonNullableColumns = {NAME, STATUS};

    private static SupplierDBTable INSTANCE;
    private SupplierDBTable(){}
    public static SupplierDBTable getInstance(){
        if(INSTANCE == null)
            INSTANCE = new SupplierDBTable();
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

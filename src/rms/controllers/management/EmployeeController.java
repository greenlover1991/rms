/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rms.controllers.management;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import rms.models.BaseTableModel;
import rms.models.DataRow;
import rms.models.management.EmployeeDBTable;
import rms.views.management.EmployeeView;
import supports.DataSupport;

/**
 *
 * @author squeekyclean
 */
public class EmployeeController {

    private EmployeeView view;
    private BaseTableModel model;

    public EmployeeController(EmployeeView view){
        this.view = view;
        this.model = new BaseTableModel();
    }

    public BaseTableModel refreshData(){
       String query = String.format("SELECT e.id, e.first_name AS 'First Name',  e.last_name AS 'Last Name', e.middle_name AS 'Middle Name', "
                                    + "e.birthdate AS Birthdate, e.landline_number AS 'Landline Number', e.mobile_number AS 'Mobile Number',  "
                                    + "e.address AS Address, e.login AS Login, e.password AS Password, e.role_id, r.id, r.name AS Role "
                                    + "FROM employees e "
                                    + "inner join roles r "
                                    + "on r.id=e.role_id ");
        try {
            EmployeeDBTable db = EmployeeDBTable.getInstance();
            DataSupport dh = new DataSupport();
            model = dh.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(view, ex.toString());
        }
        return model;
    }

    public boolean save(){
        boolean result = false;
        List<String> sqls = new ArrayList<String>();
        EmployeeDBTable db = EmployeeDBTable.getInstance();

        for(DataRow row : model.rows){
            sqls.add(db.generateCreateUpdateSql(row.getRowAsStrings()));
        }

        DataSupport dh;

        try {
            dh = new DataSupport();
            dh.executeBatchUpdate(sqls);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }
    public Map getRoles(){
       Map<String, Integer> roles = new HashMap<String, Integer>();
       try {
            DataSupport dh = new DataSupport();
            BaseTableModel res = dh.executeQuery("SELECT id, name FROM roles WHERE status = 'Active';");

            for(DataRow row : res.rows){
                Integer id = new Integer(row.get(0).toString());
                String name = row.get(1).toString();
                roles.put(name, id);
            }
       }catch(SQLException ex){
            Logger.getLogger(MenuItemsController.class.getName()).log(Level.SEVERE, null, ex);
       }
       return roles;
   }

}

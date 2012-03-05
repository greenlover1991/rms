/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rms.controllers.management;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
        try {
            EmployeeDBTable db = EmployeeDBTable.getInstance();
            String query = db.generateSelectAllWithDefaultAliasesSql();
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


}

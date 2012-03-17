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
import rms.models.management.RoleDBTable;
import rms.views.management.RoleView;
import supports.DataSupport;

/**
 *
 * @author Mark Taveros
 */
public class RoleController {

    private RoleView view;
    private BaseTableModel model;

    public RoleController(RoleView view){
        this.view = view;
        this.model = new BaseTableModel();
    }

    public BaseTableModel refreshData(){
        try {
            RoleDBTable db = RoleDBTable.getInstance();
            String query = db.generateSelectAllActiveWithDefaultAliasesSql();
            DataSupport dh = new DataSupport();
            model = dh.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(RoleController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(view, ex.toString());
        }
        return model;
    }

    public boolean save(){
        boolean result = false;
        List<String> sqls = new ArrayList<String>();
        RoleDBTable db = RoleDBTable.getInstance();

        for(DataRow row : model.rows){
            sqls.add(db.generateCreateUpdateSql(row.getRowAsStrings()));
        }

        DataSupport dh;

        try {
            dh = new DataSupport();
            dh.executeBatchUpdate(sqls);
        } catch (SQLException ex) {
            Logger.getLogger(RoleController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }


}

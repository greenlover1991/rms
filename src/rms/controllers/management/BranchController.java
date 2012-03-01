/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rms.controllers.management;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import rms.models.BaseTableModel;
import rms.models.DataRow;
import rms.models.management.BranchDBTable;
import rms.views.management.BranchView;
import supports.DataSupport;

/**
 *
 * @author squeekyclean
 */
public class BranchController {

    private BranchView view;
    private BaseTableModel model;

    public BranchController(BranchView view){
        this.view = view;
        this.model = new BaseTableModel();
    }

    public BaseTableModel refresh(){
        try {
            DataSupport dh = new DataSupport();
            BranchDBTable db = BranchDBTable.getInstance();
            String query = db.generateSelectAllWithDefaultAliasesSql();
            model = dh.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(BranchController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(view, ex.toString());
        }
        return model;
    }

    public boolean save(BaseTableModel toBeSavedModel){
        boolean result = false;
        StringBuffer sql = new StringBuffer();
        BranchDBTable db = BranchDBTable.getInstance();

        for(DataRow row : toBeSavedModel.rows){
            sql.append(db.generateCreateUpdateSql(row.getRowAsStrings()));
        }

        return result;
    }

}

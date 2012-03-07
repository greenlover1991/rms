/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rms.controllers.inventory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import rms.ProjectConstants;
import rms.models.BaseTableModel;
import rms.models.DataRow;
import rms.models.inventory.SpoilageReportDBTable;
import rms.models.inventory.SpoilageReportItemsDBTable;
import rms.models.management.BranchDBTable;
import rms.models.management.IngredientDBTable;
import rms.views.inventory.SpoilageView;
import supports.DataSupport;

/**
 *
 * @author Mark Taveros
 */
public class SpoilageInventoryController {

    private SpoilageView view;

    

    public SpoilageInventoryController(SpoilageView view){
        this.view = view;
        initSpoilageForm();
    }

    public BaseTableModel loadIngredients(){
        BaseTableModel result;
        try{
            DataSupport dh = new DataSupport();
            String query = "SELECT name AS Ingredient, id AS ID FROM ingredients " +
                           "WHERE status = 'Active' AND id NOT IN (" +
                           "                 SELECT sri.ingredient_id FROM spoilage_reports sr " +
                           "                 INNER JOIN spoilage_report_items sri ON sr.id = sri.spoilage_report_id " +
                           "                 WHERE sr.date_of_spoilage = CURDATE() AND sr.status = 'Active'" +
                           "                );";
            BaseTableModel temp = dh.executeQuery(query);
            result = new BaseTableModel(temp.columnNames, temp.columnAliases, temp.columnClasses){

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return false;
                }

            };
            result.rows = temp.rows;
        }catch(SQLException e){
            e.printStackTrace();
            result = null;
            JOptionPane.showMessageDialog(view, e.toString());
        }
        return result;
    }
    
    public BaseTableModel loadSpoilage(){
        BaseTableModel result;
        try{
            DataSupport dh = new DataSupport();
            String query = "SELECT name AS Ingredient, id AS ID FROM ingredients " +
                           "WHERE status = 'Active' AND id NOT IN (" +
                           "                 SELECT sri.ingredient_id FROM spoilage_reports sr " +
                           "                 INNER JOIN spoilage_report_items sri ON sr.id = sri.spoilage_report_id " +
                           "                 WHERE sr.date_of_spoilage = CURDATE() AND sr.status = 'Active'" +
                           "                );";
            BaseTableModel temp = dh.executeQuery(query);
            result = new BaseTableModel(temp.columnNames, temp.columnAliases, temp.columnClasses){

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return false;
                }

            };
            result.rows = temp.rows;
        }catch(SQLException e){
            e.printStackTrace();
            result = null;
            JOptionPane.showMessageDialog(view, e.toString());
        }
        return result;
    }



    public boolean save(){
        boolean result = false;
        List<String> sqls = new ArrayList<String>();
        BranchDBTable db = BranchDBTable.getInstance();
//
//        for(DataRow row : model.rows){
//            sqls.add(db.generateCreateUpdateSql(row.getRowAsStrings()));
//        }

        DataSupport dh;

        try {
            dh = new DataSupport();
            dh.executeBatchUpdate(sqls);
        } catch (SQLException ex) {
            Logger.getLogger(SpoilageInventoryController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    private void initSpoilageForm() {
        throw new UnsupportedOperationException("Not yet implemented");
    }


}

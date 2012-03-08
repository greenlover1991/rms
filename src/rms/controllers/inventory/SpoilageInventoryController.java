/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rms.controllers.inventory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import rms.models.BaseTableModel;
import rms.models.DataRow;
import rms.models.inventory.SpoilageReportItemsDBTable;
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

            String query = "SELECT sri.id, sri.spoilage_report_id, sri.ingredient_id, i.name AS Item, " +
                    "sri.quantity AS Quantity, i.unit_of_measure AS Measurement, " +
                    "sri.description AS 'Reason/Remarks' " +
                    "FROM spoilage_report_items sri INNER JOIN ingredients i ON sri.ingredient_id = i.id " +
                    "WHERE sri.spoilage_report_id = (SELECT id FROM spoilage_reports WHERE date_of_spoilage = CURDATE());";
            BaseTableModel temp = dh.executeQuery(query);
            result = new BaseTableModel(temp.columnNames, temp.columnAliases, temp.columnClasses){

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    if(columnIndex == 4 || columnIndex == 6)
                        return true;
                    else
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

    public void remove(int sriId){
        try {
            DataSupport dh = new DataSupport();
            dh.executeUpdate("DELETE FROM spoilage_report_items WHERE id = " + sriId + ";");
        } catch (SQLException ex) {
            Logger.getLogger(SpoilageInventoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void add(int ingredientId){
       Double quantity=0.0;
       boolean isValid = false;
       do{
           try{
              quantity = Double.parseDouble(JOptionPane.showInputDialog(view, "INPUT Quantity:"));
              isValid=true;
           }catch(NumberFormatException e){}
       }while(!isValid);

        try {
            // if there exists a spoilage report id
            DataSupport dh = new DataSupport();
            String srSql = "SELECT id FROM spoilage_reports WHERE date_of_spoilage = CURDATE() AND status = 'Active';";
            BaseTableModel sr = dh.executeQuery(srSql);
            String srId = null;
            String insertSr = "";
            // get sri ID
            if(sr.rows.size() > 0){
                srId = sr.getValueAt(0, 0).toString();
            } 
            // else insert
            else{
                insertSr = "INSERT INTO spoilage_reports VALUES (NULL, CURDATE(), 'Active');";
                
                srId = "LAST_INSERT_ID() ";
            }
            String insertSri = "INSERT INTO spoilage_report_items(spoilage_report_id, quantity, ingredient_id, status)" +
                    " VALUES(" + srId+", " + quantity.toString() + ", " + ingredientId +", 'Active');";
            DataSupport dh1 = new DataSupport();
            List<String> strs = new ArrayList<String>();
            if(!insertSr.isEmpty())
                strs.add(insertSr);
            strs.add(insertSri);
            dh1.executeBatchUpdate(strs);
        } catch (SQLException ex) {
            Logger.getLogger(SpoilageInventoryController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(view, ex.toString());
        }

    }


    public boolean save(BaseTableModel spoilage){
        boolean result = false;
        List<String> sqls = new ArrayList<String>();
        SpoilageReportItemsDBTable db = SpoilageReportItemsDBTable.getInstance();

        for(DataRow row : spoilage.rows){
            String id = row.get(SpoilageReportItemsDBTable.ID).toString();
            String quantity = row.get(SpoilageReportItemsDBTable.QUANTITY).toString();
            String description = row.get(SpoilageReportItemsDBTable.DESCRIPTION).toString();

            Map<String, String> primaries = new HashMap<String, String>();
            primaries.put(SpoilageReportItemsDBTable.ID, id);
            Map<String, String> values = new HashMap<String, String>();
            values.put(SpoilageReportItemsDBTable.QUANTITY, quantity);
            values.put(SpoilageReportItemsDBTable.DESCRIPTION, description);

            sqls.add(db.generateUpdateSql(values, primaries));
        }

        DataSupport dh;

        try {
            dh = new DataSupport();
            dh.executeBatchUpdate(sqls);
        } catch (SQLException ex) {
            Logger.getLogger(SpoilageInventoryController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

   


}

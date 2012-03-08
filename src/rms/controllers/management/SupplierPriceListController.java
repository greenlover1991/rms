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
import rms.ProjectConstants;
import rms.models.BaseTableModel;
import rms.models.DataRow;
import rms.models.management.SupplierDBTable;
import rms.models.management.SupplierPriceListDBTable;
import rms.views.management.SupplierPriceListView;
import supports.DataSupport;

/**
 *
 * @author squeekyclean
 */
public class SupplierPriceListController {

    private SupplierPriceListView view;
    private BaseTableModel model;

    public SupplierPriceListController(SupplierPriceListView view){
        this.view = view;
        this.model = new BaseTableModel();
    }

    public BaseTableModel refreshData(){
        try {
            SupplierDBTable db = SupplierDBTable.getInstance();
            String query = db.generateSelectAllWithDefaultAliasesSql();
            DataSupport dh = new DataSupport();
            model = dh.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(SupplierPriceListController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(view, ex.toString());
        }
        return model;
    }

  public boolean save(BaseTableModel spl){
        boolean result = false;
        List<String> sqls = new ArrayList<String>();
        SupplierPriceListDBTable db = SupplierPriceListDBTable.getInstance();

        for(DataRow row : spl.rows){
            sqls.add(db.generateCreateUpdateSql(row.getRowAsStrings()));
        }

        DataSupport dh;

        try {
            dh = new DataSupport();
            dh.executeBatchUpdate(sqls);
        } catch (SQLException ex) {
            Logger.getLogger(SupplierPriceListController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }
  public boolean savePriceList(BaseTableModel spl){
        boolean result = false;
        List<String> sqls = new ArrayList<String>();
        SupplierPriceListDBTable db = SupplierPriceListDBTable.getInstance();

        for(DataRow row : spl.rows){
            Map<String, String> updateList = new HashMap<String, String>();
            updateList.put("price", row.get("price").toString());
            Map<String, String> primary = new HashMap<String,String>();
            primary.put("id", row.get("id").toString());
            sqls.add(db.generateUpdateSql(updateList, primary));
        }

        DataSupport dh;

        try {
            dh = new DataSupport();
            dh.executeBatchUpdate(sqls);
        } catch (SQLException ex) {
            Logger.getLogger(SupplierPriceListController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }
    public BaseTableModel loadIngredients(int supplierId){
         String query = String.format("SELECT  i.id AS ID, i.name AS Name "
                                    + "FROM ingredients i "
                                    + "WHERE id NOT "
                                    + "IN ("

                                    + "SELECT s.ingredient_id "
                                    + "FROM supplier_price_lists s "
                                    + "WHERE s.supplier_id = %d"
                                    + ")", supplierId);
         BaseTableModel ingredients = null;
        try {
            DataSupport dh = new DataSupport();
            ingredients = dh.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(SupplierPriceListController.class.getName()).log(Level.SEVERE, null, ex);
        }
            return ingredients;
    }
     public BaseTableModel loadPriceList(int supplierId){
         String query = String.format("SELECT s.id, s.supplier_id,s.ingredient_id, i.name as Name, s.price "
                                    + "FROM ingredients i "
                                    + "inner join supplier_price_lists s "
                                    + "on i.id=s.ingredient_id "
                                    + "WHERE s.supplier_id = %d ;", supplierId);
         BaseTableModel pricelist = null;
        try {
            DataSupport dh = new DataSupport();
            pricelist = dh.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(SupplierPriceListController.class.getName()).log(Level.SEVERE, null, ex);
        }
            return pricelist;
    }
     

   public boolean removeIngredientFromPriceList(int IngId, int SupplierId){
        boolean result=false;
        try{
        String query=String.format("Delete from supplier_price_lists "
                                    + "WHERE ingredient_id = %d AND supplier_id=%d ; ", IngId, SupplierId);

        DataSupport dh = new DataSupport();
        dh.executeUpdate(query);
        result=true;
        }catch(SQLException ex){
            Logger.getLogger(SupplierPriceListController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(view, ex.toString());
        }
        return result;
    }
   public boolean AddIngredientToPriceList(int IngId, int SupplierId){
       Double price=0.0;
       boolean isValid = false;
       do{
           try{
              price = Double.parseDouble(JOptionPane.showInputDialog(view, "INPUT PRICE:"));
              isValid=true;
           }catch(NumberFormatException e){}
       }while(!isValid);

        boolean result = false;
         try{
            SupplierPriceListDBTable db = SupplierPriceListDBTable.getInstance();
            Map<String,String> map=new HashMap<String, String>();
            map.put(SupplierPriceListDBTable.INGREDIENT_ID, IngId+"");
            map.put(SupplierPriceListDBTable.PRICE, price+"");
            map.put(SupplierPriceListDBTable.SUPPLIER_ID, SupplierId+"" );
            map.put(SupplierPriceListDBTable.STATUS,ProjectConstants.STATUS_ACTIVE +"" );


            String query = db.generateInsertSql(map);
            DataSupport dh = new DataSupport();
            dh.executeUpdate(query);
            result = true;
        }
         catch(SQLException ex){
             Logger.getLogger(SupplierPriceListController.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(view, ex.toString());
         }
            return result;
    }
              
}
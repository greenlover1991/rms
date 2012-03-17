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
import rms.models.management.RecipeDBTable;
import rms.models.management.MenuItemsDBTable;
import rms.views.management.MenuItemsView;
import supports.DataSupport;

/**
 *
 * @author squeekyclean
 */
public class MenuItemsController {

    private MenuItemsView view;
    private BaseTableModel model;

    public MenuItemsController(MenuItemsView view){
        this.view = view;
        this.model = new BaseTableModel();
    }

    public BaseTableModel refreshData(){
        String query = String.format("SELECT mi.id AS 'menu item id', mi.name, mi.description, mi.recipe_procedure, mi.seconds_to_cook AS 'time to cook', mi.price ,mc.id AS 'category id', mc.name AS 'category' "

                                    + "FROM menu_items mi "
                                    + "inner join menu_categories mc "
                                    + "on mi.menu_category_id=mc.id ");
        try {

            DataSupport dh = new DataSupport();
            model = dh.executeQueryUsingAlias(query);
        } catch (SQLException ex) {
            Logger.getLogger(MenuItemsController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(view, ex.toString());
        }
        return model;
    }
    
   public Map getCategories(){
       Map<String, Integer> menuCats = new HashMap<String, Integer>();
       try {
            DataSupport dh = new DataSupport();
            BaseTableModel res = dh.executeQuery("SELECT id, name FROM menu_categories WHERE status = 'Active';");

            for(DataRow row : res.rows){
                Integer id = new Integer(row.get(0).toString());
                String name = row.get(1).toString();
                menuCats.put(name, id);
            }
       }catch(SQLException ex){
            Logger.getLogger(MenuItemsController.class.getName()).log(Level.SEVERE, null, ex);
       }
       return menuCats;
   }

    public boolean save(){
        boolean result = false;
        List<String> sqls = new ArrayList<String>();
        MenuItemsDBTable db = MenuItemsDBTable.getInstance();

        for(DataRow row : model.rows){
            Map<String, String> upsert= new HashMap<String, String>();
            if(!(row.get("menu item id") == null))
                upsert.put("id", row.get("menu item id").toString());
            upsert.put("name", row.get("name").toString());
            upsert.put("price", row.get("price").toString());
            upsert.put("menu_category_id", row.get("category id").toString());
            upsert.put(MenuItemsDBTable.RECIPE_PROC, view.Procedure.getText());
            sqls.add(db.generateCreateUpdateSql(upsert));
        }

        DataSupport dh;

        try {
            dh = new DataSupport();
            dh.executeBatchUpdate(sqls);
        } catch (SQLException ex) {
            Logger.getLogger(MenuItemsController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }
    public boolean saveRecipe(BaseTableModel spl){
        boolean result = false;
        List<String> sqls = new ArrayList<String>();
        RecipeDBTable db = RecipeDBTable.getInstance();

        for(DataRow row : spl.rows){
            Map<String, String> updateList = new HashMap<String, String>();
            updateList.put("quantity", row.get("quantity").toString());
            Map<String, String> primary = new HashMap<String,String>();
            primary.put("menu_item_id", row.get("menu_item_id").toString());
            primary.put("ingredient_id", row.get("ingredient_id").toString());
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
    public BaseTableModel loadIngredients(int menuItemId){
         String query = String.format("SELECT  i.id AS ID, i.name AS Name "
                                    + "FROM ingredients i "
                                    + "WHERE id NOT "
                                    + "IN ("

                                    + "SELECT r.ingredient_id "
                                    + "FROM recipes r "
                                    + "WHERE r.menu_item_id = %d"
                                    + ")", menuItemId);
         BaseTableModel ingredients = null;
        try {
            DataSupport dh = new DataSupport();
            ingredients = dh.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(MenuItemsController.class.getName()).log(Level.SEVERE, null, ex);
        }
            return ingredients;
    }
     public BaseTableModel loadIngredientsOnRecipe(int menuItemId){
         String query = String.format("SELECT r.ingredient_id, r.menu_item_id, i.name as Name, i.unit_of_measure as 'Unit of Measure', r.quantity AS 'Needed Qty' "
                                    + "FROM ingredients i "
                                    + "inner join recipes r "
                                    + "on r.ingredient_id=i.id "
                                    + "WHERE r.menu_item_id = %d ;", menuItemId);
         BaseTableModel ingredients = null;
        try {
            DataSupport dh = new DataSupport();
            ingredients = dh.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(MenuItemsController.class.getName()).log(Level.SEVERE, null, ex);
        }
            return ingredients;
    }
     public BaseTableModel loadProcedure(int menuItemId){
         String query = String.format("SELECT mi.recipe_procedure "
                                    + "FROM menu_items mi "
                                    + "WHERE mi.id = %d ;", menuItemId);
         BaseTableModel ingredients = null;
        try {
            DataSupport dh = new DataSupport();
            ingredients = dh.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(MenuItemsController.class.getName()).log(Level.SEVERE, null, ex);
        }
            return ingredients;
    }
    
    public boolean addIngredientToRecipe(int menuItemID, int ingID){
        Double qty=0.0;
       boolean isValid = false;
       do{
           try{
              qty = Double.parseDouble(JOptionPane.showInputDialog(view, "INPUT QUANTITY:"));
              isValid=true;
           }catch(NumberFormatException e){}
       }while(!isValid);
        boolean result = false;
        
         try{
            RecipeDBTable db = RecipeDBTable.getInstance();
            Map<String,String> map=new HashMap<String, String>();
            map.put(RecipeDBTable.MENU_ITEM_ID, menuItemID+"");
            map.put(RecipeDBTable.INGREDIENT_ID, ingID+"");
            map.put(RecipeDBTable.QTY, qty+"" );

            String query = db.generateInsertSql(map);
            DataSupport dh = new DataSupport();
            dh.executeUpdate(query);
            result = true;
        }
         catch(SQLException ex){
             Logger.getLogger(MenuItemsController.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(view, ex.toString());
         }
            return result;

    }
    public boolean removeIngredientFromRecipe(int IngId, int MenuItemId){
        boolean result=false;
        try{
        String query=String.format("Delete from recipes "
                                    + "WHERE recipes.ingredient_id = %d AND recipes.menu_item_id=%d ; ", IngId, MenuItemId);

        DataSupport dh = new DataSupport();
        dh.executeUpdate(query);
        result=true;
        }catch(SQLException ex){
            Logger.getLogger(MenuItemsController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(view, ex.toString());
        }
        return result;
    }
}

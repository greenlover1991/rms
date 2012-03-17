/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rms.controllers.ordering;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import rms.ProjectConstants;
import rms.controllers.management.SupplierPriceListController;
import rms.models.BaseTableModel;
import rms.models.DataRow;
import rms.models.ordering.OrderSlipItemsDBTable;
import rms.views.ordering.OrderSlipView;
import supports.DataSupport;
import supports.NotificationSupport;

/**
 *
 * @author squeekyclean
 */
public class OrderSlipController extends NotificationSupport {
    OrderSlipView view;
    public OrderSlipController(OrderSlipView view){
        super();
        this.view = view;
        loadWaiters();
    }
    public OrderSlipController() {
    	
    }

    public BaseTableModel loadMenuItems(){
        BaseTableModel result = null;
        try {

            String query = "SELECT mi.name AS Name, mi.id AS 'Menu category', mc.name AS Category, mi.price AS Price, MIN( CAST( i.quantity / r.quantity AS UNSIGNED ) ) AS Stocks " +
                    "FROM menu_items mi " +
                    "INNER JOIN recipes r ON mi.id = r.menu_item_id " +
                    "INNER JOIN ingredients i ON i.id = r.ingredient_id " +
                    "INNER JOIN menu_categories mc ON mc.id = mi.menu_category_id " +
                    "WHERE mi.status = 'Active' " +
                    "GROUP BY r.menu_item_id";
            DataSupport dh = new DataSupport();
            BaseTableModel temp = dh.executeQueryUsingAlias(query);
            result = new BaseTableModel(temp.columnNames, temp.columnAliases, temp.columnClasses) {

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return false;
                }
            };
            result.rows = temp.rows;

        } catch (SQLException ex) {
            Logger.getLogger(OrderSlipController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public BaseTableModel loadOrderSlips(){
        BaseTableModel result = null;

        DataSupport dh;
        try {
            dh = new DataSupport();
            String query = "SELECT os.id AS  'Order No.', GROUP_CONCAT( CAST( t.table_number AS CHAR ) " +
                "ORDER BY t.table_number ASC ) AS  'Table No.', os.grand_total AS Balance, e.login AS Waiter " +
                "FROM (SELECT * FROM order_slips WHERE status = 'Active' AND order_status != 'Tendered' AND order_status != 'Cancelled') os " +
                "INNER JOIN employees e ON os.waited_by = e.id " +
                "LEFT OUTER JOIN restaurant_tables t ON os.id = t.order_slip_id " +
                "GROUP BY os.id, os.grand_total, e.login, os.is_takeout";
            BaseTableModel temp = dh.executeQuery(query);
            result = new BaseTableModel(temp.columnNames, temp.columnAliases, temp.columnClasses){

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return false;
                }

            };
            result.rows = temp.rows;
        } catch (SQLException ex) {
            Logger.getLogger(OrderSlipController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public void loadOrderSlipDetails(int orderSlipId) {
        try {
            String query = String.format("SELECT os.id, os.datetime_of_order, GROUP_CONCAT( CAST( t.table_number AS CHAR ) " +
                    "ORDER BY t.table_number ASC ) AS  'Table No.', os.is_takeout, os.number_of_customers, os.total_amount, os.total_discount_amount, e.login, os.grand_total " +
                    "FROM order_slips os " +
                    "INNER JOIN restaurant_tables t ON t.order_slip_id = os.id " +
                    "LEFT OUTER JOIN employees e ON e.id = os.waited_by " +
                    "WHERE os.id = %d", orderSlipId);
            DataSupport dh = new DataSupport();
            BaseTableModel model = dh.executeQuery(query);
            
            // set views
            Date datetime = (Date)model.getValueAt(0, 1);
            String tables = model.getValueAt(0, 2) == null ? "" : model.getValueAt(0,2).toString();
            String customers = model.getValueAt(0, 4) == null ? "0" : model.getValueAt(0,4).toString();
            double totalAmount = Double.parseDouble(model.getValueAt(0, 5) == null ? "0" : model.getValueAt(0,5).toString());
            double totalDiscountAmount = Double.parseDouble(model.getValueAt(0, 6) == null ? "0" : model.getValueAt(0,6).toString());
            String waiter = model.getValueAt(0, 7).toString();
            double grandAmount = Double.parseDouble(model.getValueAt(0, 8) == null ? "0" : model.getValueAt(0,8).toString());
            view.prevTables.delete(0, view.prevTables.length());
            view.prevTables.append(tables);
            view.txtOrderSlipId.setText(orderSlipId+"");
            SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy HH:mm");
            view.lblDate.setText(format.format(datetime));
            view.txtTables.setText(tables);
            view.txtCustomers.setValue(new Integer(customers));
            view.cmbWaiters.setSelectedItem(waiter);
            view.txtNetAmount.setText(totalAmount + "");
            view.txtNetDiscount.setText(totalDiscountAmount + "");
            view.txtGrandTotal.setText(grandAmount + "");


        } catch (SQLException ex) {
            Logger.getLogger(OrderSlipController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadWaiters() {
        try {
            DataSupport dh = new DataSupport();
            String query = "SELECT login FROM employees WHERE status = 'Active';";
            BaseTableModel model = dh.executeQuery(query);
            Object[] waiters = new Object[model.rows.size()];
            for (int i = 0; i < model.rows.size(); i++) {
                waiters[i] = model.getValueAt(i, 0).toString();
            }
            view.cmbWaiters.setModel(new DefaultComboBoxModel(waiters));
        } catch (SQLException ex) {
            Logger.getLogger(OrderSlipController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateOrderSlipDetails(){
        String orderSlipId = view.txtOrderSlipId.getText();
        if(!orderSlipId.isEmpty()){
            String tbs = view.txtTables.getText();
            int noOfCustomers = Integer.parseInt(view.txtCustomers.getValue().toString());
            String waiterName = view.cmbWaiters.getSelectedItem().toString();
            int isTakeout = tbs.trim().isEmpty() ? 1 : 0;

            String updateOS = String.format("UPDATE order_slips SET number_of_customers= %d, is_takeout = %d, " +
                    "waited_by = (SELECT id FROM employees WHERE login = '%s') " +
                    "WHERE id = %s;", noOfCustomers, isTakeout, waiterName, orderSlipId);
            String availTables = String.format("UPDATE restaurant_tables SET table_status = 'Available', order_slip_id = null " +
                "WHERE table_number IN (%s);", view.prevTables);
            String occupyTables = String.format("UPDATE restaurant_tables SET table_status = 'Occupied', order_slip_id = %s " +
                "WHERE table_number IN (%s);", orderSlipId, tbs);
            List<String> sqls = new ArrayList<String>();
            sqls.add(updateOS);
            if(view.prevTables.length() > 0){
                sqls.add(availTables);
            }
            if(isTakeout == 0){
                sqls.add(occupyTables);
            }
            try {
                DataSupport dh = new DataSupport();
                dh.executeBatchUpdate(sqls);

            } catch (SQLException ex) {
                Logger.getLogger(OrderSlipView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void cancelOrderSlip(String orderSlipId){
        try {
            String cancelOSItems = String.format("UPDATE order_slip_items SET order_status = 'Cancelled' WHERE order_slip_id = %s;", orderSlipId);
            String cancelOS = String.format("UPDATE order_slips SET order_status = 'Cancelled' WHERE id = %s;", orderSlipId);
            String updateTables = String.format("UPDATE restaurant_tables set table_status = 'Available', order_slip_id = null WHERE order_slip_id = %s;", orderSlipId);
            List<String> sqls = Arrays.asList(new String[]{cancelOSItems, cancelOS, updateTables});
            DataSupport dh = new DataSupport();
            dh.executeBatchUpdate(sqls);
        } catch (SQLException ex) {
            Logger.getLogger(OrderSlipController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public BaseTableModel loadOrderItems(int orderSlipId){
        BaseTableModel result = null;
        try {

            String query = String.format("SELECT osi.id, osi.quantity AS Quantity, mi.name AS Name, osi.description AS 'Notes', osi.unit_cost AS 'Price', osi.amount AS 'Amount', osi.discounted_items AS 'Disc. items', osi.discount_rate AS 'Disc. rate', osi.discount_fixed_amount AS 'Fixed Disc. Amount', osi.net_amount AS 'Net Amount', osi.order_status AS 'Status' " +
                    "FROM order_slip_items osi " +
                    "INNER JOIN menu_items mi ON mi.id = osi.menu_item_id " +
                    "WHERE osi.order_slip_id = %d;", orderSlipId);
            DataSupport dh = new DataSupport();
            BaseTableModel temp = dh.executeQuery(query);
            result = new BaseTableModel(temp.columnNames, temp.columnAliases, temp.columnClasses) {

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    // if status pending, quantity can be edited
                    // if discounted item, discounted fix, rate = all editable
                    if(columnIndex >= 6 && columnIndex <= 8){
                        return true;
                    }
                    else if((columnIndex == 1 || columnIndex == 3) && ProjectConstants.ORDER_ITEM_STATUS_PENDING.equals(getValueAt(rowIndex, 10).toString())){
                        return true;
                    }
                    else
                        return false;
                }
            };
            result.rows = temp.rows;

        } catch (SQLException ex) {
            Logger.getLogger(OrderSlipController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public BaseTableModel loadOrderItemsMinimal(int orderSlipId){
        BaseTableModel result = null;
        try {

            String query = String.format("SELECT osi.id, mi.name AS Name, osi.quantity AS Quantity, osi.unit_cost AS 'Price', osi.amount AS 'Amount', osi.order_status AS 'Status' " +
                    "FROM order_slip_items osi " +
                    "INNER JOIN menu_items mi ON mi.id = osi.menu_item_id " +
                    "WHERE osi.order_slip_id = %d;", orderSlipId);
            DataSupport dh = new DataSupport();
            BaseTableModel temp = dh.executeQuery(query);
            result = new BaseTableModel(temp.columnNames, temp.columnAliases, temp.columnClasses) {

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    // if status pending, quantity can be edited
                    // if discounted item, discounted fix, rate = all editable
                    if(columnIndex >= 6 && columnIndex <= 8){
                        return true;
                    }
                    else if((columnIndex == 1 || columnIndex == 3) && ProjectConstants.ORDER_ITEM_STATUS_PENDING.equals(getValueAt(rowIndex, 10).toString())){
                        return true;
                    }
                    else
                        return false;
                }
            };
            result.rows = temp.rows;

        } catch (SQLException ex) {
            Logger.getLogger(OrderSlipController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public boolean addMenuItemId(int menuItemId, int orderSlipId) {
       int quantity = 0;
       boolean isValid = false;
       do{
           try{
              String option = JOptionPane.showInputDialog(view, "INPUT Quantity:");
              quantity = Integer.parseInt(option);
              isValid=true;
           }catch(NumberFormatException e){}
       }while(!isValid);

        boolean result = false;
        if(quantity > 0){
            try{


                String query = String.format("INSERT INTO order_slip_items (order_slip_id, quantity, menu_item_id, unit_cost, amount, order_status, net_amount, datetime_of_order, status, discounted_items, discount_fixed_amount, discount_rate) " +
                    "VALUES(%d, %d, %d, (SELECT price FROM menu_items WHERE id = %d), quantity*unit_cost, '%s', quantity*unit_cost, NOW(), '%s', 0,0,0);",
                    orderSlipId, quantity, menuItemId, menuItemId, ProjectConstants.ORDER_ITEM_STATUS_PENDING, ProjectConstants.STATUS_ACTIVE);
                DataSupport dh = new DataSupport();
                dh.executeUpdate(query);
                result = true;
            }
                catch(SQLException ex){
                Logger.getLogger(SupplierPriceListController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(view, ex.toString());
            }
        }
        return result;
    }

    public void removeOrderItem(int orderItemId) {
        try {
            String query = String.format("UPDATE order_slip_items SET order_status = 'Cancelled' WHERE id = %d", orderItemId);
            DataSupport dh = new DataSupport();
            dh.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(OrderSlipController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateOrderSlip(int orderSlipId){
        String query = String.format("UPDATE order_slips, (SELECT SUM(amount) AS t_amount, " +
                            "SUM((discounted_items*unit_cost*discount_rate) + discount_fixed_amount) AS t_d_amount, " +
                            "SUM(net_amount) AS g_amount " +
                            "FROM order_slip_items " +
                            "WHERE order_slip_id = %d " +
                            "AND order_status != 'Pending' AND order_status != 'Cancelled') AS osi " +
                        "SET total_amount = t_amount, " +
                        "total_discount_amount = t_d_amount, " +
                        "grand_total = g_amount " +
                        "WHERE id = %d;", orderSlipId, orderSlipId);
        
        try {
            DataSupport dh;
            dh = new DataSupport();
            dh.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(OrderSlipController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateOSI(BaseTableModel osi, int orderSlipId) {
        List<String> sqls = new ArrayList<String>();
        for(DataRow row : osi.rows){
            int osiId = Integer.parseInt(row.get(OrderSlipItemsDBTable.ID).toString());
            int quantity = Integer.parseInt(row.get(OrderSlipItemsDBTable.QUANTITY).toString());
            Object desc = row.get(OrderSlipItemsDBTable.DESCRIPTION);
            String notes = (desc == null ? "" : desc.toString());
            int discItems = Integer.parseInt(row.get(OrderSlipItemsDBTable.DISCOUNTED_ITEMS).toString());
            double discRate = Double.parseDouble(row.get(OrderSlipItemsDBTable.DISCOUNT_RATE).toString());
            double discFixed = Double.parseDouble(row.get(OrderSlipItemsDBTable.DISCOUNT_FIXED_AMOUNT).toString());
            String query = String.format("UPDATE order_slip_items SET quantity = %d, description = '%s', " +
                    "discounted_items = %d, discount_rate = %f, discount_fixed_amount = %f, amount = quantity * unit_cost, " +
                    "net_amount = amount-(discounted_items*unit_cost*discount_rate)-discount_fixed_amount " +
                    "WHERE id = %d;", quantity, notes, discItems, discRate, discFixed, osiId);
            sqls.add(query);

        }
       
        try {
            DataSupport dh = new DataSupport();
            dh.executeBatchUpdate(sqls);
            updateOrderSlip(orderSlipId);
        } catch (SQLException ex) {
            Logger.getLogger(OrderSlipController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    public void queueOrderItems(int[] orderItemIds, int orderSlipId) {
        try {
            StringBuilder osiIds = new StringBuilder();
            for (int i : orderItemIds) {
                osiIds.append(i + ",");
            }
            osiIds.deleteCharAt(osiIds.length() - 1);
            String query = String.format("UPDATE order_slip_items " +
                    "SET order_status = 'Queued', " +
                    "datetime_of_order = NOW() " +
                    "WHERE id IN (%s) " +
                    "AND (order_status = 'Pending' OR order_status = 'Cancelled');", osiIds.toString());
            DataSupport dh = new DataSupport();
            dh.executeUpdate(query);
            updateIngredientInventory(orderItemIds);
            updateOrderSlip(orderSlipId);
        } catch (SQLException ex) {
            Logger.getLogger(OrderSlipController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void updateIngredientInventory(int[] orderItemIds) {
        StringBuilder osiIds = new StringBuilder();
        for (int i : orderItemIds) {
            osiIds.append(i + ",");
        }
        osiIds.deleteCharAt(osiIds.length() - 1);

        String query = String.format("UPDATE ingredients i, (SELECT i.id AS 'ingredient_id', r.quantity * osi.quantity AS  'used' " +
                                                "FROM order_slip_items osi " +
                                                "INNER JOIN menu_items mi ON mi.id = osi.menu_item_id " +
                                                "INNER JOIN recipes r ON r.menu_item_id = osi.menu_item_id " +
                                                "INNER JOIN ingredients i ON i.id = r.ingredient_id " +
                                                "WHERE osi.id " +
                                                "IN ( %s ) ) osi " +
                        "SET quantity = quantity - osi.used " +
                        "WHERE i.id = osi.ingredient_id", osiIds);

        try {
            DataSupport dh = new DataSupport();
            dh.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(OrderSlipController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void processBroadcastMessage(BROADCAST b) {
        
            view.performTblOrderSlipClick();
    }

}

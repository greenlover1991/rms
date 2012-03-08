/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rms.controllers.ordering;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import rms.models.BaseTableModel;
import rms.views.ordering.OrderSlipView;
import supports.DataSupport;

/**
 *
 * @author squeekyclean
 */
public class OrderSlipController {
    OrderSlipView view;
    public OrderSlipController(OrderSlipView view){
        this.view = view;
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
                "ORDER BY t.table_number ASC ) AS  'Table No.', os.grand_total AS Balance, e.login AS Waiter, os.is_takeout 'Take out' " +
                "FROM order_slips os " +
                "INNER JOIN employees e ON os.waited_by = e.id " +
                "INNER JOIN restaurant_tables t ON os.id = t.order_slip_id " +
                "WHERE os.status =  'Active' " +
                "   AND os.order_status !=  'Tendered' " +
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
}

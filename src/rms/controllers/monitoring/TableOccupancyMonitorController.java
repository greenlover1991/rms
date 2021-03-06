package rms.controllers.monitoring;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

import rms.controllers.management.BranchController;
import rms.controllers.ordering.OrderSlipController;
import rms.models.BaseTableModel;
import rms.views.monitoring.ChefQueueView;
import rms.views.monitoring.TableOccupancyMonitorView;
import supports.DataSupport;
import supports.NotificationSupport;

/*
 * @author Yu
 *
 */
public class TableOccupancyMonitorController extends NotificationSupport{
	private TableOccupancyMonitorView view;
	private BaseTableModel model;

	public TableOccupancyMonitorController(TableOccupancyMonitorView view) {
		this.view = view;
		this.model = new BaseTableModel();
	}

	public BaseTableModel refresh() {
		try {
			DataSupport dh = new DataSupport();
			String query = "SELECT RT.id AS ID, RT.table_number AS 'Table Number', RT.table_status AS Status "
					+ "FROM restaurant_tables RT ORDER BY RT.table_number ASC";
			model = dh.executeQuery(query);
		} catch (SQLException ex) {
			Logger.getLogger(BranchController.class.getName()).log(
					Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(view, ex.toString());
		}
		return model;
	}

	public BaseTableModel countTables() {
		try {
			DataSupport dh = new DataSupport();
			String query = "SELECT COUNT(*) FROM restaurant_tables ";
			model = dh.executeQuery(query);
		} catch (SQLException ex) {
			Logger.getLogger(BranchController.class.getName()).log(
					Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(view, ex.toString());
		}
		return model;
	}

	public void cleanTable(int tableNumber) {
		try {
			DataSupport dh = new DataSupport();
			String query = "UPDATE restaurant_tables "
					+ "SET table_status = 'Available' "
					+ "WHERE table_number = ' " + tableNumber + " ' ";
			dh.executeUpdate(query);
		} catch (SQLException ex) {
			Logger.getLogger(BranchController.class.getName()).log(
					Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(view, ex.toString());
		}
	}

	 public BaseTableModel findTableStatus(int tableNumber) {
	 try {
	 DataSupport dh = new DataSupport();
	 String query = "SELECT RT.table_status AS Status "
	 + "FROM restaurant_tables RT WHERE RT.table_number = '"
	 + tableNumber + "' ";
	 model = dh.executeQuery(query);
	 } catch (SQLException ex) {
	 Logger.getLogger(BranchController.class.getName()).log(
	 Level.SEVERE, null, ex);
	 JOptionPane.showMessageDialog(view, ex.toString());
	 }
	 return model;
	 }
	 
	 public BaseTableModel findTableOrderSlip(int tableNumber) {
		 try {
		 DataSupport dh = new DataSupport();
		 String query = "SELECT RT.order_slip_id  "
		 + "FROM restaurant_tables RT WHERE RT.table_number = '"
		 + tableNumber + "' ";
		 model = dh.executeQuery(query);
		 } catch (SQLException ex) {
		 Logger.getLogger(BranchController.class.getName()).log(
		 Level.SEVERE, null, ex);
		 JOptionPane.showMessageDialog(view, ex.toString());
		 }
		 return model;
		 }

    public void setStatusTo(int parseInt, String ORDER_ITEM_STATUS_SERVED) {
        ChefQueueController controller = new ChefQueueController(null);
        controller.setStatusTo(parseInt, ORDER_ITEM_STATUS_SERVED);
    }

    public TableModel refreshProcessing(int orderSlipId) {
        OrderSlipController controller = new OrderSlipController();
        return controller.loadOrderItemsMinimal(orderSlipId);
    }

    @Override
    public void processBroadcastMessage(BROADCAST b) {
        view.refreshTOM();
    }

}

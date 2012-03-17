package rms.controllers.monitoring;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import rms.ProjectConstants;
import rms.controllers.management.BranchController;
import rms.models.BaseTableModel;
import rms.views.monitoring.ChefQueueView;
import rms.views.reporting.SalesReportView;
import supports.DataSupport;
import supports.NotificationSupport;

/*
 * @author Yu
 *
 */
public class ChefQueueController extends NotificationSupport{
	private ChefQueueView view;
	private BaseTableModel model;

	public ChefQueueController(ChefQueueView view) {
		this.view = view;
		this.model = new BaseTableModel();
	}

	public BaseTableModel refreshQueue() {
		try {
			DataSupport dh = new DataSupport();
			String query = "SELECT OSI.id, MI.name AS Queued, OSI.description AS 'Special Instructions' "
					+ "FROM order_slip_items OSI "
					+ "INNER JOIN menu_items MI "
					+ "ON OSI.menu_item_id = MI.id "
					+ "WHERE OSI.order_status = '" + ProjectConstants.ORDER_ITEM_STATUS_QUEUED + "' "
					+ "ORDER BY OSI.datetime_of_order";
			model = dh.executeQuery(query);
		} catch (SQLException ex) {
			Logger.getLogger(BranchController.class.getName()).log(
					Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(view, ex.toString());
		}
		return model;
	}

	public BaseTableModel refreshProcessing() {
		try {
			DataSupport dh = new DataSupport();
			String query = "SELECT OSI.id, MI.name AS Processing "
					+ "FROM order_slip_items OSI "
					+ "INNER JOIN menu_items MI "
					+ "ON OSI.menu_item_id = MI.id "
					+ "WHERE OSI.order_status = '" + ProjectConstants.ORDER_ITEM_STATUS_PROCESSING + "' "
					+ "ORDER BY OSI.datetime_of_order";
			model = dh.executeQuery(query);
		} catch (SQLException ex) {
			Logger.getLogger(BranchController.class.getName()).log(
					Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(view, ex.toString());
		}
		return model;
	}

	public void setStatusTo(int id, String status) {
		try {
			DataSupport dh = new DataSupport();
			String query = "UPDATE order_slip_items " + "SET order_status = '"
					+ status + "' " + "WHERE id = '" + id + "' ";
			dh.executeUpdate(query);
		} catch (SQLException ex) {
			Logger.getLogger(BranchController.class.getName()).log(
					Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(view, ex.toString());
		}
	}

    @Override
    public void processBroadcastMessage(BROADCAST b) {
        view.refreshChefQueue();
    }

}

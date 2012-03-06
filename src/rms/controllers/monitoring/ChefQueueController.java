package rms.controllers.monitoring;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import rms.controllers.management.BranchController;
import rms.models.BaseTableModel;
import rms.views.monitoring.ChefQueueView;
import rms.views.reporting.SalesReportView;
import supports.DataSupport;

/*
 * @author Yu
 *
 */
public class ChefQueueController {
	private ChefQueueView view;
	private BaseTableModel model;

	public ChefQueueController(ChefQueueView view) {
		this.view = view;
		this.model = new BaseTableModel();
	}

	public BaseTableModel refreshQueue() {
		try {
			DataSupport dh = new DataSupport();
			String query = "SELECT MI.name AS Queued "
					+ "FROM order_slip_items OSI "
					+ "INNER JOIN menu_items MI "
					+ "ON OSI.menu_item_id = MI.id "
					+ "WHERE OSI.status = 'Queued'";
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
			String query = "SELECT MI.name AS Processing "
					+ "FROM order_slip_items OSI "
					+ "INNER JOIN menu_items MI "
					+ "ON OSI.menu_item_id = MI.id "
					+ "WHERE OSI.status = 'Processing'";
			model = dh.executeQuery(query);
		} catch (SQLException ex) {
			Logger.getLogger(BranchController.class.getName()).log(
					Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(view, ex.toString());
		}
		return model;
	}


}

package rms.controllers.reporting;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import rms.controllers.management.BranchController;
import rms.models.BaseTableModel;
import rms.models.reporting.SalesReportModel;
import rms.views.reporting.SalesReportView;
import supports.DataSupport;

public class SalesReportController {
	private SalesReportView view;
	private BaseTableModel model;

	public SalesReportController(SalesReportView view) {
		this.view = view;
		this.model = new BaseTableModel();
	}

	public BaseTableModel refresh() {
		try {
			DataSupport dh = new DataSupport();
			String query = "SELECT MI.name AS Particular, OSI.quantity AS Sold " +
					"FROM order_slip_items OSI " +
					"INNER JOIN menu_items MI " +
					"ON OSI.menu_item_id = MI.id";
			model = dh.executeQuery(query);
		} catch (SQLException ex) {
			Logger.getLogger(BranchController.class.getName()).log(
					Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(view, ex.toString());
		}
		return model;
	}

	public BaseTableModel totalCashSales() {
		BaseTableModel result = null;
		try {
			DataSupport dh = new DataSupport();
			String query = "SELECT SUM(amount) AS Cash FROM cash_payments";
			result = dh.executeQuery(query);
		} catch (SQLException ex) {
			Logger.getLogger(BranchController.class.getName()).log(
					Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(view, ex.toString());
		}
		return result;
	}

	public BaseTableModel totalCardSales() {
		BaseTableModel result = null;
		try {
			DataSupport dh = new DataSupport();
			String query = "SELECT SUM(amount) AS Card FROM credit_card_payments";
			result = dh.executeQuery(query);
		} catch (SQLException ex) {
			Logger.getLogger(BranchController.class.getName()).log(
					Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(view, ex.toString());
		}
		return result;
	}

	public BaseTableModel totalExpenses() {
		BaseTableModel result = null;
		try {
			DataSupport dh = new DataSupport();
			String query = "SELECT SUM(total_amount) AS Expenses FROM requisition_slips";
			result = dh.executeQuery(query);
		} catch (SQLException ex) {
			Logger.getLogger(BranchController.class.getName()).log(
					Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(view, ex.toString());
		}
		return result;
	}

}

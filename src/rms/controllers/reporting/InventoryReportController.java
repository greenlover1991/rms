package rms.controllers.reporting;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import rms.controllers.management.BranchController;
import rms.models.BaseTableModel;
import rms.views.reporting.InventoryReportView;
import rms.views.reporting.SpoilageReportView;
import supports.DataSupport;

/*
 * @author Yu
 *
 */
public class InventoryReportController {
	private InventoryReportView view;
	private BaseTableModel model;

	public InventoryReportController(InventoryReportView view) {
		this.view = view;
		this.model = new BaseTableModel();
	}

	public BaseTableModel refresh() {
		try {
			DataSupport dh = new DataSupport();
			String query = "SELECT I.name AS Ingredient, IL.beginning_inventory AS Initial, IL.in_inventory AS 'In', IL.out_inventory AS 'Out', IL.end_inventory AS End  "
					+ "FROM inventory_logs IL "
					+ "INNER JOIN ingredients I "
					+ "ON IL.ingredient_id = I.id";
			model = dh.executeQuery(query);
		} catch (SQLException ex) {
			Logger.getLogger(BranchController.class.getName()).log(
					Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(view, ex.toString());
		}
		return model;
	}
}

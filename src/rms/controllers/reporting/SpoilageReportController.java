package rms.controllers.reporting;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import rms.controllers.management.BranchController;
import rms.models.BaseTableModel;
import rms.views.reporting.SpoilageReportView;
import supports.DataSupport;

/*
 * @author Yu
 *
 */
public class SpoilageReportController {
	private SpoilageReportView view;
	private BaseTableModel model;

	public SpoilageReportController(SpoilageReportView view) {
		this.view = view;
		this.model = new BaseTableModel();
	}

	public BaseTableModel refresh(String date) {
		try {
			DataSupport dh = new DataSupport();
			String query = "SELECT I.name AS Ingredient,  SRI.quantity AS Measurement "
					+ "FROM spoilage_report_items SRI "
					+ "INNER JOIN ingredients I "
					+ "ON SRI.ingredient_id = I.id "
					+ "WHERE SRI.spoilage_report_id = (SELECT id FROM spoilage_reports WHERE date_of_spoilage LIKE '%" + date + "%')";
//					+ "(SELECT SR.id "
//					+ "FROM spoilage_reports SR "
//					+ "WHERE SR.date_of_spoilage LIKE '%" + date + "%'";
			// String query =
			// "SELECT I.name AS Ingredient,  SUM(SRI.quantity) AS Measurement "
			// +
			// "FROM spoilage_report_items SRI " +
			// "INNER JOIN ingredients I " +
			// "ON SRI.ingredient_id = I.id";
			model = dh.executeQuery(query);
		} catch (SQLException ex) {
			Logger.getLogger(BranchController.class.getName()).log(
					Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(view, ex.toString());
		}
		return model;
	}

}

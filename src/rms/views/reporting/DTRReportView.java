package rms.views.reporting;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/*
 * @author Yu
 *
 */
public class DTRReportView extends JInternalFrame {
	DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
	JTable DTR;
	JScrollPane scrollPaneDTR;
	// DTRReportModel model = new DTRReportModel();
	JPanel panelTop = new JPanel();
	DefaultTableModel model = new DefaultTableModel();

	private static DTRReportView INSTANCE;

	private DTRReportView() {
		super("Daily Time Record Report", true,// resizable
				true, // closable
				true, // maximizable
				true); // iconifiable

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int) (screenSize.width * .85), (int) (screenSize.height * .9));

		model.setDataVector(new Object[][] {
				{ "9:00:00", "7:00:00", "", "", "", "", "50", "500" },
				{ "5:00:00", "9:00:00", "", "", "", "", "40", "160" } },
				new Object[] { "In", "Out", "In", "Out", "In", "Out",
						"Rate/Hr", "Total/Day" });

		initComponents();

		add(scrollPaneDTR, BorderLayout.CENTER);

		pack();
		setVisible(true);
	}

	private void initComponents() {

		dtcr.setHorizontalAlignment(SwingConstants.CENTER);

		DTR = new JTable(model) {
			public Component prepareRenderer(TableCellRenderer renderer,
					int Index_row, int Index_col) {
				Component comp = super.prepareRenderer(renderer, Index_row,
						Index_col);
				// even index, selected or not selected
				if (Index_row % 2 == 0 && !isCellSelected(Index_row, Index_col)) {
					comp.setBackground(Color.GREEN);
				} else {
					comp.setBackground(Color.WHITE);
				}
				return comp;
			}
		};

		// TableColumnModel columnModel = DTR.getColumnModel();
		// ColumnGroup headerMorning = new ColumnGroup("Morning");
		// headerMorning.add(columnModel.getColumn(0));
		// headerMorning.add(columnModel.getColumn(1));
		//
		// ColumnGroup headerAfternoon = new ColumnGroup("Afternoon");
		// headerMorning.add(columnModel.getColumn(2));
		// headerMorning.add(columnModel.getColumn(3));
		//
		// ColumnGroup headerOvertime = new ColumnGroup("Overtime");
		// headerMorning.add(columnModel.getColumn(4));
		// headerMorning.add(columnModel.getColumn(5));
		//
		// GroupableTableHeader header = (GroupableTableHeader) DTR
		// .getTableHeader();
		// header.addColumnGroup(headerMorning);
		// header.addColumnGroup(headerAfternoon);
		// header.addColumnGroup(headerOvertime);

		TableColumn column = null;
		column = DTR.getColumnModel().getColumn(0);
		column.setPreferredWidth(150);
		column.setMinWidth(150);
		column.setMaxWidth(150);
		column.setCellRenderer(dtcr);
		column = DTR.getColumnModel().getColumn(1);
		column.setPreferredWidth(150);
		column.setMinWidth(150);
		column.setMaxWidth(150);
		column.setCellRenderer(dtcr);
		column = DTR.getColumnModel().getColumn(2);
		column.setPreferredWidth(150);
		column.setMinWidth(150);
		column.setMaxWidth(150);
		column.setCellRenderer(dtcr);
		column = DTR.getColumnModel().getColumn(3);
		column.setPreferredWidth(150);
		column.setMinWidth(150);
		column.setMaxWidth(150);
		column.setCellRenderer(dtcr);
		column = DTR.getColumnModel().getColumn(4);
		column.setPreferredWidth(150);
		column.setMinWidth(150);
		column.setMaxWidth(150);
		column.setCellRenderer(dtcr);
		column = DTR.getColumnModel().getColumn(5);
		column.setPreferredWidth(150);
		column.setMinWidth(150);
		column.setMaxWidth(150);
		column.setCellRenderer(dtcr);
		column = DTR.getColumnModel().getColumn(6);
		column.setCellRenderer(dtcr);
		column.setPreferredWidth(50);
		column.setMinWidth(50);
		column.setMaxWidth(50);
		column = DTR.getColumnModel().getColumn(7);
		column.setCellRenderer(dtcr);
		column.setPreferredWidth(50);
		column.setMinWidth(100);
		column.setMaxWidth(100);

		scrollPaneDTR = new JScrollPane(DTR);

	}

	public static DTRReportView getInstance() {
		if (INSTANCE == null)
			INSTANCE = new DTRReportView();
		return INSTANCE;
	}
}

package rms.views.reporting;

import java.awt.BorderLayout;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

/*
 * @author Yu
 *
 */
public class DTRReportView extends JInternalFrame {
	String[] columnNames = { "In", "Out", "Rate/Hr", "Total/Day" };
	Object[][] data = { {"9:00:00","7:00:00", "50", "500" }, {"5:00:00","9:00:00", "40", "160" } };
	DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
	JTable DTR;
	JScrollPane scrollPaneDTR;

        private static DTRReportView INSTANCE;
	private DTRReportView() {
		super("Daily Time Record Report", true,// resizable
				true, // closable
				true, // maximizable
				true); // iconifiable
		setSize(500, 500);

		initComponents();

		add(scrollPaneDTR, BorderLayout.CENTER);

		pack();
		setVisible(true);
	}

	private void initComponents() {

		dtcr.setHorizontalAlignment(SwingConstants.CENTER);

		DTR = new JTable(data, columnNames);
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
		column.setCellRenderer(dtcr);
		column.setPreferredWidth(50);
		column.setMinWidth(50);
		column.setMaxWidth(50);
		column = DTR.getColumnModel().getColumn(3);
		column.setCellRenderer(dtcr);
		column.setPreferredWidth(50);
		column.setMinWidth(100);
		column.setMaxWidth(100);

		scrollPaneDTR = new JScrollPane(DTR);

	}

        public static DTRReportView getInstance(){
            if(INSTANCE == null)
                INSTANCE = new DTRReportView();
            return INSTANCE;
        }
}

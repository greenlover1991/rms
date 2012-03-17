package rms.views.reporting;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import org.jbundle.thin.base.screen.jcalendarbutton.JCalendarButton;

import rms.controllers.reporting.InventoryReportController;
import rms.models.BaseTableModel;
import rms.models.reporting.InventoryReportModel;

/*  
 * @author Yu
 *
 */
public class InventoryReportView extends JInternalFrame {
	DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
	JTable tableInventoryReport;
	JPanel panelDateButtons = new JPanel();
	JScrollPane scrollPaneInventoryReport;
	JCalendarButton buttonDate;
	JTextField textDate;
	JLabel labelDate;
	DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM),
			dateSqlFormat = new SimpleDateFormat("yyyy-MM-dd");
	BaseTableModel model;
	InventoryReportController controller = new InventoryReportController(this);

	private static InventoryReportView INSTANCE;

	private InventoryReportView() {
		super("Inventory Report", true,// resizable
				true, // closable
				true, // maximizable
				true); // iconifiable

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int) (screenSize.width * .85), (int) (screenSize.height * .9));
		
		initComponents();

		add(scrollPaneInventoryReport, BorderLayout.CENTER);
		add(panelDateButtons, BorderLayout.PAGE_START);

		setVisible(true);
	}

	private void initComponents() {
		
		Calendar calendar = GregorianCalendar.getInstance();
		String currentDate = dateFormat.format(calendar.getTime());
		
		buttonDate = new JCalendarButton();
		textDate = new JTextField(10);
		labelDate = new JLabel("Date: ");
		
		textDate.setText(currentDate);

		textDate.setHorizontalAlignment(JTextField.CENTER);

		buttonDate.setActionCommand("setFromDate");

		panelDateButtons.setMaximumSize(new Dimension(250, 25));
		panelDateButtons.setMinimumSize(new Dimension(250, 25));
		panelDateButtons.setPreferredSize(new Dimension(250, 25));

		panelDateButtons.add(labelDate);
		panelDateButtons.add(textDate);
		panelDateButtons.add(buttonDate);

		textDate.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent evt) {
				dateFocusLost(evt);
			}
		});

		buttonDate.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				dateOnlyPopupChanged(evt);
			}
		});

		dtcr.setHorizontalAlignment(SwingConstants.CENTER);

		tableInventoryReport = new JTable(){
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
			
			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return false;
			}
		};
		
		tableInventoryReport.setRowSelectionAllowed(true);

		refreshReportDate(calendar.getTime());
		
		TableColumn column = null;
		column = tableInventoryReport.getColumnModel().getColumn(0);
		column.setCellRenderer(dtcr);
		column = tableInventoryReport.getColumnModel().getColumn(1);
		column.setCellRenderer(dtcr);
		column = tableInventoryReport.getColumnModel().getColumn(2);
		column.setCellRenderer(dtcr);
		column = tableInventoryReport.getColumnModel().getColumn(3);
		column.setCellRenderer(dtcr);
		column = tableInventoryReport.getColumnModel().getColumn(4);
		column.setCellRenderer(dtcr);
		scrollPaneInventoryReport = new JScrollPane(tableInventoryReport);

	}

	private void dateFocusLost(FocusEvent evt) {
		String date = textDate.getText();
		setDate(date);
	}

	private void dateOnlyPopupChanged(PropertyChangeEvent evt) {
		if (evt.getNewValue() instanceof Date)
			setDate((Date) evt.getNewValue());
	}

	public void setDate(String dateString) {
		Date date = null;
		try {
			if ((dateString != null) && (dateString.length() > 0))
				date = dateFormat.parse(dateString);
		} catch (Exception e) {
			date = null;
		}
		this.setDate(date);
	}

	public void setDate(Date date) {
		String dateString = "";
		
		refreshReportDate(date);

		if (date != null)
			dateString = dateFormat.format(date);
		textDate.setText(dateString);
		buttonDate.setTargetDate(date);
		
		TableColumn column = null;
		column = tableInventoryReport.getColumnModel().getColumn(0);
		column.setCellRenderer(dtcr);
		column = tableInventoryReport.getColumnModel().getColumn(1);
		column.setCellRenderer(dtcr);
		column = tableInventoryReport.getColumnModel().getColumn(2);
		column.setCellRenderer(dtcr);
		column = tableInventoryReport.getColumnModel().getColumn(3);
		column.setCellRenderer(dtcr);
		column = tableInventoryReport.getColumnModel().getColumn(4);
		column.setCellRenderer(dtcr);

	}
	
	public void refreshReportDate(Date date) {
		String currentDate = dateSqlFormat.format(date);
		tableInventoryReport.setModel(controller.refresh(currentDate));
	}

	public static InventoryReportView getInstance() {
		if (INSTANCE == null)
			INSTANCE = new InventoryReportView();
		return INSTANCE;
	}
}

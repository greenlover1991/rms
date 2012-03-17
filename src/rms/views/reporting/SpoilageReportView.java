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

import rms.controllers.reporting.SpoilageReportController;
import rms.models.BaseTableModel;

/*
 * @author Yu
 *
 */
public class SpoilageReportView extends JInternalFrame {
	DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
	JTable tableSpoilageReport;
	JPanel panelDateButtons = new JPanel();
	JScrollPane scrollPaneSpoilageReport;
	JCalendarButton buttonDate;
	JTextField textDate;
	JLabel labelDate;
	DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM),
			dateSqlFormat = new SimpleDateFormat("yyyy-MM-dd");
	BaseTableModel model = new BaseTableModel();
	SpoilageReportController controller = new SpoilageReportController(this);
	int buttonNo = 0;

	private static SpoilageReportView INSTANCE;

	private SpoilageReportView() {
		super("Spoilage Report", true,// resizable
				true, // closable
				true, // maximizable
				true); // iconifiable

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int) (screenSize.width * .85), (int) (screenSize.height * .9));

		initComponents();

		add(scrollPaneSpoilageReport, BorderLayout.CENTER);
		add(panelDateButtons, BorderLayout.NORTH);

		setVisible(true);
	}

	private void initComponents() {
		
		Calendar calendar = GregorianCalendar.getInstance();
		String currentDate = dateFormat.format(calendar.getTime());
		
		buttonDate = new JCalendarButton();
		textDate = new JTextField(10);
		labelDate = new JLabel("Date:");
		
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
				buttonNo = 0;
				dateOnlyPopupChanged(evt);
			}
		});

		dtcr.setHorizontalAlignment(SwingConstants.CENTER);

		tableSpoilageReport = new JTable() {
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
		
		tableSpoilageReport.setRowSelectionAllowed(true);

		refreshReportDate(calendar.getTime());
		
		TableColumn column = null;
		column = tableSpoilageReport.getColumnModel().getColumn(0);
		column.setCellRenderer(dtcr);
		column = tableSpoilageReport.getColumnModel().getColumn(1);
		column.setCellRenderer(dtcr);

		scrollPaneSpoilageReport = new JScrollPane(tableSpoilageReport);

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
		column = tableSpoilageReport.getColumnModel().getColumn(0);
		column.setCellRenderer(dtcr);
		column = tableSpoilageReport.getColumnModel().getColumn(1);
		column.setCellRenderer(dtcr);
	}
	
	public void refreshReportDate(Date date) {
		String currentDate = dateSqlFormat.format(date);
		tableSpoilageReport.setModel(controller.refresh(currentDate));
	}

	public static SpoilageReportView getInstance() {
		if (INSTANCE == null)
			INSTANCE = new SpoilageReportView();
		return INSTANCE;
	}

}

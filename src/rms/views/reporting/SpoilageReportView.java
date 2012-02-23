package rms.views.reporting;

import java.awt.BorderLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import org.jbundle.thin.base.screen.jcalendarbutton.JCalendarButton;

/*
 * @author Yu
 *
 */
public class SpoilageReportView extends JInternalFrame {
	String[] columnNames = { "Ingredient", "Qty" };
	Object[][] data = { { "Patty", "10" }, { "Cheese", "15" } };
	DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
	JTable DTR;
	JPanel panelDateButtons = new JPanel();
	JScrollPane scrollPaneDTR;
	JCalendarButton buttonDateFrom, buttonDateTo;
	JTextField textFieldDateFrom, textFieldDateTo;
	JLabel labelDateFrom, labelDateTo;
	DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);

	public SpoilageReportView() {
		super("Daily Time Record Report", true,// resizable
				true, // closable
				true, // maximizable
				true); // iconifiable
		setSize(500, 500);

		initComponents();

		add(scrollPaneDTR, BorderLayout.CENTER);
		add(panelDateButtons, BorderLayout.NORTH);

		pack();
		setVisible(true);
	}

	public void initComponents() {
		buttonDateFrom = new JCalendarButton();
		buttonDateTo = new JCalendarButton();
		textFieldDateFrom = new JTextField(10);
		textFieldDateTo = new JTextField(10);
		labelDateFrom = new JLabel("From");
		labelDateTo = new JLabel("To");
				
		panelDateButtons.add(labelDateFrom);
		panelDateButtons.add(textFieldDateFrom);
		panelDateButtons.add(buttonDateFrom);

		textFieldDateFrom.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent evt) {
				dateFocusLost(evt);
			}
		});

		buttonDateFrom.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				dateOnlyPopupChanged(evt);
			}
		});

		dtcr.setHorizontalAlignment(SwingConstants.CENTER);

		DTR = new JTable(data, columnNames);
		TableColumn column = null;
		column = DTR.getColumnModel().getColumn(0);
		column.setPreferredWidth(150);
		column.setMinWidth(150);
		column.setMaxWidth(150);
		column.setCellRenderer(dtcr);
		column = DTR.getColumnModel().getColumn(1);
		column.setPreferredWidth(100);
		column.setMinWidth(100);
		column.setMaxWidth(100);
		column.setCellRenderer(dtcr);

		scrollPaneDTR = new JScrollPane(DTR);

	}

	private void dateFocusLost(FocusEvent evt) {
		String date = textFieldDateFrom.getText();
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
		if (date != null)
			dateString = dateFormat.format(date);
		textFieldDateFrom.setText(dateString);
		buttonDateFrom.setTargetDate(date);
	}
}

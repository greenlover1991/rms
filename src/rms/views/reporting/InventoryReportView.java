package rms.views.reporting;

import java.awt.BorderLayout;
import java.awt.Dimension;
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

import rms.models.InventoryReportModel;

/*  
 * @author Yu
 *
 */
public class InventoryReportView extends JInternalFrame {
	DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
	JTable DTR;
	JPanel panelDateButtons = new JPanel();
	JScrollPane scrollPaneDTR;
	JCalendarButton buttonDateFrom, buttonDateTo;
	JTextField textFieldDateFrom, textFieldDateTo;
	JLabel labelDateFrom, labelDateTo;
	DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
	InventoryReportModel model = new InventoryReportModel();
	int buttonNum = 0;

        private static InventoryReportView INSTANCE;
	private InventoryReportView() {
		super("Inventory Report", true,// resizable
				true, // closable
				true, // maximizable
				true); // iconifiable
		setSize(500, 500);

		initComponents();

		add(scrollPaneDTR, BorderLayout.CENTER);
		add(panelDateButtons, BorderLayout.PAGE_START);

		pack();
		setVisible(true);
	}

	private void initComponents() {
		buttonDateFrom = new JCalendarButton();
		buttonDateTo = new JCalendarButton();
		textFieldDateFrom = new JTextField(10);
		textFieldDateTo = new JTextField(10);
		labelDateFrom = new JLabel("From:");
		labelDateTo = new JLabel("To:");

		textFieldDateFrom.setHorizontalAlignment(JTextField.CENTER);
		textFieldDateTo.setHorizontalAlignment(JTextField.CENTER);

		buttonDateFrom.setActionCommand("setFromDate");
		buttonDateTo.setActionCommand("setToDate");

		panelDateButtons.setMaximumSize(new Dimension(250, 25));
		panelDateButtons.setMinimumSize(new Dimension(250, 25));
		panelDateButtons.setPreferredSize(new Dimension(250, 25));

		panelDateButtons.add(labelDateFrom);
		panelDateButtons.add(textFieldDateFrom);
		panelDateButtons.add(buttonDateFrom);
		panelDateButtons.add(labelDateTo);
		panelDateButtons.add(textFieldDateTo);
		panelDateButtons.add(buttonDateTo);

		textFieldDateFrom.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent evt) {
				dateFocusLost(evt);
			}
		});

		textFieldDateTo.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent evt) {
				dateFocusLost(evt);
			}
		});

		buttonDateFrom.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				buttonNum = 0;
				dateOnlyPopupChanged(evt);
			}
		});

		buttonDateTo.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				buttonNum = 1;
				dateOnlyPopupChanged(evt);
			}
		});

		dtcr.setHorizontalAlignment(SwingConstants.CENTER);

		DTR = new JTable(model);
		TableColumn column = null;
		column = DTR.getColumnModel().getColumn(0);
		column.setMinWidth(150);
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
		if (buttonNum == 0) {
			textFieldDateFrom.setText(dateString);
			buttonDateFrom.setTargetDate(date);
		} else {
			textFieldDateTo.setText(dateString);
			buttonDateTo.setTargetDate(date);
		}
	}

        public static InventoryReportView getInstance(){
            if(INSTANCE == null)
                INSTANCE = new InventoryReportView();
            return INSTANCE;
        }
}

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

/*
 * @author Yu
 *
 */
public class SalesReportView extends JInternalFrame {
	String[] columnNames = { "Menu Item", "Qty Sold", "Price", "Credit",
			"Cash", "Total" };
	Object[][] data = { { "Tempura", "99", "10", "0", "990", "990" },
			{ "Chuckie", "199", "20", "2000", "1980", "3980" } };
	DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
	JTable DTR;
	JPanel panelDateButtons = new JPanel();
	JScrollPane scrollPaneDTR;
	JCalendarButton buttonDateFrom, buttonDateTo;
	JTextField textFieldDateFrom, textFieldDateTo, textTotalSales;
	JLabel labelDateFrom, labelDateTo, labelTotalSales;
	DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
	int buttonNum = 0;

	public SalesReportView() {
		super("Sales Report", true,// resizable
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

	public void initComponents() {
		buttonDateFrom = new JCalendarButton();
		buttonDateTo = new JCalendarButton();
		textFieldDateFrom = new JTextField(10);
		textFieldDateTo = new JTextField(10);
		textTotalSales = new JTextField(10);
		labelDateFrom = new JLabel("From:");
		labelDateTo = new JLabel("To:");
		labelTotalSales = new JLabel("Total Sales");

		textFieldDateFrom.setHorizontalAlignment(JTextField.CENTER);
		textFieldDateTo.setHorizontalAlignment(JTextField.CENTER);
		textTotalSales.setHorizontalAlignment(JTextField.CENTER);
		textTotalSales.setEditable(false);

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

		DTR = new JTable(data, columnNames);
		TableColumn column = null;
		column = DTR.getColumnModel().getColumn(0);
		column.setMinWidth(150);
		column.setCellRenderer(dtcr);
		column = DTR.getColumnModel().getColumn(1);
		column.setPreferredWidth(100);
		column.setMinWidth(100);
		column.setMaxWidth(100);
		column.setCellRenderer(dtcr);
		column = DTR.getColumnModel().getColumn(2);
		column.setPreferredWidth(65);
		column.setMinWidth(65);
		column.setMaxWidth(65);
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
	
//	for (int i = 0, rows = model.getRowCount(); i < rows; i++)  
//	{  
//	    total += model.getValueAt(i, X) * model.getValueAt(i, Y);  
//	}  
//	
//	//precise calculation
//	BigDecimal quantity = (BigDecimal)model.getValueAt(i, X);  
//	BigDecimal price = (BigDecimal)model.getValueAt(i, Y);  
//	total = total.add(quantity.multiply(price));
//	
//	class MyTableModel extends DefaultTableModel  
//	{  
//	    private BigDecimal total = BigDecimal.ZERO;  
//	   
//	    // override getColumnClass and isCellEditable as needed  
//	   
//	    private BigDecimal getTotal(int row)  
//	    {  
//	        BigDecimal price = getValueAt(row, <<column for price>>) ;  
//	        BigDecimal quantity = getValueAt(row, <<column for quantity>>) ;  
//	        if (price == null || quantity == null)  
//	        {  
//	            return BigDecimal.ZERO;  
//	        }  
//	        return price.multiply(quantity);  
//	    }  
//	   
//	    @Override  
//	    public void setValueAt(Object value, int row, int column)  
//	    {  
//	        if (column == <<column for quantity>> || column == <<column for price>>)   
//	        {  
//	            BigDecimal oldRowTotal = getTotal(row);  
//	            super.setValueAt(value, row, column);  
//	            BigDecimal newRowTotal = getTotal(row);  
//	            total = total.subtract(oldRowTotal);  
//	            total = total.add(newRowTotal);  
//	        }  
//	        else  
//	        {  
//	            super.setValueAt(value, row, column);  
//	        }  
//	    }  
//	   
//	    @Override  
//	    public void insertRow(int row, Vector rowData)  
//	    {  
//	        // this method is eventually called by all other addRow and insertRow methods  
//	        super.insertRow(row, rowData);  
//	        BigDecimal rowTotal = getTotal(row);  
//	        total = total.add(rowTotal);  
//	    }  
//	   
//	    @Override  
//	    public void removeRow(int row)  
//	    {  
//	        BigDecimal rowTotal = getTotal(row);  
//	        super.removeRow(row);  
//	        total = total.subtract(rowTotal);  
//	    }  
//	   
//	    @Override  
//	    public void setNumRows(int rowCount)  
//	    {  
//	        // also called by setRowCount  
//	        int old = getRowCount();  
//	        BigDecimal remove = BigDecimal.ZERO;  
//	        if (rowCount < old)  
//	        {  
//	            // everything from rowCount to old will be removed  
//	            for (int i = rowCount; i < old; i++)  
//	            {  
//	                BigDecimal rowTotal = getTotal(i);  
//	                remove = remove.subtract(rowTotal);  
//	            }  
//	        }  
//	        // if equal nothing is done, if larger than the values will be 0 or null  
//	        super.setNumRows(rowCount);  
//	        total = total.subtract(remove);  
//	    }  
//	   
//	    @Override  
//	    public void setDataVector(Vector dataVector, Vector columnIdentifiers)  
//	    {  
//	        super.setDataVector();  
//	        // recalculate total from scratch by iterating through the entire table as in my previous post  
//	    }  
//	}
}

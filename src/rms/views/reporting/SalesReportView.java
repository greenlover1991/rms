package rms.views.reporting;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

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

import rms.models.SalesReportModel;

/*
 * @author Yu
 *
 */
public class SalesReportView extends JInternalFrame {
	DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
	JTable DTR;
	JPanel panelDateButtons = new JPanel();
	JScrollPane scrollPaneDTR;
	JCalendarButton buttonDateFrom, buttonDateTo;
	JTextField textFieldDateFrom, textFieldDateTo, textTotalSales;
	JLabel labelDateFrom, labelDateTo, labelTotalSales;
	DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
	SalesReportModel model = new SalesReportModel();
	int buttonNum = 0;

<<<<<<< HEAD
	JFXPanel panelChart = new JFXPanel();

	public SalesReportView() {
=======
        private static SalesReportView INSTANCE;
	private SalesReportView() {
>>>>>>> upstream/master
		super("Sales Report", true,// resizable
				true, // closable
				true, // maximizable
				true); // iconifiable

		initComponents();

		add(scrollPaneDTR, BorderLayout.CENTER);
		add(panelDateButtons, BorderLayout.PAGE_START);
		add(panelChart, BorderLayout.EAST);

		setSize(new Dimension(1280, 400));
		setVisible(true);

//		Platform.runLater(new Runnable() {
//
//			@Override
//			public void run() {
//				initFX(panelChart);
//
//			}
//		});
	}

<<<<<<< HEAD
//	private void initFX(JFXPanel fxPanel) {
//		// invoked on JavaFX thread.
//		Scene scene = createScene();
//		fxPanel.setScene(scene);
//	}
//
//	public static Scene createScene() {
//
//		GregorianCalendar today = new GregorianCalendar();
//		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//		// defining the axes.
//		CategoryAxis xAxis = new CategoryAxis();
//		NumberAxis yAxis = new NumberAxis();
//		xAxis.setLabel("Day");
//		// creating the chart.
//		final LineChart<String, Number> lineChart = new LineChart<String, Number>(
//				xAxis, yAxis);
//		// disable highlight of each data item to show trends.
//		lineChart.setCreateSymbols(false);
//		lineChart.setTitle("Sales Monitoring, Last 7 Days");
//		// defining a series
//		XYChart.Series series = new XYChart.Series();
//		series.setName("Doña Juanita");
//		// populating the series with data
//		today.add(Calendar.DATE, -6);
//
//		series.getData().add(
//				new XYChart.Data("" + dateFormat.format(today.getTime()), 36));
//		today.add(Calendar.DATE, 1);
//
//		series.getData().add(
//				new XYChart.Data("" + dateFormat.format(today.getTime()), 22));
//		today.add(Calendar.DATE, 1);
//
//		series.getData().add(
//				new XYChart.Data("" + dateFormat.format(today.getTime()), 45));
//		today.add(Calendar.DATE, 1);
//
//		series.getData().add(
//				new XYChart.Data("" + dateFormat.format(today.getTime()), 43));
//		today.add(Calendar.DATE, 1);
//
//		series.getData().add(
//				new XYChart.Data("" + dateFormat.format(today.getTime()), 17));
//		today.add(Calendar.DATE, 1);
//
//		series.getData().add(
//				new XYChart.Data("" + dateFormat.format(today.getTime()), 29));
//		today.add(Calendar.DATE, 1);
//
//		series.getData().add(
//				new XYChart.Data("" + dateFormat.format(today.getTime()), 25));
//
//		Scene scene = new Scene(lineChart, 600, 400);
//		lineChart.getData().add(series);
//		scene.getStylesheets().add(""); // css
//
//		return scene;
//	}

	public void initComponents() {
=======
	private void initComponents() {
>>>>>>> upstream/master
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

		DTR = new JTable(model);
		TableColumn column = null;
		column = DTR.getColumnModel().getColumn(0);
		column.setMinWidth(135);
		column.setCellRenderer(dtcr);
		column = DTR.getColumnModel().getColumn(1);
		column.setPreferredWidth(85);
		column.setMinWidth(85);
		column.setMaxWidth(85);
		column.setCellRenderer(dtcr);
		column = DTR.getColumnModel().getColumn(2);
		column.setPreferredWidth(55);
		column.setMinWidth(55);
		column.setMaxWidth(55);
		column.setCellRenderer(dtcr);
		column = DTR.getColumnModel().getColumn(3);
		column.setPreferredWidth(135);
		column.setMinWidth(135);
		column.setMaxWidth(135);
		column.setCellRenderer(dtcr);
		column = DTR.getColumnModel().getColumn(4);
		column.setPreferredWidth(135);
		column.setMinWidth(135);
		column.setMaxWidth(135);
		column.setCellRenderer(dtcr);
		column = DTR.getColumnModel().getColumn(5);
		column.setPreferredWidth(135);
		column.setMinWidth(135);
		column.setMaxWidth(135);
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

<<<<<<< HEAD
	// for (int i = 0, rows = model.getRowCount(); i < rows; i++)
	// {
	// total += model.getValueAt(i, X) * model.getValueAt(i, Y);
	// }
	//
	// //precise calculation
	// BigDecimal quantity = (BigDecimal)model.getValueAt(i, X);
	// BigDecimal price = (BigDecimal)model.getValueAt(i, Y);
	// total = total.add(quantity.multiply(price));
	//
	// class MyTableModel extends DefaultTableModel
	// {
	// private BigDecimal total = BigDecimal.ZERO;
	//
	// // override getColumnClass and isCellEditable as needed
	//
	// private BigDecimal getTotal(int row)
	// {
	// BigDecimal price = getValueAt(row, <<column for price>>) ;
	// BigDecimal quantity = getValueAt(row, <<column for quantity>>) ;
	// if (price == null || quantity == null)
	// {
	// return BigDecimal.ZERO;
	// }
	// return price.multiply(quantity);
	// }
	//
	// @Override
	// public void setValueAt(Object value, int row, int column)
	// {
	// if (column == <<column for quantity>> || column == <<column for price>>)
	// {
	// BigDecimal oldRowTotal = getTotal(row);
	// super.setValueAt(value, row, column);
	// BigDecimal newRowTotal = getTotal(row);
	// total = total.subtract(oldRowTotal);
	// total = total.add(newRowTotal);
	// }
	// else
	// {
	// super.setValueAt(value, row, column);
	// }
	// }
	//
	// @Override
	// public void insertRow(int row, Vector rowData)
	// {
	// // this method is eventually called by all other addRow and insertRow
	// methods
	// super.insertRow(row, rowData);
	// BigDecimal rowTotal = getTotal(row);
	// total = total.add(rowTotal);
	// }
	//
	// @Override
	// public void removeRow(int row)
	// {
	// BigDecimal rowTotal = getTotal(row);
	// super.removeRow(row);
	// total = total.subtract(rowTotal);
	// }
	//
	// @Override
	// public void setNumRows(int rowCount)
	// {
	// // also called by setRowCount
	// int old = getRowCount();
	// BigDecimal remove = BigDecimal.ZERO;
	// if (rowCount < old)
	// {
	// // everything from rowCount to old will be removed
	// for (int i = rowCount; i < old; i++)
	// {
	// BigDecimal rowTotal = getTotal(i);
	// remove = remove.subtract(rowTotal);
	// }
	// }
	// // if equal nothing is done, if larger than the values will be 0 or null
	// super.setNumRows(rowCount);
	// total = total.subtract(remove);
	// }
	//
	// @Override
	// public void setDataVector(Vector dataVector, Vector columnIdentifiers)
	// {
	// super.setDataVector();
	// // recalculate total from scratch by iterating through the entire table
	// as in my previous post
	// }
	// }
=======
        public static SalesReportView getInstance(){
            if(INSTANCE == null)
                INSTANCE = new SalesReportView();
            return INSTANCE;
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
>>>>>>> upstream/master
}

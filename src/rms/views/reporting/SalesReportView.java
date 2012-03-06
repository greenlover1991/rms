package rms.views.reporting;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
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
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import org.jbundle.thin.base.screen.jcalendarbutton.JCalendarButton;

import rms.controllers.reporting.SalesReportController;
import rms.models.BaseTableModel;

/*
 * @author Yu
 *
 */
public class SalesReportView extends JInternalFrame {
	DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
	JTable tableSalesReport;
	JPanel panelDateButtons = new JPanel();
	JScrollPane scrollPaneSalesReport;
	JCalendarButton buttonDateFrom, buttonDateTo, buttonDate;
	JTextField textDateFrom, textDateTo, textDate, textExpenses,
			textTotalCashOnHand, textCashSales, textCardSales;
	JLabel labelDateFrom, labelDateTo, labelDate, labelExpenses,
			labelTotalCashOnHand, labelCashSales, labelCardSales;
	DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
	BaseTableModel model;
	SalesReportController controller = new SalesReportController(this);
	int buttonNum = 0;

	// JFXPanel panelChart = new JFXPanel();

	private static SalesReportView INSTANCE;

	private SalesReportView() {
		super("Sales Report", true, // resizable
				true, // closable
				true, // maximizable
				true); // iconifiable

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int) (screenSize.width * .5), (int) (screenSize.height * .9));

		model = controller.refresh();

		initComponents();

		add(scrollPaneSalesReport, BorderLayout.CENTER);
		add(panelDateButtons, BorderLayout.PAGE_START);
		// add(panelChart, BorderLayout.EAST);

		setVisible(true);

		// Platform.runLater(new Runnable() {
		//
		// @Override
		// public void run() {
		// initFX(panelChart);
		//
		// }
		// });
	}

	// private void initFX(JFXPanel fxPanel) {
	// // invoked on JavaFX thread.
	// Scene scene = createScene();
	// fxPanel.setScene(scene);
	// }
	//
	// public static Scene createScene() {
	//
	// GregorianCalendar today = new GregorianCalendar();
	// DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	// // defining the axes.
	// CategoryAxis xAxis = new CategoryAxis();
	// NumberAxis yAxis = new NumberAxis();
	// xAxis.setLabel("Day");
	// // creating the chart.
	// final LineChart<String, Number> lineChart = new LineChart<String,
	// Number>(
	// xAxis, yAxis);
	// // disable highlight of each data item to show trends.
	// lineChart.setCreateSymbols(false);
	// lineChart.setTitle("Sales Monitoring, Last 7 Days");
	// // defining a series
	// XYChart.Series series = new XYChart.Series();
	// series.setName("Do�a Juanita");
	// // populating the series with data
	// today.add(Calendar.DATE, -6);
	//
	// series.getData().add(
	// new XYChart.Data("" + dateFormat.format(today.getTime()), 36));
	// today.add(Calendar.DATE, 1);
	//
	// series.getData().add(
	// new XYChart.Data("" + dateFormat.format(today.getTime()), 22));
	// today.add(Calendar.DATE, 1);
	//
	// series.getData().add(
	// new XYChart.Data("" + dateFormat.format(today.getTime()), 45));
	// today.add(Calendar.DATE, 1);
	//
	// series.getData().add(
	// new XYChart.Data("" + dateFormat.format(today.getTime()), 43));
	// today.add(Calendar.DATE, 1);
	//
	// series.getData().add(
	// new XYChart.Data("" + dateFormat.format(today.getTime()), 17));
	// today.add(Calendar.DATE, 1);
	//
	// series.getData().add(
	// new XYChart.Data("" + dateFormat.format(today.getTime()), 29));
	// today.add(Calendar.DATE, 1);
	//
	// series.getData().add(
	// new XYChart.Data("" + dateFormat.format(today.getTime()), 25));
	//
	// Scene scene = new Scene(lineChart, 600, 400);
	// lineChart.getData().add(series);
	// scene.getStylesheets().add(""); // css
	//
	// return scene;
	// }

	private void initComponents() {
		buttonDate = new JCalendarButton();
		textDate = new JTextField();
		labelDate = new JLabel("Date:");
		buttonDateFrom = new JCalendarButton();
		buttonDateTo = new JCalendarButton();
		textDate = new JTextField(10);
		textDateFrom = new JTextField(10);
		textDateTo = new JTextField(10);
		textCashSales = new JTextField(10);
		textCardSales = new JTextField(10);
		textExpenses = new JTextField(10);
		textTotalCashOnHand = new JTextField(10);
		labelDateFrom = new JLabel("From:");
		labelDateTo = new JLabel("To:");
		labelCashSales = new JLabel("Total Cash Sales");
		labelCardSales = new JLabel("Total Card Sales");
		labelExpenses = new JLabel("Total Expenses");
		labelTotalCashOnHand = new JLabel("Total Cash on Hand");

		textDate.setHorizontalAlignment(JTextField.CENTER);
		textDateFrom.setHorizontalAlignment(JTextField.CENTER);
		textDateTo.setHorizontalAlignment(JTextField.CENTER);
		textCashSales.setHorizontalAlignment(JTextField.CENTER);
		textCashSales.setEditable(false);
		textCardSales.setHorizontalAlignment(JTextField.CENTER);
		textCardSales.setEditable(false);
		textExpenses.setHorizontalAlignment(JTextField.CENTER);
		textExpenses.setEditable(false);
		textTotalCashOnHand.setHorizontalAlignment(JTextField.CENTER);
		textTotalCashOnHand.setEditable(false);

		textCashSales.setText(controller.totalCashSales().getValueAt(0, 0)
				.toString());
		textCardSales.setText(controller.totalCardSales().getValueAt(0, 0)
				.toString());
		textExpenses.setText(controller.totalExpenses().getValueAt(0, 0)
				.toString());

		double totalCashOnHand = Double.parseDouble(controller.totalCashSales()
				.getValueAt(0, 0).toString())
				- Double.parseDouble(controller.totalExpenses()
						.getValueAt(0, 0).toString());
		textTotalCashOnHand.setText(Double.toString(totalCashOnHand));

		buttonDateFrom.setActionCommand("setFromDate");
		buttonDateTo.setActionCommand("setToDate");
		buttonDate.setActionCommand("setDate");

		panelDateButtons.setLayout(new GridLayout(3, 4));
		panelDateButtons.setMaximumSize(new Dimension(250, 50));
		panelDateButtons.setMinimumSize(new Dimension(250, 50));
		panelDateButtons.setPreferredSize(new Dimension(250, 50));

		panelDateButtons.add(labelDate);
		panelDateButtons.add(textDate);
		panelDateButtons.add(buttonDate);
		// panelDateButtons.add(labelDateFrom);
		// panelDateButtons.add(textFieldDateFrom);
		// panelDateButtons.add(buttonDateFrom);
		// panelDateButtons.add(labelDateTo);
		// panelDateButtons.add(textFieldDateTo);
		// panelDateButtons.add(buttonDateTo);
		panelDateButtons.add(new JLabel());
		panelDateButtons.add(labelCashSales);
		panelDateButtons.add(textCashSales);
		panelDateButtons.add(labelCardSales);
		panelDateButtons.add(textCardSales);
		panelDateButtons.add(labelExpenses);
		panelDateButtons.add(textExpenses);
		panelDateButtons.add(labelTotalCashOnHand);
		panelDateButtons.add(textTotalCashOnHand);

		textDate.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent evt) {
				dateFocusLost(evt);
			}
		});

		textDateFrom.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent evt) {
				dateFocusLost(evt);
			}
		});

		textDateTo.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent evt) {
				dateFocusLost(evt);
			}
		});

		buttonDate.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				buttonNum = 0;
				dateOnlyPopupChanged(evt);
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

		tableSalesReport = new JTable(model) {
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
		TableColumn column = null;
		column = tableSalesReport.getColumnModel().getColumn(0);
		// column.setMinWidth(135);
		column.setCellRenderer(dtcr);
		column = tableSalesReport.getColumnModel().getColumn(1);
		// column.setPreferredWidth(85);
		// column.setMinWidth(85);
		// column.setMaxWidth(85);
		column.setCellRenderer(dtcr);
		// column = DTR.getColumnModel().getColumn(2);
		// column.setPreferredWidth(55);
		// column.setMinWidth(55);
		// column.setMaxWidth(55);
		// column.setCellRenderer(dtcr);
		// column = DTR.getColumnModel().getColumn(3);
		// column.setPreferredWidth(135);
		// column.setMinWidth(135);
		// column.setMaxWidth(135);
		// column.setCellRenderer(dtcr);
		// column = DTR.getColumnModel().getColumn(4);
		// column.setPreferredWidth(135);
		// column.setMinWidth(135);
		// column.setMaxWidth(135);
		// column.setCellRenderer(dtcr);
		// column = DTR.getColumnModel().getColumn(5);
		// column.setPreferredWidth(135);
		// column.setMinWidth(135);
		// column.setMaxWidth(135);
		// column.setCellRenderer(dtcr);

		scrollPaneSalesReport = new JScrollPane(tableSalesReport);

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
		if (date != null)
			dateString = dateFormat.format(date);
		textDate.setText(dateString);
		buttonDate.setTargetDate(date);
		// if (buttonNum == 0) {
		// textDateFrom.setText(dateString);
		// buttonDateFrom.setTargetDate(date);
		// } else {
		// textDateTo.setText(dateString);
		// buttonDateTo.setTargetDate(date);
		// }
	}

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

	public static SalesReportView getInstance() {
		if (INSTANCE == null)
			INSTANCE = new SalesReportView();
		return INSTANCE;
	}

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
}

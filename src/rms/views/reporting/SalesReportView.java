package rms.views.reporting;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLData;
import java.text.DateFormat;
import java.text.ParseException;
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
	JPanel panelDateButtons = new JPanel(), panelSalesReport = new JPanel(),
			panelChartDateButtons = new JPanel(),
			panelSalesChart = new JPanel();
	JScrollPane scrollPaneSalesReport;
	JCalendarButton buttonDateFrom, buttonDateTo, buttonDate;
	JTextField textDateFrom, textDateTo, textDate, textExpenses,
			textTotalCashOnHand, textCashSales, textCardSales;
	JLabel labelDateFrom, labelDateTo, labelDate, labelExpenses,
			labelTotalCashOnHand, labelCashSales, labelCardSales;
	DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM),
			dateSqlFormat = new SimpleDateFormat("yyyy-MM-dd");
	BaseTableModel model;
	SalesReportController controller = new SalesReportController(this);
	int buttonNum = 0;

	JFXPanel panelChart = new JFXPanel();

	private static SalesReportView INSTANCE;

	private SalesReportView() {
		super("Sales Report", true, // resizable
				true, // closable
				true, // maximizable
				true); // iconifiable

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int) (screenSize.width * .85), (int) (screenSize.height * .9));

		initComponents();

		panelSalesReport.setLayout(new BorderLayout());
		panelSalesReport.add(scrollPaneSalesReport, BorderLayout.CENTER);
		panelSalesReport.add(panelDateButtons, BorderLayout.PAGE_START);

		add(panelSalesReport, BorderLayout.WEST);
		add(panelSalesChart, BorderLayout.CENTER);

		setVisible(true);


	}

	protected void refreshChart() {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				initFX(panelChart);

			}
		});
	}

	protected void initFX(JFXPanel fxPanel) {
		// invoked on JavaFX thread.
		Scene scene = createScene();
		fxPanel.setScene(scene);
	}

	public int calculateDaysBetween() {
		int daysBetween = 0;
		Calendar dateFrom = new GregorianCalendar();
		Calendar dateTo = new GregorianCalendar();
		try {
			dateFrom.setTime(dateFormat.parse(textDateFrom.getText()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			dateTo.setTime(dateFormat.parse(textDateTo.getText()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		while (dateFrom.before(dateTo)) {
			dateFrom.add(Calendar.DAY_OF_MONTH, 1);
			daysBetween++;
		}
		System.out.println(daysBetween);
		return daysBetween;
	}

	public Scene createScene() {

		// compute days between.
		int daysBetween = calculateDaysBetween();
		daysBetween++;

		Calendar calendar = new GregorianCalendar();
		System.out.println("textDateFrom: " + textDateFrom.getText());
		try {
			calendar.setTime(dateFormat.parse(textDateFrom.getText()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("dateFrom: " + calendar.getTime());
		Date dateFrom = calendar.getTime();
		// defining the axes.
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Day");
		// creating the chart.
		final LineChart<String, Number> lineChart = new LineChart<String, Number>(
				xAxis, yAxis);
		// disable highlight of each data item to show trends.
		lineChart.setCreateSymbols(false);
		lineChart.setTitle("Sales Monitoring, Last 7 Days");
		// defining a series
		XYChart.Series series = new XYChart.Series();
		series.setName("Do�a Juanita");
		// populating the series with data

		while (daysBetween > 0) {

			series.getData().add(
					new XYChart.Data("" + dateFormat.format(dateFrom), Integer
							.parseInt(controller
									.sales(dateSqlFormat.format(dateFrom))
									.getValueAt(0, 0).toString())));

			calendar.add(Calendar.DATE, 1);
			dateFrom = calendar.getTime();
			daysBetween--;
		}

		Scene scene = new Scene(lineChart, 600, 400);
		lineChart.getData().add(series);
		scene.getStylesheets().add(""); // css

		return scene;
	}

	// public Scene createScene() {
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
	// new XYChart.Data("" + dateFormat.format(today.getTime()), 5));
	// today.add(Calendar.DATE, 1);
	//
	// series.getData().add(
	// new XYChart.Data("" + dateFormat.format(today.getTime()), 10));
	// today.add(Calendar.DATE, 1);
	//
	// series.getData().add(
	// new XYChart.Data("" + dateFormat.format(today.getTime()), 15));
	// today.add(Calendar.DATE, 1);
	//
	// series.getData().add(
	// new XYChart.Data("" + dateFormat.format(today.getTime()), 20));
	// today.add(Calendar.DATE, 1);
	//
	// series.getData().add(
	// new XYChart.Data("" + dateFormat.format(today.getTime()), 25));
	// today.add(Calendar.DATE, 1);
	//
	// series.getData().add(
	// new XYChart.Data("" + dateFormat.format(today.getTime()),
	// Integer.parseInt(controller.sales(dateSqlFormat.format(today.getTime())).getValueAt(0,
	// 0)
	// .toString())));
	// today.add(Calendar.DATE, 1);
	//
	// series.getData().add(
	// new XYChart.Data("" + dateFormat.format(today.getTime()),
	// Integer.parseInt(controller.sales(dateSqlFormat.format(today.getTime())).getValueAt(0,
	// 0)
	// .toString())));
	//
	// Scene scene = new Scene(lineChart, 600, 400);
	// lineChart.getData().add(series);
	// scene.getStylesheets().add(""); // css
	//
	// return scene;
	// }

	private void initComponents() {

		Calendar calendar = GregorianCalendar.getInstance();
		String currentDate = dateFormat.format(calendar.getTime());

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

		textDate.setText(currentDate);

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

		panelChartDateButtons.setLayout(new FlowLayout());
		panelChartDateButtons.add(labelDateFrom);
		panelChartDateButtons.add(textDateFrom);
		panelChartDateButtons.add(buttonDateFrom);
		panelChartDateButtons.add(labelDateTo);
		panelChartDateButtons.add(textDateTo);
		panelChartDateButtons.add(buttonDateTo);

		panelSalesChart.setLayout(new BorderLayout());
		panelSalesChart.add(panelChartDateButtons, BorderLayout.NORTH);
		panelSalesChart.add(panelChart, BorderLayout.CENTER);

		panelDateButtons.add(labelDate);
		panelDateButtons.add(textDate);
		panelDateButtons.add(buttonDate);
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
				buttonNum = 1;
				dateOnlyPopupChanged(evt);
			}
		});

		buttonDateTo.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				buttonNum = 2;
				dateOnlyPopupChanged(evt);
			}
		});

		dtcr.setHorizontalAlignment(SwingConstants.CENTER);

		tableSalesReport = new JTable() {
			public Component prepareRenderer(TableCellRenderer renderer,
					int Index_row, int Index_col) {
				Component comp = super.prepareRenderer(renderer, Index_row,
						Index_col);
				// even index, selected or not selected
				if (Index_row % 2 == 0 && !isCellSelected(Index_row, Index_col)) {
					comp.setBackground(Color.WHITE);
				} else {
					comp.setBackground(Color.GREEN);
				}
				return comp;
			}

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return false;
			}

		};

		tableSalesReport.setRowSelectionAllowed(true);

		refreshReportDate(calendar.getTime());
		textDateTo.setText(currentDate);
		calendar.add(Calendar.DAY_OF_MONTH, -6);
		currentDate = dateFormat.format(calendar.getTime());
		textDateFrom.setText(currentDate);

		TableColumn column = null;
		column = tableSalesReport.getColumnModel().getColumn(0);
		column.setCellRenderer(dtcr);
		column = tableSalesReport.getColumnModel().getColumn(1);
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
		
		refreshChart();


	}

	private void dateFocusLost(FocusEvent evt) {
		String date = null;

		if (buttonNum == 0)
			date = textDate.getText();

		else if (buttonNum == 1)
			date = textDateFrom.getText();

		else if (buttonNum == 2)
			date = textDateTo.getText();

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
			textDate.setText(dateString);
			buttonDate.setTargetDate(date);
			refreshReportDate(date);
		} else if (buttonNum == 1) {
			textDateFrom.setText(dateString);
			buttonDateFrom.setTargetDate(date);
			refreshChart();
		} else if (buttonNum == 2) {
			textDateTo.setText(dateString);
			buttonDateTo.setTargetDate(date);
			refreshChart();
		}
		TableColumn column = null;
		column = tableSalesReport.getColumnModel().getColumn(0);
		column.setCellRenderer(dtcr);
		column = tableSalesReport.getColumnModel().getColumn(1);
		column.setCellRenderer(dtcr);
		// if (buttonNum == 0) {
		// textDateFrom.setText(dateString);
		// buttonDateFrom.setTargetDate(date);
		// } else {
		// textDateTo.setText(dateString);
		// buttonDateTo.setTargetDate(date);
		// }
	}

	public void refreshReportDate(Date date) {
		String currentDate = dateSqlFormat.format(date);
		tableSalesReport.setModel(controller.refresh(currentDate));
	}

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

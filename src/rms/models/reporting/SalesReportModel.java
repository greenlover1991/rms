package rms.models.reporting;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import rms.models.BaseTableModel;
import rms.models.DataRow;

/*
 * @author Yu
 *
 */
public class SalesReportModel extends BaseTableModel implements
		TableModelListener {
	// String[] columnNames = { "Menu Item", "Qty Sold", "Price", "Credit",
	// "Cash", "Total" };
	// Object[][] data = { { "Tempura", "99", "10", "0", "990", "990" },
	// { "Chuckie", "199", "20", "2000", "1980", "3980" } };
	public List<String> columnNames;
	public List<String> columnAliases;
	public List<Class> columnClasses;
	public List<DataRow> rows;

	public SalesReportModel() {
		super();
		this.columnNames = new ArrayList<String>();
		this.columnAliases = new ArrayList<String>();
		this.columnClasses = new ArrayList<Class>();
		this.rows = new ArrayList<DataRow>();
	}

	public SalesReportModel(List<String> columnNames,
			List<String> columnAliases, List<Class> columnClasses,
			List<DataRow> rows) {
		this.columnNames = columnNames;
		this.columnAliases = columnAliases;
		this.columnClasses = columnClasses;
		this.rows = new ArrayList<DataRow>();
	}

	@Override
	public int getColumnCount() {
		return columnNames.size();
	}

	@Override
	public int getRowCount() {
		return rows.size();
	}

	public String getColumnName(int column) {
		return columnAliases.get(column);
	}

	@Override
	public Object getValueAt(int row, int column) {
		return rows.get(row).get(column);
	}
	
	public Object getValueAt(int row, String columnName) {
		return rows.get(row).get(columnName);
	}

	// determine default renderer/editor for each cell
	public Class<?> getColumnClass(int column) {
		return columnClasses.get(column);
	}

	// table data can change.
	public void setValueAt(Object value, int row, int column) {
		rows.get(row).set(value,column);
		fireTableCellUpdated(row, column);
	}
	
	public boolean isCellEditable(int row, int column) {
		return false;
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub

	}

	// @Override
	// public int getColumnCount() {
	// return columnNames.length;
	// }
	//
	// @Override
	// public int getRowCount() {
	// return data.length;
	// }
	//
	// public String getColumnName(int column) {
	// return columnNames[column];
	// }
	//
	// @Override
	// public Object getValueAt(int row, int column) {
	// return data[row][column];
	// }
	//
	// // determine default renderer/editor for each cell
	// public Class getColumnClass(int c) {
	// return getValueAt(0, c).getClass();
	// }
	//
	// // table data can change.
	// public void setValueAt(Object value, int row, int column) {
	// data[row][column] = value;
	// fireTableCellUpdated(row, column);
	// }
	//
	// @Override
	// public void tableChanged(TableModelEvent e) {
	// // TODO Auto-generated method stub
	//
	// }
}

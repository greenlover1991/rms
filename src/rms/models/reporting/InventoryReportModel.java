package rms.models.reporting;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/*
 * @author Yu
 *
 */
public class InventoryReportModel extends AbstractTableModel implements
		TableModelListener {
	String[] columnNames = { "Ingredients", "Initial", "In", "Out", "End" };
	Object[][] data = { { "Sesame Seeds", "99", "10", "20", "89" },
			{ "Pasta", "199", "20", "10", "189" } };

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return data.length;
	}

	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public Object getValueAt(int row, int column) {
		return data[row][column];
	}

	// determine default renderer/editor for each cell
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	// table data can change.
	public void setValueAt(Object value, int row, int column) {
		data[row][column] = value;
		fireTableCellUpdated(row, column);
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub

	}

}

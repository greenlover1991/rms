/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rms.models;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author squeekyclean
 */
public class BaseTableModel extends AbstractTableModel {
    public String tableName;
    public List<String> columnNames;
    public List<String> primaryColumns;
    public List<DataRow> rows;

    public BaseTableModel(String tableName){
        this.tableName = tableName;
        this.columnNames = new ArrayList<String>();
        this.primaryColumns = new ArrayList<String>();
    }

    public BaseTableModel(String tableName, List<String> columnNames, List<String> primaryColumns){
        this.tableName = tableName;
        this.columnNames = columnNames;
        this.primaryColumns = primaryColumns;
    }
    
    public int getRowCount() {
        return rows.size();
    }

    public int getColumnCount() {
        return columnNames.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return rows.get(rowIndex).get(columnIndex);
    }

    public Object getValueAt(int rowIndex, String columnName) {
        return rows.get(rowIndex).get(columnName);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        rows.get(rowIndex).set(aValue, columnIndex);
        fireTableCellUpdated(rowIndex, columnIndex);
    }
}

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
    public List<String> columnNames;
    public List<String> columnAliases;
    public List<Class> columnClasses;
    //public List<String> primaryColumns;
    public List<DataRow> rows;

    public BaseTableModel(){
        this.columnNames = new ArrayList<String>();
        this.columnAliases = new ArrayList<String>();
        this.columnClasses = new ArrayList<Class>();
        this.rows = new ArrayList<DataRow>(); 
    }

    public BaseTableModel(List<String> columnNames, List<String> columnAliases, List<Class> columnClasses){
        this.columnNames = columnNames;
        this.columnAliases = columnAliases;
        this.columnClasses = columnClasses;
        this.rows = new ArrayList<DataRow>();
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

    @Override
    public String getColumnName(int column) {
        return columnAliases.get(column);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClasses.get(columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }







}
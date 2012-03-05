/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EmployeeView.java
 *
 * Created on Feb 25, 2012, 8:06:06 PM
 */

package rms.views.management;
import extras.DateCellEditor;
import extras.IntegerCellEditor;
import extras.StringCellEditor;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;
import rms.ProjectConstants;
import rms.controllers.management.EmployeeController;
import rms.models.BaseTableModel;
import rms.models.DataRow;
import rms.models.management.EmployeeDBTable;


/**
 *
 * @author xmiez
 */
public class EmployeeView extends javax.swing.JInternalFrame {
    private EmployeeController controller;
    DateFormat formatter;
    private TableRowSorter<BaseTableModel> sorter;

    private static EmployeeView INSTANCE;
    /** Creates new form MasterFilesUI */
    private EmployeeView() {
        initComponents();
        controller = new EmployeeController(this);

        initValidations();
        refreshData();
        sorter = new TableRowSorter<BaseTableModel>((BaseTableModel)jTable1.getModel());
        jTable1.setRowSorter(sorter);
        searchField.getDocument().addDocumentListener(
            new DocumentListener() {
                public void changedUpdate(DocumentEvent e) {
                    newFilter();
                }
                public void insertUpdate(DocumentEvent e)  {
                    newFilter();
                }
                public void removeUpdate(DocumentEvent e)
                {
                    newFilter();
                }
            }
        );
       }

    public static EmployeeView getInstance(){
        if(INSTANCE == null)
            INSTANCE = new EmployeeView();
        return INSTANCE;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        masterFileLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        addButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(221, 221, 221));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(34, 34, 34));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        masterFileLabel.setFont(new java.awt.Font("Tahoma", 1, 20));
        masterFileLabel.setForeground(new java.awt.Color(255, 255, 255));
        masterFileLabel.setText("EMPLOYEE");

        addButton.setFont(new java.awt.Font("Tahoma", 1, 12));
        addButton.setForeground(new java.awt.Color(153, 153, 153));
        addButton.setText("Add");
        addButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        addButton.setContentAreaFilled(false);
        addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addButton.setFocusPainted(false);
        addButton.setMargin(new java.awt.Insets(2, 0, 2, 0));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        loadButton.setFont(new java.awt.Font("Tahoma", 1, 12));
        loadButton.setForeground(new java.awt.Color(153, 153, 153));
        loadButton.setText("Refresh");
        loadButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        loadButton.setContentAreaFilled(false);
        loadButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loadButton.setMargin(new java.awt.Insets(2, 0, 2, 0));
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        saveButton.setFont(new java.awt.Font("Tahoma", 1, 12));
        saveButton.setForeground(new java.awt.Color(153, 153, 153));
        saveButton.setText("Save");
        saveButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        saveButton.setContentAreaFilled(false);
        saveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveButton.setMargin(new java.awt.Insets(2, 0, 2, 0));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        addButton1.setFont(new java.awt.Font("Tahoma", 1, 12));
        addButton1.setForeground(new java.awt.Color(153, 153, 153));
        addButton1.setText("Delete");
        addButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        addButton1.setContentAreaFilled(false);
        addButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addButton1.setFocusPainted(false);
        addButton1.setMargin(new java.awt.Insets(2, 0, 2, 0));
        addButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(masterFileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(loadButton, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(addButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(57, 57, 57))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(masterFileLabel)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        searchField.setFont(new java.awt.Font("Tahoma", 2, 12));
        searchField.setForeground(new java.awt.Color(102, 102, 102));
        searchField.setText("Search...");
        searchField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        searchField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchFieldFocusLost(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setAutoscrolls(true);

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Last Name", "First Name", "Middle Name", "Birthdate", "Landline Number", "Mobile Number", "Address", "Role", "Login", "Password"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchField, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
         if(canAddRow())
            addRow();
    }//GEN-LAST:event_addButtonActionPerformed

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        // TODO add your handling code here:
        refreshData();
    }//GEN-LAST:event_loadButtonActionPerformed

    private void addButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton1ActionPerformed
        // TODO add your handling code here:
        setInactive();
    }//GEN-LAST:event_addButton1ActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        saveData();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_searchFieldActionPerformed

    private void searchFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFieldFocusGained
        // TODO add your handling code here:
        if(searchField.getText().equalsIgnoreCase("Search..."))
            searchField.setText("");
    }//GEN-LAST:event_searchFieldFocusGained

    private void searchFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFieldFocusLost
        // TODO add your handling code here:
        if(searchField.getText().equalsIgnoreCase(""))
            searchField.setText("Search...");
    }//GEN-LAST:event_searchFieldFocusLost

    public void refreshData(){
        jTable1.setModel(controller.refreshData());
        removeInvisibleColumns();
        if(sorter != null)
            sorter.setModel((BaseTableModel)jTable1.getModel());
        jTable1.setRowSorter(sorter);
    }

    public void saveData(){
        controller.save();
        refreshData();
    }

    public void setInactive(){
        int[] rows = jTable1.getSelectedRows();
        for(int i : rows){
            int rowId = jTable1.convertRowIndexToModel(i);
            int colId = ((BaseTableModel)jTable1.getModel()).findColumn(EmployeeDBTable.STATUS);
            int idColId = ((BaseTableModel)jTable1.getModel()).findColumn(EmployeeDBTable.ID);
            // if has no id, dont inactivate
            Object id = jTable1.getModel().getValueAt(rowId, idColId);
            if(id == null || id.toString().isEmpty())
               ((BaseTableModel)jTable1.getModel()).removeRow(rowId);
            else
               jTable1.getModel().setValueAt(ProjectConstants.STATUS_INACTIVE, rowId, colId);
        }
        controller.save();
        refreshData();
    }

    private void initValidations() {
        jTable1.setDefaultEditor(Integer.class, new IntegerCellEditor(true,1, Integer.MAX_VALUE));
        jTable1.setDefaultEditor(Date.class, new DateCellEditor());

        jTable1.setDefaultRenderer(Date.class, new DefaultTableCellRenderer.UIResource(){

            @Override
            protected void setValue(Object value) {
                if (formatter==null) {
		formatter = DateFormat.getDateInstance(DateFormat.MEDIUM);
	    }
	    setText((value == null) ? "" : formatter.format(value));
            }

        });
        jTable1.setDefaultEditor(String.class, new StringCellEditor(1, 255));
       //jTable1.getColumn(EmployeeDBTable.ALIAS_ADDRESS).setCellEditor(new StringCellEditor(0, 3));
       //jTable1.getColumn(EmployeeDBTable.ALIAS_F_NAME).setCellEditor(new StringCellEditor(1, 5));
    }

    private void removeInvisibleColumns(){
        for(String inviColumn : EmployeeDBTable.getInstance().getInvisibleColumns()){
            jTable1.removeColumn(jTable1.getColumn(inviColumn));
        }
    }

    private boolean canAddRow(){
        BaseTableModel model = (BaseTableModel)jTable1.getModel();
        DataRow lastRow = model.getLastRow();
        boolean isValid = true;
        for(String column : EmployeeDBTable.getInstance().getNonNullableColumns()){
            if(lastRow != null && (lastRow.get(column) == null || lastRow.get(column).toString().isEmpty())){
                isValid = false;
                break;
            }
        }

        return isValid;
    }

    private void addRow() {
        BaseTableModel model = (BaseTableModel)jTable1.getModel();
        List<String> columnNames = Arrays.asList(EmployeeDBTable.getInstance().getColumns());
        List<Object> values = new ArrayList<Object>(columnNames.size());
        for(int i=0;i<columnNames.size()-1;i++ )
        values.add(null);
        values.add(ProjectConstants.STATUS_ACTIVE);
        DataRow row = new DataRow(columnNames, values);
        model.addRow(row);
    }
    private void newFilter() {

        RowFilter<BaseTableModel , Object> rf = null;
        //declare a row filter for your table model
        try {
            if(!searchField.getText().equals("Search..."))
              rf = RowFilter.regexFilter(searchField.getText(), 0);
            //initialize with a regular expression
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton addButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton loadButton;
    private javax.swing.JLabel masterFileLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables

}

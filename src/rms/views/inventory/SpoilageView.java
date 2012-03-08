/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SpoilageView.java
 *
 * Created on 02 7, 12, 11:17:43 PM
 */

package rms.views.inventory;

import java.text.DateFormat;
import java.util.Date;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;
import rms.controllers.inventory.SpoilageInventoryController;
import rms.models.BaseTableModel;
import rms.models.management.IngredientDBTable;

/**
 *
 * @author squeekyclean
 */
public class SpoilageView extends javax.swing.JInternalFrame {

    SpoilageInventoryController controller;
    private static SpoilageView INSTANCE;

    private TableRowSorter<BaseTableModel> sorter;

    /** Creates new form SpoilageView */
    private SpoilageView() {
        initComponents();
        txtDate.setText(DateFormat.getDateInstance(DateFormat.LONG).format(new Date()));
        controller = new SpoilageInventoryController(this);
        loadIngredients();
        loadSpoilageOfTheDay();
        
        sorter = new TableRowSorter<BaseTableModel>((BaseTableModel)tblIngredients.getModel());
        tblIngredients.setRowSorter(sorter);
        txtFilter.getDocument().addDocumentListener(
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

    public static SpoilageView getInstance(){
        if(INSTANCE == null)
            INSTANCE = new SpoilageView();
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

        btnSave = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSpoilage = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblIngredients = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        txtDate = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtFilter = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Spoilage Form");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnRemove.setText("<<");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 0, 24));
        jLabel2.setText("Spoilage Report");

        tblSpoilage.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Pepper", "1", "kg", ""},
                {"Patty", "1", "kg", "expired"},
                {"Buns", "10", "pcs", "R.A.T."}
            },
            new String [] {
                "Item", "Quantity", "Measurement", "Reason/Remarks"
            }
        ));
        jScrollPane1.setViewportView(tblSpoilage);

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tblIngredients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Carrots"},
                {"Buns"},
                {"Calmansi"},
                {"Ginger"},
                {"Potato"},
                {"Banana"},
                {"Lettuce"}
            },
            new String [] {
                "Ingredients"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblIngredients.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblIngredients.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(tblIngredients);

        btnAdd.setText(">>");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        txtDate.setText("March 10, 2012");

        jLabel1.setText("Date:");

        txtFilter.setFont(new java.awt.Font("Tahoma", 2, 12));
        txtFilter.setForeground(new java.awt.Color(102, 102, 102));
        txtFilter.setText("Search...");
        txtFilter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        txtFilter.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFilterFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFilterFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFilter)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRemove)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDate))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(25, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDate)
                                    .addComponent(jLabel1))
                                .addGap(14, 14, 14))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(13, 13, 13)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, 0, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFilterFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFilterFocusGained
        // TODO add your handling code here:
        if(txtFilter.getText().equalsIgnoreCase("Search..."))
            txtFilter.setText("");
}//GEN-LAST:event_txtFilterFocusGained

    private void txtFilterFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFilterFocusLost
        // TODO add your handling code here:
        if(txtFilter.getText().equalsIgnoreCase(""))
            txtFilter.setText("Search...");
}//GEN-LAST:event_txtFilterFocusLost

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        int rowIndx = tblIngredients.getSelectedRow();
        if(rowIndx != -1){
            int ingredientId = Integer.parseInt(tblIngredients.getModel().getValueAt(rowIndx, 1).toString());
            controller.add(ingredientId);
            loadIngredients();
            loadSpoilageOfTheDay();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        controller.save((BaseTableModel)tblSpoilage.getModel());
        loadSpoilageOfTheDay();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        int rowIndx = tblSpoilage.getSelectedRow();
        if(rowIndx != -1){
            int sri_id = Integer.parseInt(tblSpoilage.getModel().getValueAt(rowIndx, 1).toString());
            controller.remove(sri_id);
            loadIngredients();
            loadSpoilageOfTheDay();
        }
    }//GEN-LAST:event_btnRemoveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblIngredients;
    private javax.swing.JTable tblSpoilage;
    public javax.swing.JLabel txtDate;
    private javax.swing.JTextField txtFilter;
    // End of variables declaration//GEN-END:variables

    private void loadIngredients() {
        tblIngredients.setModel(controller.loadIngredients());
        removeIngredientsColumns();
    }

    private void loadSpoilageOfTheDay() {
        tblSpoilage.setModel(controller.loadSpoilage());
        removeSpoilageColumns();
    }

    private void newFilter() {
        RowFilter<BaseTableModel , Object> rf = null;
        //declare a row filter for your table model
        try {
            if(!txtFilter.getText().equals("Search..."))
              rf = RowFilter.regexFilter(txtFilter.getText(), 0);
            //initialize with a regular expression
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
    }

    private void removeIngredientsColumns() {
        tblIngredients.removeColumn(tblIngredients.getColumn(IngredientDBTable.ALIAS_ID));
    }

    private void removeSpoilageColumns() {
        tblSpoilage.removeColumn(tblSpoilage.getColumn("id"));
        tblSpoilage.removeColumn(tblSpoilage.getColumn("spoilage_report_id"));
        tblSpoilage.removeColumn(tblSpoilage.getColumn("ingredient_id"));
    }
}

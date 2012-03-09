/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SupplierPriceListView.java
 *
 * Created on Feb 25, 2012, 8:06:06 PM
 */

package rms.views.management;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;
import rms.controllers.management.SupplierPriceListController;
import rms.models.BaseTableModel;
import rms.models.management.IngredientDBTable;
import rms.models.management.SupplierDBTable;
import rms.models.management.SupplierPriceListDBTable;

/**
 *
 * @author xmiez
 */
public class SupplierPriceListView extends javax.swing.JInternalFrame {

    private SupplierPriceListController controller;
    private TableRowSorter<BaseTableModel> sorter;
    private TableRowSorter<BaseTableModel> sorter2;

    private static SupplierPriceListView INSTANCE;
    /** Creates new form MasterFilesUI */
    private SupplierPriceListView() {
        initComponents();
        controller = new SupplierPriceListController(this);

        //initValidations();
        refreshData();
        sorter = new TableRowSorter<BaseTableModel>((BaseTableModel)SupplierTable.getModel());
        sorter2 = new TableRowSorter<BaseTableModel>((BaseTableModel)IngredientsTable.getModel());
        SupplierTable.setRowSorter(sorter);
        IngredientsTable.setRowSorter(sorter2);
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
        searchField1.getDocument().addDocumentListener(
            new DocumentListener() {
                public void changedUpdate(DocumentEvent e) {
                    newFilter2();
                }
                public void insertUpdate(DocumentEvent e)  {
                    newFilter2();
                }
                public void removeUpdate(DocumentEvent e)
                {
                    newFilter2();
                }
            }
        );
       }

    public static SupplierPriceListView getInstance(){
        if(INSTANCE == null)
            INSTANCE = new SupplierPriceListView();
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
        loadButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        SupplierTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        searchField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        IngredientsTable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        masterFileLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        PriceListTable = new javax.swing.JTable();
        removeIngFromPriceList = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        masterFileLabel2 = new javax.swing.JLabel();
        save = new javax.swing.JButton();

        setBackground(new java.awt.Color(221, 221, 221));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(34, 34, 34));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        masterFileLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        masterFileLabel.setForeground(new java.awt.Color(255, 255, 255));
        masterFileLabel.setText("Supplier");

        loadButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        loadButton.setForeground(new java.awt.Color(153, 153, 153));
        loadButton.setText("Refresh");
        loadButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        loadButton.setContentAreaFilled(false);
        loadButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loadButton.setFocusPainted(false);
        loadButton.setMargin(new java.awt.Insets(2, 0, 2, 0));
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(masterFileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addComponent(loadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(masterFileLabel))
                    .addComponent(loadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        searchField.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        searchField.setForeground(new java.awt.Color(102, 102, 102));
        searchField.setText("Search...");
        searchField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        searchField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchFieldFocusLost(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setAutoscrolls(true);

        SupplierTable.setAutoCreateRowSorter(true);
        SupplierTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Name", "Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        SupplierTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        SupplierTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SupplierTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SupplierTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(SupplierTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(searchField))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        searchField1.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        searchField1.setForeground(new java.awt.Color(102, 102, 102));
        searchField1.setText("Search...");
        searchField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        searchField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchField1FocusLost(evt);
            }
        });

        IngredientsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        IngredientsTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane2.setViewportView(IngredientsTable);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(153, 153, 153));
        jButton2.setText(">>");
        jButton2.setToolTipText("Add selected ingredient to price list");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchField1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );

        jPanel4.setBackground(new java.awt.Color(34, 34, 34));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        masterFileLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        masterFileLabel1.setForeground(new java.awt.Color(255, 255, 255));
        masterFileLabel1.setText("Ingredients");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(masterFileLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(masterFileLabel1)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        PriceListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ingredient", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        PriceListTable.setCellSelectionEnabled(true);
        jScrollPane3.setViewportView(PriceListTable);

        removeIngFromPriceList.setBackground(new java.awt.Color(34, 34, 34));
        removeIngFromPriceList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        removeIngFromPriceList.setForeground(new java.awt.Color(153, 153, 153));
        removeIngFromPriceList.setText("<<");
        removeIngFromPriceList.setToolTipText("Remove Ingredient from Price List");
        removeIngFromPriceList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        removeIngFromPriceList.setContentAreaFilled(false);
        removeIngFromPriceList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        removeIngFromPriceList.setFocusPainted(false);
        removeIngFromPriceList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeIngFromPriceListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                    .addComponent(removeIngFromPriceList, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeIngFromPriceList, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(34, 34, 34));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        masterFileLabel2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        masterFileLabel2.setForeground(new java.awt.Color(255, 255, 255));
        masterFileLabel2.setText("Price List");

        save.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        save.setForeground(new java.awt.Color(153, 153, 153));
        save.setText("Save");
        save.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        save.setContentAreaFilled(false);
        save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save.setMargin(new java.awt.Insets(2, 0, 2, 0));
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(masterFileLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(masterFileLabel2))
                    .addComponent(save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(59, 59, 59))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int rowId = SupplierTable.getSelectedRow();
        int row2Id = IngredientsTable.getSelectedRow();
        int SupplierId = Integer.parseInt(((BaseTableModel)SupplierTable.getModel()).getValueAt(rowId, SupplierDBTable.ID).toString());
        int IngId = Integer.parseInt(((BaseTableModel)IngredientsTable.getModel()).getValueAt(row2Id, IngredientDBTable.ID).toString());
        if (controller.AddIngredientToPriceList(IngId, SupplierId)){
            IngredientsTable.setModel(controller.loadIngredients(SupplierId));
            PriceListTable.setModel(controller.loadPriceList(SupplierId));
            removeInvisibleColumnsOnPriceList();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void removeIngFromPriceListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeIngFromPriceListActionPerformed
        // TODO add your handling code here:
        int rowId = PriceListTable.getSelectedRow();
        int SupplierId = Integer.parseInt(((BaseTableModel)PriceListTable.getModel()).getValueAt(rowId, SupplierPriceListDBTable.SUPPLIER_ID).toString());
        int IngId = Integer.parseInt(((BaseTableModel)PriceListTable.getModel()).getValueAt(rowId, SupplierPriceListDBTable.INGREDIENT_ID).toString());
        if (controller.removeIngredientFromPriceList(IngId, SupplierId)){
            IngredientsTable.setModel(controller.loadIngredients(SupplierId));
            PriceListTable.setModel(controller.loadPriceList(SupplierId));
            removeInvisibleColumnsOnPriceList();
        }

    }//GEN-LAST:event_removeIngFromPriceListActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        controller.savePriceList((BaseTableModel)PriceListTable.getModel());
}//GEN-LAST:event_saveActionPerformed

    private void SupplierTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SupplierTableMouseClicked
        // TODO add your handling code here:
        int rowId = SupplierTable.getSelectedRow();
        int SupplierId = Integer.parseInt(((BaseTableModel)SupplierTable.getModel()).getValueAt(rowId, SupplierDBTable.ID).toString());
        IngredientsTable.setModel(controller.loadIngredients(SupplierId));
        PriceListTable.setModel(controller.loadPriceList(SupplierId));
        removeInvisibleColumnsOnPriceList();
    }//GEN-LAST:event_SupplierTableMouseClicked

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        // TODO add your handling code here:
        refreshData();
}//GEN-LAST:event_loadButtonActionPerformed

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

    private void searchField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchField1FocusGained
        // TODO add your handling code here:
        if(searchField1.getText().equalsIgnoreCase("Search..."))
            searchField1.setText("");
    }//GEN-LAST:event_searchField1FocusGained

    private void searchField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchField1FocusLost
        // TODO add your handling code here:
        if(searchField1.getText().equalsIgnoreCase(""))
            searchField1.setText("Search...");
    }//GEN-LAST:event_searchField1FocusLost

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
    private void newFilter2() {

        RowFilter<BaseTableModel , Object> rf = null;
        //declare a row filter for your table model
        try {
            if(!searchField1.getText().equals("Search..."))
              rf = RowFilter.regexFilter(searchField1.getText(), 0);
            //initialize with a regular expression
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter2.setRowFilter(rf);
    }
    
    public void refreshData(){
        SupplierTable.setModel(controller.refreshData());
        removeInvisibleColumns();
        if(sorter != null)
            sorter.setModel((BaseTableModel)SupplierTable.getModel());
        SupplierTable.setRowSorter(sorter);
    }

    private void initValidations() {
        //SupplierTable.setDefaultEditor(Integer.class, new IntegerCellEditor(true,1, Integer.MAX_VALUE));
       // SupplierTable.setDefaultEditor(String.class, new StringCellEditor(1, 40));
       //jTable1.getColumn(EmployeeDBTable.ALIAS_ADDRESS).setCellEditor(new StringCellEditor(0, 3));
       //jTable1.getColumn(EmployeeDBTable.ALIAS_F_NAME).setCellEditor(new StringCellEditor(1, 5));
    }

    private void removeInvisibleColumns(){
        for(String inviColumn : SupplierDBTable.getInstance().getInvisibleColumns()){
            SupplierTable.removeColumn(SupplierTable.getColumn(inviColumn));
        }
    }
    private void removeInvisibleColumnsOnPriceList(){
        IngredientsTable.removeColumn(IngredientsTable.getColumn(IngredientDBTable.ALIAS_ID));
        PriceListTable.removeColumn(PriceListTable.getColumn(SupplierPriceListDBTable.INGREDIENT_ID));
        PriceListTable.removeColumn(PriceListTable.getColumn(SupplierPriceListDBTable.SUPPLIER_ID));
        PriceListTable.removeColumn(PriceListTable.getColumn(SupplierPriceListDBTable.ID));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable IngredientsTable;
    private javax.swing.JTable PriceListTable;
    private javax.swing.JTable SupplierTable;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton loadButton;
    private javax.swing.JLabel masterFileLabel;
    private javax.swing.JLabel masterFileLabel1;
    private javax.swing.JLabel masterFileLabel2;
    private javax.swing.JButton removeIngFromPriceList;
    private javax.swing.JButton save;
    private javax.swing.JTextField searchField;
    private javax.swing.JTextField searchField1;
    // End of variables declaration//GEN-END:variables

}

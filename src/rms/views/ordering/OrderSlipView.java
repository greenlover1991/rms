/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rms.views.ordering;

import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import rms.ProjectConstants;
import rms.controllers.ordering.OrderSlipController;
import rms.models.BaseTableModel;
import rms.models.management.MenuItemsDBTable;
import rms.models.ordering.OrderSlipDBTable;
import rms.models.ordering.OrderSlipItemsDBTable;
import rms.views.MainApplicationView;

/**
 *
 * @author Midori
 */
public class OrderSlipView extends javax.swing.JInternalFrame {

    private BillOutView billOut;
    private NewOrderView newOrder;
    private static MainApplicationView parent;
    private static OrderSlipView INSTANCE;
    private TableRowSorter<BaseTableModel> sorter;
    OrderSlipController controller;
    public StringBuilder prevTables;
    /** Creates new form MasterFilesUI */
    private OrderSlipView() {
        initComponents();
        controller = new OrderSlipController(this);
        prevTables = new StringBuilder();
        resetViews();
        refreshData();

        sorter = new TableRowSorter<BaseTableModel>((BaseTableModel)tblMenuItems.getModel());
        tblMenuItems.setRowSorter(sorter);
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

    public static OrderSlipView getInstance(MainApplicationView parent){
        if(INSTANCE == null){
            INSTANCE = new OrderSlipView();
            OrderSlipView.parent = parent;
        }
        return INSTANCE;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrderItems = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblMenuItems = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAddItem = new javax.swing.JButton();
        btnNewOS = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblOrderSlips = new javax.swing.JTable();
        btnQueueOS = new javax.swing.JButton();
        btnUpdateOSI = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnRemoveItem = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnSaveOS = new javax.swing.JButton();
        btnDeleteOS = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnBillOut = new javax.swing.JButton();
        lblDate = new javax.swing.JLabel();
        txtNetAmount = new javax.swing.JTextField();
        txtNetDiscount = new javax.swing.JTextField();
        txtGrandTotal = new javax.swing.JTextField();
        txtTables = new javax.swing.JTextField();
        txtOrderSlipId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnChooser = new javax.swing.JButton();
        txtCustomers = new javax.swing.JSpinner();
        cmbWaiters = new javax.swing.JComboBox();
        searchField = new javax.swing.JTextField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setTitle("Order Slip");

        tblOrderItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Quantity", "Particulars", "Unit Price", "Discount Rate", "No. of Discounted Items", "Total", "Status"
            }
        ));
        tblOrderItems.setGridColor(new java.awt.Color(204, 204, 204));
        tblOrderItems.setInheritsPopupMenu(true);
        jScrollPane2.setViewportView(tblOrderItems);
        tblOrderItems.getColumnModel().getColumn(0).setResizable(false);
        tblOrderItems.getColumnModel().getColumn(1).setResizable(false);
        tblOrderItems.getColumnModel().getColumn(2).setResizable(false);
        tblOrderItems.getColumnModel().getColumn(3).setResizable(false);
        tblOrderItems.getColumnModel().getColumn(4).setResizable(false);
        tblOrderItems.getColumnModel().getColumn(5).setResizable(false);
        tblOrderItems.getColumnModel().getColumn(6).setResizable(false);

        tblMenuItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Category", "Item", "Price", "Stocks"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMenuItems.setGridColor(new java.awt.Color(204, 204, 204));
        tblMenuItems.setInheritsPopupMenu(true);
        tblMenuItems.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblMenuItems);
        tblMenuItems.getColumnModel().getColumn(0).setResizable(false);
        tblMenuItems.getColumnModel().getColumn(1).setResizable(false);
        tblMenuItems.getColumnModel().getColumn(2).setResizable(false);

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        jLabel2.setText("Orders");

        jLabel4.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        jLabel4.setText("Menu");

        btnAddItem.setText(">>");
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemActionPerformed(evt);
            }
        });

        btnNewOS.setText("New Order Slip");
        btnNewOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewOSActionPerformed(evt);
            }
        });

        tblOrderSlips.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Order", "Table", "Balance", "Waiter", "Take out"
            }
        ));
        tblOrderSlips.setGridColor(new java.awt.Color(204, 204, 204));
        tblOrderSlips.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrderSlipsMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblOrderSlips);

        btnQueueOS.setText("Queue Order to Kitchen");
        btnQueueOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQueueOSActionPerformed(evt);
            }
        });

        btnUpdateOSI.setText("Make Changes");
        btnUpdateOSI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateOSIActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnRemoveItem.setText("<<");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        jLabel3.setText("Order Slip:");

        jLabel5.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        jLabel5.setText("Table:");

        btnSaveOS.setText("Update");
        btnSaveOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveOSActionPerformed(evt);
            }
        });

        btnDeleteOS.setText("Cancel");
        btnDeleteOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteOSActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        jLabel6.setText("No. of Customers:");

        jLabel7.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        jLabel7.setText("Waiter:");

        btnBillOut.setText("Bill Out");
        btnBillOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBillOutActionPerformed(evt);
            }
        });

        lblDate.setText("March 8, 2012 12:00 PM");

        txtNetAmount.setEditable(false);
        txtNetAmount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtNetDiscount.setEditable(false);
        txtNetDiscount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtGrandTotal.setEditable(false);
        txtGrandTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtTables.setEditable(false);
        txtTables.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtOrderSlipId.setEditable(false);
        txtOrderSlipId.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel8.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        jLabel8.setText("Net Amount:");

        jLabel9.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        jLabel9.setText("Net Discount:");

        jLabel10.setFont(new java.awt.Font("DejaVu Sans", 1, 14));
        jLabel10.setText("Grand Total:");

        btnChooser.setText("...");
        btnChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooserActionPerformed(evt);
            }
        });

        txtCustomers.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        cmbWaiters.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSaveOS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteOS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 274, Short.MAX_VALUE)
                        .addComponent(btnBillOut))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCustomers))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtOrderSlipId, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTables, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnChooser))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbWaiters, 0, 126, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(lblDate))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNetDiscount, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                    .addComponent(txtGrandTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                    .addComponent(txtNetAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblDate)
                    .addComponent(txtOrderSlipId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTables, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNetAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(btnChooser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNetDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addComponent(cmbWaiters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBillOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSaveOS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeleteOS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane3, 0, 0, Short.MAX_VALUE)
                                    .addComponent(searchField)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnNewOS)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnRefresh))
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnAddItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnRemoveItem, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)))
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnQueueOS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdateOSI)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNewOS)
                            .addComponent(btnRefresh))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btnAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnRemoveItem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateOSI, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQueueOS, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQueueOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQueueOSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQueueOSActionPerformed

    private void btnUpdateOSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateOSIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateOSIActionPerformed

    private void btnBillOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBillOutActionPerformed
         // TODO add your handling code here:
        billOut = new BillOutView(parent, true);
        billOut.setVisible(true);
        
    }//GEN-LAST:event_btnBillOutActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        resetViews();
        refreshData();
    }//GEN-LAST:event_btnRefreshActionPerformed

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

    private void btnNewOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewOSActionPerformed
        // TODO add your handling code here:
        newOrder = new NewOrderView(parent, true);
        // if save succesfully, refresh
        if(newOrder.showDialog()){
            resetViews();
            refreshData();
        }
    }//GEN-LAST:event_btnNewOSActionPerformed

    private void btnChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooserActionPerformed
        // TODO add your handling code here:
        TableChooserView chooser = new TableChooserView(parent, true, txtTables.getText());
        String tables = chooser.showDialog();
        if(tables != null && !tables.isEmpty())
            txtTables.setText(tables);
}//GEN-LAST:event_btnChooserActionPerformed

    private void btnSaveOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveOSActionPerformed
        // TODO add your handling code here:
        controller.updateOrderSlipDetails();
        tblOrderSlipsMouseClicked(null);
        loadOrderSlips();
}//GEN-LAST:event_btnSaveOSActionPerformed

    private void tblOrderSlipsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrderSlipsMouseClicked
        // TODO add your handling code here:
        int rowId = tblOrderSlips.getSelectedRow();

        if(rowId >= 0){
            BaseTableModel model = (BaseTableModel)tblOrderSlips.getModel();
            int orderSlipId = Integer.parseInt(model.getValueAt(tblOrderSlips.convertRowIndexToModel(rowId), model.findColumn(OrderSlipDBTable.ID)).toString());
            loadOrderSlipDetails(orderSlipId);
            loadOrderItems(orderSlipId);
        }
    }//GEN-LAST:event_tblOrderSlipsMouseClicked

    private void btnDeleteOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteOSActionPerformed
        // TODO add your handling code here:
        if(txtOrderSlipId.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Cannot cancel non-existing order slips.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else if(Double.parseDouble(txtGrandTotal.getText()) > 0.0){
            JOptionPane.showMessageDialog(this, "Cannot cancel order slips with orders.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else{
            if(JOptionPane.showConfirmDialog(this, ProjectConstants.MSG_CONFIRM_DELETE, "Cancelling Order", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                controller.cancelOrderSlip(txtOrderSlipId.getText());
                resetViews();
                loadOrderSlips();
            }
        }
    }//GEN-LAST:event_btnDeleteOSActionPerformed

    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemActionPerformed
        // TODO add your handling code here:
        int rowId = tblMenuItems.getSelectedRow();
        String orderSlipId = txtOrderSlipId.getText();
        if(!orderSlipId.trim().isEmpty() && rowId >= 0){
            BaseTableModel model = (BaseTableModel)tblMenuItems.getModel();
            int menuItemId = Integer.parseInt(model.getValueAt(tblMenuItems.convertRowIndexToModel(rowId), model.findColumn(MenuItemsDBTable.ID)).toString());
            addMenuItemId(menuItemId, Integer.parseInt(orderSlipId));
        }
    }//GEN-LAST:event_btnAddItemActionPerformed

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
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnBillOut;
    private javax.swing.JButton btnChooser;
    private javax.swing.JButton btnDeleteOS;
    private javax.swing.JButton btnNewOS;
    private javax.swing.JButton btnQueueOS;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRemoveItem;
    private javax.swing.JButton btnSaveOS;
    private javax.swing.JButton btnUpdateOSI;
    public javax.swing.JComboBox cmbWaiters;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JLabel lblDate;
    private javax.swing.JTextField searchField;
    private javax.swing.JTable tblMenuItems;
    private javax.swing.JTable tblOrderItems;
    private javax.swing.JTable tblOrderSlips;
    public javax.swing.JSpinner txtCustomers;
    public javax.swing.JTextField txtGrandTotal;
    public javax.swing.JTextField txtNetAmount;
    public javax.swing.JTextField txtNetDiscount;
    public javax.swing.JTextField txtOrderSlipId;
    public javax.swing.JTextField txtTables;
    // End of variables declaration//GEN-END:variables

    private void refreshData() {
        loadOrderSlips();
        loadMenuItems();
    }

    private void loadOrderSlips(){
        tblOrderSlips.setModel(controller.loadOrderSlips());
    }

    private void loadMenuItems(){
        tblMenuItems.setModel(controller.loadMenuItems());
        tblMenuItems.removeColumn(tblMenuItems.getColumn(MenuItemsDBTable.ALIAS_MENU_CAT_ID));
    }

    private void loadOrderSlipDetails(int orderSlipId) {
        controller.loadOrderSlipDetails(orderSlipId);
    }
    private void resetViews(){
        prevTables.delete(0, prevTables.length());
        txtCustomers.setValue(new Integer(0));
        txtGrandTotal.setText("");
        txtNetAmount.setText("");
        txtNetDiscount.setText("");
        txtOrderSlipId.setText("");
        txtTables.setText("");
        lblDate.setText("");

        tblOrderItems.setModel(new DefaultTableModel());
    }

    private void addMenuItemId(int menuItemId, int orderItemId) {
        controller.addMenuItemId(menuItemId, orderItemId);
    }

    private void loadOrderItems(int orderSlipId) {
        tblOrderItems.setModel(controller.loadOrderItems(orderSlipId));
        tblOrderItems.removeColumn(tblOrderItems.getColumn(OrderSlipItemsDBTable.ID));
    }
    
}

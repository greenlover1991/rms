/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewOrderView.java
 *
 * Created on 03 8, 12, 1:09:52 PM
 */

package rms.views.ordering;

import java.awt.Frame;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import rms.models.BaseTableModel;
import supports.DataSupport;

/**
 *
 * @author squeekyclean
 */
public class NewOrderView extends javax.swing.JDialog {

    boolean result = false;
    Frame parent;
    /** Creates new form NewOrderView */
    public NewOrderView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        initComponents();
        setLocationRelativeTo(parent);
        loadWaiters();

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIsTakeOut = new javax.swing.JCheckBox();
        txtTables = new javax.swing.JTextField();
        btnTableChooser = new javax.swing.JButton();
        txtCustomers = new javax.swing.JSpinner();
        btnSave = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cmbWaiter = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New Order");
        setAlwaysOnTop(true);
        setResizable(false);

        jLabel1.setText("Tables:");

        jLabel2.setText("No. Of Customers:");

        txtIsTakeOut.setText("Take Out");

        txtTables.setEditable(false);

        btnTableChooser.setText("...");
        btnTableChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTableChooserActionPerformed(evt);
            }
        });

        txtCustomers.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel3.setText("Waiter:");

        cmbWaiter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtIsTakeOut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbWaiter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtTables, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addComponent(btnTableChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTables, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTableChooser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbWaiter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIsTakeOut)
                    .addComponent(btnSave))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if(save()){
            setVisible(false);
            dispose();
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnTableChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTableChooserActionPerformed
        // TODO add your handling code here:
        TableChooserView chooser = new TableChooserView(parent, true);
        String tables = chooser.showDialog();
        if(tables != null && !tables.isEmpty())
            txtTables.setText(tables);
    }//GEN-LAST:event_btnTableChooserActionPerformed

    public boolean showDialog(){
        setVisible(true);
        return result;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnTableChooser;
    private javax.swing.JComboBox cmbWaiter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSpinner txtCustomers;
    private javax.swing.JCheckBox txtIsTakeOut;
    private javax.swing.JTextField txtTables;
    // End of variables declaration//GEN-END:variables

    private boolean save() {
        boolean res = false;
        String tbs = txtTables.getText();
        int noOfCustomers = Integer.parseInt(txtCustomers.getValue().toString());
        String loginName = cmbWaiter.getSelectedItem().toString();
        int isTakeout = txtIsTakeOut.isSelected() ? 1 : 0;
        
        if(isTakeout==1)
            tbs = "";
        // if has tables and is not take out
        String query = String.format("INSERT INTO order_slips(id, datetime_of_order, waited_by, total_amount, grand_total, order_status, number_of_customers, is_takeout, status) " +
                "   VALUES(null, NOW(), (SELECT id FROM employees WHERE login = '%s'), 0, 0, 'Active', %d, %d,  'Active');", loginName, noOfCustomers, isTakeout);
        StringBuilder tblSql = new StringBuilder();
        tblSql.append(String.format("UPDATE restaurant_tables SET table_status = 'Occupied', order_slip_id = LAST_INSERT_ID() WHERE table_number IN (%s)", tbs));
        DataSupport dh;
        try {
            dh = new DataSupport();
            List<String> sqls = new ArrayList<String>();
            sqls.add(query);
            if(isTakeout==0){
                sqls.add(tblSql.toString());
            }
            dh.executeBatchUpdate(sqls);
            res = true;
        } catch (SQLException ex) {
            Logger.getLogger(NewOrderView.class.getName()).log(Level.SEVERE, null, ex);
        }

        return res;
    }

    private void loadWaiters() {
        try {
            DataSupport dh = new DataSupport();
            String query = "SELECT login FROM employees WHERE status = 'Active';";
            BaseTableModel model = dh.executeQuery(query);
            Object[] waiters = new Object[model.rows.size()];
            for (int i = 0; i < model.rows.size(); i++) {
                waiters[i] = model.getValueAt(i, 0).toString();
            }
            cmbWaiter.setModel(new DefaultComboBoxModel(waiters));
        } catch (SQLException ex) {
            Logger.getLogger(NewOrderView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

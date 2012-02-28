/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainApplicationView.java
 *
 * Created on 02 7, 12, 11:09:31 PM
 */

package rms.views;


import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import rms.views.monitoring.TableOccupancyMonitorView;
import rms.views.monitoring.ChefQueueView;
import rms.views.inventory.InventoryView;
import rms.views.inventory.PurchaseView;
import rms.views.inventory.SpoilageView;
import rms.views.inventory.RequisitionView;
import rms.views.management.SupplierView;
import rms.views.management.IngredientView;
import rms.views.management.MenuItemsView;
import rms.views.management.EmployeeView;
import rms.views.management.MenuCategoryView;
import rms.views.management.RoleView;
import rms.views.management.SupplierPriceListView;
import rms.views.management.TableView;
import rms.views.reporting.DTRReportView;
import rms.views.reporting.InventoryReportView;
import rms.views.reporting.SalesReportView;
import rms.views.reporting.SpoilageReportView;

/**
 * 
 * @author squeekyclean
 */
public class MainApplicationView extends javax.swing.JFrame {
        private List<JInternalFrame> listOfOpenedFrames;

        private InternalFrameListener internalFrameListener;

        // management
        private EmployeeView employee;
        private IngredientView ingredient;
        private MenuCategoryView menuCategory;
        private MenuItemsView menuItem;
        private SupplierView supplier;
        private SupplierPriceListView supplierPriceList;
        private RoleView role;
        private TableView table;

        // inventory
        private InventoryView inventory;
        private PurchaseView purchase;
        private RequisitionView requisition;
        private SpoilageView spoilage;

        // table occupancy
        private ChefQueueView chef;
        private TableOccupancyMonitorView tom;

        // reports
        private DTRReportView reportDtr;
        private InventoryReportView reportInventory;
        private SalesReportView reportSales;
        private SpoilageReportView reportSpoilage;



	/** Creates new form MainApplicationView */
	public MainApplicationView() {
		initComponents();
                listOfOpenedFrames = new ArrayList<JInternalFrame>();
                internalFrameListener = new InternalFrameAdapter() {

                    @Override
                    public void internalFrameClosing(InternalFrameEvent e) {
                        JInternalFrame frame = e.getInternalFrame();
                        listOfOpenedFrames.remove(frame);
                        //frame.dispose();
                    }

                };
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JDesktopPane();
        tabPanel = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlManagement = new javax.swing.JPanel();
        btnIngredient = new javax.swing.JButton();
        btnMenuCategory = new javax.swing.JButton();
        btnMenuItem = new javax.swing.JButton();
        btnPriceList = new javax.swing.JButton();
        btnTable = new javax.swing.JButton();
        btnSupplier = new javax.swing.JButton();
        btnEmployee = new javax.swing.JButton();
        btnRoles = new javax.swing.JButton();
        pnlOrdering = new javax.swing.JPanel();
        btnOrderSlip = new javax.swing.JButton();
        pnlInventory = new javax.swing.JPanel();
        btnInventory = new javax.swing.JButton();
        btnRequisition = new javax.swing.JButton();
        btnPurchase = new javax.swing.JButton();
        btnSpoilage = new javax.swing.JButton();
        pnlTableOccupancy = new javax.swing.JPanel();
        btnTableOccupancy = new javax.swing.JButton();
        pnlChefQueue = new javax.swing.JPanel();
        btnChefQueue = new javax.swing.JButton();
        pnlReports = new javax.swing.JPanel();
        btnGeneralReport = new javax.swing.JButton();
        btnSalesReport = new javax.swing.JButton();
        btnInventoryReport = new javax.swing.JButton();
        btnDTRReport = new javax.swing.JButton();
        btnSpoilageReport = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RMS");
        setAlwaysOnTop(true);
        setName("frmMainApplication"); // NOI18N
        setResizable(false);

        mainPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTabbedPane1.setFont(new java.awt.Font("DejaVu Sans", 0, 15));

        btnIngredient.setText("Ingredient");
        btnIngredient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnIngredientMousePressed(evt);
            }
        });

        btnMenuCategory.setText("Menu Category");
        btnMenuCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuCategoryActionPerformed(evt);
            }
        });

        btnMenuItem.setText("Menu Item");
        btnMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenuItemMouseClicked(evt);
            }
        });

        btnPriceList.setText("Price List");
        btnPriceList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPriceListMouseClicked(evt);
            }
        });

        btnTable.setText("Table");
        btnTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTableActionPerformed(evt);
            }
        });

        btnSupplier.setText("Supplier");
        btnSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSupplierMouseClicked(evt);
            }
        });

        btnEmployee.setText("Employee");
        btnEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEmployeeMouseClicked(evt);
            }
        });
        btnEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeActionPerformed(evt);
            }
        });

        btnRoles.setText("Roles");
        btnRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRolesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlManagementLayout = new javax.swing.GroupLayout(pnlManagement);
        pnlManagement.setLayout(pnlManagementLayout);
        pnlManagementLayout.setHorizontalGroup(
            pnlManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnIngredient, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
            .addComponent(btnMenuItem, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
            .addComponent(btnTable, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
            .addComponent(btnMenuCategory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
            .addComponent(btnSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
            .addComponent(btnPriceList, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
            .addComponent(btnEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
            .addComponent(btnRoles, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
        );
        pnlManagementLayout.setVerticalGroup(
            pnlManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManagementLayout.createSequentialGroup()
                .addComponent(btnIngredient, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMenuCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMenuItem, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTable, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPriceList, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(132, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Management", pnlManagement);

        btnOrderSlip.setText("Order Slip");

        javax.swing.GroupLayout pnlOrderingLayout = new javax.swing.GroupLayout(pnlOrdering);
        pnlOrdering.setLayout(pnlOrderingLayout);
        pnlOrderingLayout.setHorizontalGroup(
            pnlOrderingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnOrderSlip, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
        );
        pnlOrderingLayout.setVerticalGroup(
            pnlOrderingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrderingLayout.createSequentialGroup()
                .addComponent(btnOrderSlip, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(539, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ordering", pnlOrdering);

        btnInventory.setText("Inventory");
        btnInventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInventoryMouseClicked(evt);
            }
        });

        btnRequisition.setText("Requisition");
        btnRequisition.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRequisitionMouseClicked(evt);
            }
        });

        btnPurchase.setText("Purchase");
        btnPurchase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPurchaseMouseClicked(evt);
            }
        });

        btnSpoilage.setText("Spoilage");
        btnSpoilage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSpoilageMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlInventoryLayout = new javax.swing.GroupLayout(pnlInventory);
        pnlInventory.setLayout(pnlInventoryLayout);
        pnlInventoryLayout.setHorizontalGroup(
            pnlInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnInventory, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
            .addComponent(btnRequisition, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
            .addComponent(btnPurchase, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
            .addComponent(btnSpoilage, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
        );
        pnlInventoryLayout.setVerticalGroup(
            pnlInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInventoryLayout.createSequentialGroup()
                .addComponent(btnInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRequisition, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPurchase, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSpoilage, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(322, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Inventory", pnlInventory);

        btnTableOccupancy.setText("Table Occupancy");
        btnTableOccupancy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTableOccupancyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTableOccupancyLayout = new javax.swing.GroupLayout(pnlTableOccupancy);
        pnlTableOccupancy.setLayout(pnlTableOccupancyLayout);
        pnlTableOccupancyLayout.setHorizontalGroup(
            pnlTableOccupancyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnTableOccupancy, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
        );
        pnlTableOccupancyLayout.setVerticalGroup(
            pnlTableOccupancyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableOccupancyLayout.createSequentialGroup()
                .addComponent(btnTableOccupancy, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(538, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Monitor", pnlTableOccupancy);

        btnChefQueue.setText("View Queue");
        btnChefQueue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChefQueueMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlChefQueueLayout = new javax.swing.GroupLayout(pnlChefQueue);
        pnlChefQueue.setLayout(pnlChefQueueLayout);
        pnlChefQueueLayout.setHorizontalGroup(
            pnlChefQueueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnChefQueue, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
        );
        pnlChefQueueLayout.setVerticalGroup(
            pnlChefQueueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChefQueueLayout.createSequentialGroup()
                .addComponent(btnChefQueue, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(538, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Chef's Queue", pnlChefQueue);

        btnGeneralReport.setText("General Report Viewer");

        btnSalesReport.setText("Sales Report");
        btnSalesReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalesReportMouseClicked(evt);
            }
        });

        btnInventoryReport.setText("Inventory Report");
        btnInventoryReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInventoryReportMouseClicked(evt);
            }
        });

        btnDTRReport.setText("DTR Report");
        btnDTRReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDTRReportMouseClicked(evt);
            }
        });

        btnSpoilageReport.setText("Spoilage Report");
        btnSpoilageReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSpoilageReportMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlReportsLayout = new javax.swing.GroupLayout(pnlReports);
        pnlReports.setLayout(pnlReportsLayout);
        pnlReportsLayout.setHorizontalGroup(
            pnlReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnInventoryReport, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
            .addComponent(btnSalesReport, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
            .addComponent(btnGeneralReport, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
            .addComponent(btnDTRReport, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
            .addComponent(btnSpoilageReport, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
        );
        pnlReportsLayout.setVerticalGroup(
            pnlReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReportsLayout.createSequentialGroup()
                .addComponent(btnGeneralReport, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalesReport, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInventoryReport, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDTRReport, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSpoilageReport, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(242, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Reports", pnlReports);

        javax.swing.GroupLayout tabPanelLayout = new javax.swing.GroupLayout(tabPanel);
        tabPanel.setLayout(tabPanelLayout);
        tabPanelLayout.setHorizontalGroup(
            tabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
        );
        tabPanelLayout.setVerticalGroup(
            tabPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
        );

        jMenu1.setText("File");

        jMenuItem1.setText("Change Building");
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        jMenuItem2.setText("Exit");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");

        jMenuItem3.setText("About");
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tabPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        private void btnIngredientMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngredientMousePressed
            // TODO add your handling code here:
            ingredient = IngredientView.getInstance();
            addToMainMDI(ingredient);
        }//GEN-LAST:event_btnIngredientMousePressed

        private void btnMenuItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuItemMouseClicked
            // TODO add your handling code here:
            menuItem = MenuItemsView.getInstance();
            addToMainMDI(menuItem);
        }//GEN-LAST:event_btnMenuItemMouseClicked

        private void btnSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSupplierMouseClicked
            // TODO add your handling code here:
            supplier = SupplierView.getInstance();
            addToMainMDI(supplier);
        }//GEN-LAST:event_btnSupplierMouseClicked

        private void btnPriceListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPriceListMouseClicked
            // TODO add your handling code here:
            supplierPriceList = SupplierPriceListView.getInstance();
            addToMainMDI(supplierPriceList);
        }//GEN-LAST:event_btnPriceListMouseClicked

        private void btnEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmployeeMouseClicked
            // TODO add your handling code here:
            
        }//GEN-LAST:event_btnEmployeeMouseClicked

        private void btnEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeActionPerformed
            // TODO add your handling code here:
            employee = EmployeeView.getInstance();
            addToMainMDI(employee);
        }//GEN-LAST:event_btnEmployeeActionPerformed

        private void btnSalesReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalesReportMouseClicked
            // TODO add your handling code here:
            reportSales = SalesReportView.getInstance();
            addToMainMDI(reportSales);
        }//GEN-LAST:event_btnSalesReportMouseClicked

        private void btnDTRReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDTRReportMouseClicked
            // TODO add your handling code here:
            reportDtr = DTRReportView.getInstance();
            addToMainMDI(reportDtr);
        }//GEN-LAST:event_btnDTRReportMouseClicked

        private void btnSpoilageReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSpoilageReportMouseClicked
            // TODO add your handling code here:
            reportSpoilage = SpoilageReportView.getInstance();
            addToMainMDI(reportSpoilage);
        }//GEN-LAST:event_btnSpoilageReportMouseClicked

        private void btnMenuCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuCategoryActionPerformed
            // TODO add your handling code here:
            menuCategory = MenuCategoryView.getInstance();
            addToMainMDI(menuCategory);
        }//GEN-LAST:event_btnMenuCategoryActionPerformed

        private void btnTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTableActionPerformed
            // TODO add your handling code here:
            table = TableView.getInstance();
            addToMainMDI(table);
        }//GEN-LAST:event_btnTableActionPerformed

        private void btnRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRolesActionPerformed
            // TODO add your handling code here:
            role = RoleView.getInstance();
            addToMainMDI(role);
        }//GEN-LAST:event_btnRolesActionPerformed

	private void btnInventoryMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnInventoryMouseClicked
            // TODO add your handling code here:
            inventory = InventoryView.getInstance();
            addToMainMDI(inventory);
	}// GEN-LAST:event_btnInventoryMouseClicked

	private void btnRequisitionMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnRequisitionMouseClicked
            // TODO add your handling code here:
            requisition = RequisitionView.getInstance();
            addToMainMDI(requisition);
	}// GEN-LAST:event_btnRequisitionMouseClicked

	private void btnPurchaseMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnPurchaseMouseClicked
            // TODO add your handling code here:
            purchase = PurchaseView.getInstance();
            addToMainMDI(purchase);
	}// GEN-LAST:event_btnPurchaseMouseClicked

	private void btnSpoilageMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnSpoilageMouseClicked
            // TODO add your handling code here:
            spoilage = SpoilageView.getInstance();
            addToMainMDI(spoilage);
	}// GEN-LAST:event_btnSpoilageMouseClicked

	private void btnChefQueueMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jButton16MouseClicked
            chef = ChefQueueView.getInstance();
            addToMainMDI(chef);
	}// GEN-LAST:event_jButton16MouseClicked

	private void btnInventoryReportMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jButton19MouseClicked
            reportInventory = InventoryReportView.getInstance();
            addToMainMDI(reportInventory);
	}// GEN-LAST:event_jButton19MouseClicked

	private void btnTableOccupancyActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTableOccupancyActionPerformed
            // TODO add your handling code here:
            tom = TableOccupancyMonitorView.getInstance();
            addToMainMDI(tom);
	}// GEN-LAST:event_btnTableOccupancyActionPerformed

        private void addToMainMDI(JInternalFrame view){
            if(!listOfOpenedFrames.contains(view)){
                view.addInternalFrameListener(internalFrameListener);
                listOfOpenedFrames.add(view);
                MainApplicationView.this.mainPanel.add(view);
                view.setVisible(true);
            }
            view.toFront();
            try {
                view.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(MainApplicationView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChefQueue;
    private javax.swing.JButton btnDTRReport;
    private javax.swing.JButton btnEmployee;
    private javax.swing.JButton btnGeneralReport;
    private javax.swing.JButton btnIngredient;
    private javax.swing.JButton btnInventory;
    private javax.swing.JButton btnInventoryReport;
    private javax.swing.JButton btnMenuCategory;
    private javax.swing.JButton btnMenuItem;
    private javax.swing.JButton btnOrderSlip;
    private javax.swing.JButton btnPriceList;
    private javax.swing.JButton btnPurchase;
    private javax.swing.JButton btnRequisition;
    private javax.swing.JButton btnRoles;
    private javax.swing.JButton btnSalesReport;
    private javax.swing.JButton btnSpoilage;
    private javax.swing.JButton btnSpoilageReport;
    private javax.swing.JButton btnSupplier;
    private javax.swing.JButton btnTable;
    private javax.swing.JButton btnTableOccupancy;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JDesktopPane mainPanel;
    private javax.swing.JPanel pnlChefQueue;
    private javax.swing.JPanel pnlInventory;
    private javax.swing.JPanel pnlManagement;
    private javax.swing.JPanel pnlOrdering;
    private javax.swing.JPanel pnlReports;
    private javax.swing.JPanel pnlTableOccupancy;
    private javax.swing.JPanel tabPanel;
    // End of variables declaration//GEN-END:variables



}

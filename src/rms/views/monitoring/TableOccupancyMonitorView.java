package rms.views.monitoring;

/**
 * @author Yu
 *
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import rms.ProjectConstants;

import rms.controllers.monitoring.TableOccupancyMonitorController;
import rms.controllers.ordering.OrderSlipController;
import rms.models.BaseTableModel;
import supports.NotificationSupport;

//implements TableModelListener
public class TableOccupancyMonitorView extends JInternalFrame implements
		ActionListener {
        int tableNumber;
	int row, column;
	JPanel panelOrderSlipView = new JPanel();
	JPanel panelTables = new JPanel();
	JPanel[][] panelTable;
	JScrollPane scrollPaneTables, scrollPaneOrderSlip;
	JButton[][] buttonOrderSlip;
	JButton buttonClean, buttonServe;
	BaseTableModel model = new BaseTableModel();
	JTable tableOrderSlip;
	DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
	
	TableOccupancyMonitorController controller = new TableOccupancyMonitorController(
			this);

	private static TableOccupancyMonitorView INSTANCE;
        ActionEvent event;
	private TableOccupancyMonitorView() {
		super("Table Occupancy Monitor", true,// resizable
				true, // closable
				true, // maximizable
				true); // iconifiable

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, (int) (screenSize.width * .85),
				(int) (screenSize.height * .9));

		model = controller.refresh();

		initComponents();

	}

	private void initComponents() {
            
            buttonServe = new JButton("Serve");
		
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);

		int tableCount = Integer.parseInt(controller.countTables()
				.getValueAt(0, 0).toString());

		row = tableCount / 4;

		if (tableCount % 4 > 0) {
			row++;
		}

		column = 4;

		panelOrderSlipView.setBorder(BorderFactory.createMatteBorder(1, 3, 1,
				1, Color.gray));
//		panelOrderSlipView.setPreferredSize(new Dimension(600, 0));

		buttonOrderSlip = new JButton[row][column];

		panelTable = new JPanel[row][column];

		panelTables.setLayout(new GridLayout(row, column, 10, 10));

		for (int i = 0; i < row; i++) {
			System.out.println("row: " + i);
			for (int j = 0; j < column; j++) {
				if (((i * column) + (j + 1)) <= tableCount) {
					System.out.println("column: " + j);
					// button name is table number.
					buttonOrderSlip[i][j] = new JButton(controller.refresh()
							.getValueAt(((i * column) + j), 1).toString());
					// set table color.
					buttonOrderSlip[i][j].setBackground(determineTableColor(i,
							j));

					buttonOrderSlip[i][j]
							.addActionListener(new ActionListener() {

								private BaseTableModel orderItems;

								@Override
								public void actionPerformed(ActionEvent evt) {
									// System.out.println("I Came I Saw I Conquered");
									// Object[][] data =
									// {{"foo","baz"},{"bar","qux"}};
									// String[] columnNames =
									// {"foobar","bazbar"};
									// JTable table = new
									// JTable(data,columnNames);
                                                                        event = evt;
									refreshOrderSlip(evt);
								}
							});
					buttonOrderSlip[i][j].setActionCommand(controller.refresh()
							.getValueAt(((i * column) + j), 1).toString());

					buttonClean = new JButton("Clean Table");
					buttonClean.addActionListener((ActionListener) this);
					buttonClean.setActionCommand(controller.refresh()
							.getValueAt(((i * column) + j), 1).toString());
					// buttonClean.setActionCommand("d" + i + "" + j);

					panelTable[i][j] = new JPanel();
					panelTable[i][j].setLayout(new BorderLayout(0, 0));
					panelTable[i][j].setPreferredSize(new Dimension(150, 150));
					panelTable[i][j].add(buttonOrderSlip[i][j],
							BorderLayout.CENTER);
					panelTable[i][j].add(buttonClean, BorderLayout.SOUTH);

					panelTables.add(panelTable[i][j]);
				} else {
					JLabel labelBlank = new JLabel();
					panelTables.add(labelBlank);
				}

			}
		}

		// for (int i = 0; i < row; i++) {
		// System.out.println("i:" + i);
		// for (int j = 0; j < column; j++) {
		// System.out.println("j:" + j);
		// buttonOrderSlip[i][j] = new JButton("Order Slip #"
		// + ((i * 3) + (j + 1)));
		//
		// buttonClean = new JButton("Clean Table");
		// buttonClean.addActionListener((ActionListener) this);
		// buttonClean.setActionCommand("d" + i + "" + j);
		//
		// panelTable[i][j] = new JPanel();
		// panelTable[i][j].setLayout(new BorderLayout(0, 0));
		// panelTable[i][j].setPreferredSize(new Dimension(150, 150));
		// panelTable[i][j]
		// .add(buttonOrderSlip[i][j], BorderLayout.CENTER);
		// panelTable[i][j].add(buttonClean, BorderLayout.SOUTH);
		//
		// panelTables.add(panelTable[i][j]);
		//
		// }
		// }

		tableOrderSlip = new JTable();
		tableOrderSlip.setFillsViewportHeight(true);

		scrollPaneOrderSlip = new JScrollPane(tableOrderSlip);
		scrollPaneTables = new JScrollPane(panelTables);

                panelOrderSlipView.setLayout(new BorderLayout());
                panelOrderSlipView.add(buttonServe, BorderLayout.SOUTH);
		panelOrderSlipView.add(scrollPaneOrderSlip, BorderLayout.CENTER);
                
                buttonServe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.setStatusTo(
						Integer.parseInt(tableOrderSlip.getModel()
								.getValueAt(tableOrderSlip.getSelectedRow(), 0)
								.toString()), ProjectConstants.ORDER_ITEM_STATUS_SERVED);
                                
                                refreshOrderSlip(event);
                                controller.sendBroadcast(NotificationSupport.BROADCAST.NOTIFY_ORDER_SLIP);
				
			}
		});
                
		setLayout(new BorderLayout());

		add(scrollPaneTables, BorderLayout.CENTER);
		add(panelOrderSlipView, BorderLayout.EAST);

		setVisible(true);

	}

	public void refreshOrderSlip(ActionEvent evt) {
		tableNumber = Integer.parseInt(evt.getActionCommand().toString());
		System.out.println(controller.findTableOrderSlip(tableNumber).getValueAt(0, 0).toString());
		OrderSlipController controllerOrderSlip = new OrderSlipController();
		tableOrderSlip.setModel(controllerOrderSlip.loadOrderItemsMinimal(Integer.parseInt(controller.findTableOrderSlip(tableNumber).getValueAt(0, 0).toString())));
		TableColumn column = null;
		column = tableOrderSlip.getColumnModel().getColumn(0);
                tableOrderSlip.removeColumn(column);
		column.setCellRenderer(dtcr);
		column = tableOrderSlip.getColumnModel().getColumn(1);
		column.setCellRenderer(dtcr);
		column = tableOrderSlip.getColumnModel().getColumn(2);
		column.setCellRenderer(dtcr);
		column = tableOrderSlip.getColumnModel().getColumn(3);
		column.setCellRenderer(dtcr);
		column = tableOrderSlip.getColumnModel().getColumn(4);
		column.setCellRenderer(dtcr);
	}

	// public void actionPerformed(ActionEvent ae) {
	// String ac = ae.getActionCommand();
	//
	// System.out.print(Character.getNumericValue(ac.charAt(1)) + " "
	// + Character.getNumericValue(ac.charAt(2)));
	// buttonOrderSlip[Character.getNumericValue(ac.charAt(1))][Character
	// .getNumericValue(ac.charAt(2))].setBackground(Color.GREEN);
	//
	// }

	public void actionPerformed(ActionEvent ae) {
		int tableNumber = Integer.parseInt(ae.getActionCommand().toString());
		System.out.println(controller.findTableStatus(tableNumber).getValueAt(0, 0).toString());
		if (controller.findTableStatus(tableNumber).getValueAt(0, 0).toString().equals("Dirty")) {
			controller.cleanTable(tableNumber);
			for (int i = 0; i < row; i++)
				for (int j = 0; j < column; j++)
					buttonOrderSlip[i][j].setBackground(determineTableColor(i,
							j));
		}
		// String ac = ae.getActionCommand();
		// System.out.print(Character.getNumericValue(ac.charAt(1)) + " "
		// + Character.getNumericValue(ac.charAt(2)));
		// buttonOrderSlip[Character.getNumericValue(ac.charAt(1))][Character
		// .getNumericValue(ac.charAt(2))].setBackground(Color.GREEN);

	}
        
        public void refreshTOM(){
            for (int i = 0; i < row; i++)
				for (int j = 0; j < column; j++)
					buttonOrderSlip[i][j].setBackground(determineTableColor(i,
							j));
        }

	public Color determineTableColor(int row, int column) {

		Color color = null;

		// display table number in console.
		System.out.println("table number is: "
				+ ((row * this.column) + (column + 1)));
		// display table status in console.
		System.out.println("table status is: "
				+ controller.refresh()
						.getValueAt(((row * this.column) + column), 2)
						.toString());

		switch (controller.refresh()
				.getValueAt(((row * this.column) + column), 2).toString()
				.charAt(0)) {
		case 'O':
			color = Color.RED;
			break;
		case 'A':
			color = Color.GREEN;
			break;
		case 'D':
			color = Color.ORANGE;
			break;
		case 'R':
			color = Color.BLUE;
			break;
		case 'I':
			color = Color.GRAY;
			break;
		}
		return color;

	}

	public void updateChefView() {
		// update table colors.
		for (int i = 0; i < row; i++)
			for (int j = 0; j < column; j++)
				buttonOrderSlip[i][j].setBackground(determineTableColor(i, j));
	}

	public static TableOccupancyMonitorView getInstance() {
		if (INSTANCE == null)
			INSTANCE = new TableOccupancyMonitorView();
		return INSTANCE;
	}
}
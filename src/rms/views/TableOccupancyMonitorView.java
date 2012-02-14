package rms.views;

/**
 * @author Yu
 *
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

//implements TableModelListener
public class TableOccupancyMonitorView extends JInternalFrame {

	public TableOccupancyMonitorView() {
		super("Table Occupancy Monitor", true,// resizable
				true, // closable
				true, // maximizable
				true); // iconifiable

		setSize(500, 500);

		int row, column;
		row = column = 3;

		JPanel panelOrderSlipView = new JPanel();
		panelOrderSlipView.setBorder(BorderFactory.createMatteBorder(1, 3, 1,
				1, Color.gray));
		panelOrderSlipView.setPreferredSize(new Dimension(300, 0));

		JButton[][] buttonOrderSlip, buttonTableStatus;
		buttonOrderSlip = new JButton[row][column];
		buttonTableStatus = new JButton[row][column];

		JPanel[][] panelTable;
		panelTable = new JPanel[row][column];

		JPanel panelTables = new JPanel();
		panelTables.setLayout(new GridLayout(row, column, 10, 10));

		for (int i = 0; i < row; i++) {
			System.out.println("i:" + i);
			for (int j = 0; j < column; j++) {
				System.out.println("j:" + j);
				buttonOrderSlip[i][j] = new JButton("Order Slip #"
						+ ((i * 3) + (j + 1)));
				buttonTableStatus[i][j] = new JButton("Table #"
						+ ((i * 3) + (j + 1)) + " Status");
				panelTable[i][j] = new JPanel();
				panelTable[i][j].setLayout(new BorderLayout(0, 0));
				panelTable[i][j].setPreferredSize(new Dimension(150, 150));
				panelTable[i][j]
						.add(buttonOrderSlip[i][j], BorderLayout.CENTER);
				panelTable[i][j].add(buttonTableStatus[i][j],
						BorderLayout.SOUTH);

				panelTables.add(panelTable[i][j]);

			}
		}

		JScrollPane scrollPaneTables = new JScrollPane(panelTables);

//		setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		add(scrollPaneTables, BorderLayout.CENTER);
		add(panelOrderSlipView, BorderLayout.EAST);

		pack();
		setVisible(true);
	}
}
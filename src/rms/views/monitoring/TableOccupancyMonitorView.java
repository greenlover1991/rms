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
import javax.swing.JColorChooser;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

//implements TableModelListener
public class TableOccupancyMonitorView extends JInternalFrame implements
		ActionListener {
	int row, column;
	JPanel panelOrderSlipView = new JPanel();
	JPanel panelTables = new JPanel();
	JPanel[][] panelTable;
	JScrollPane scrollPaneTables;
	JButton[][] buttonOrderSlip;
	JButton buttonClean;

	private static TableOccupancyMonitorView INSTANCE;

	private TableOccupancyMonitorView() {
		super("Table Occupancy Monitor", true,// resizable
				true, // closable
				true, // maximizable
				true); // iconifiable

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, (int) (screenSize.width * .85),
				(int) (screenSize.height * .9));

		initComponents();

		setLayout(new BorderLayout());

		add(scrollPaneTables, BorderLayout.CENTER);
		add(panelOrderSlipView, BorderLayout.EAST);

		setResizable(false);
		setVisible(true);
	}

	private void initComponents() {

		row = column = 3;

		panelOrderSlipView.setBorder(BorderFactory.createMatteBorder(1, 3, 1,
				1, Color.gray));
		panelOrderSlipView.setPreferredSize(new Dimension(400, 0));

		buttonOrderSlip = new JButton[row][column];

		panelTable = new JPanel[row][column];

		panelTables.setLayout(new GridLayout(row, column, 10, 10));

		for (int i = 0; i < row; i++) {
			System.out.println("i:" + i);
			for (int j = 0; j < column; j++) {
				System.out.println("j:" + j);
				buttonOrderSlip[i][j] = new JButton("Order Slip #"
						+ ((i * 3) + (j + 1)));

				buttonClean = new JButton("Clean Table");
				// buttonClean.setBackground(Color.ORANGE);
				buttonClean.addActionListener((ActionListener) this);
				buttonClean.setActionCommand("d" + i + "" + j);

				panelTable[i][j] = new JPanel();
				panelTable[i][j].setLayout(new BorderLayout(0, 0));
				panelTable[i][j].setPreferredSize(new Dimension(150, 150));
				panelTable[i][j]
						.add(buttonOrderSlip[i][j], BorderLayout.CENTER);
				panelTable[i][j].add(buttonClean, BorderLayout.SOUTH);

				panelTables.add(panelTable[i][j]);

			}
		}

		scrollPaneTables = new JScrollPane(panelTables);

	}

	public void actionPerformed(ActionEvent ae) {
		String ac = ae.getActionCommand();
		// Color color = null;
		// switch (ac.charAt(0)) {
		// case 'o':
		// color = Color.RED;
		// break;
		// case 'v':
		// color = Color.GREEN;
		// break;
		// case 'd':
		// color = Color.ORANGE;
		// break;
		// case 'r':
		// color = Color.BLUE;
		// break;
		// case 'i':
		// color = Color.GRAY;
		// break;
		// }

		System.out.print(Character.getNumericValue(ac.charAt(1)) + " "
				+ Character.getNumericValue(ac.charAt(2)));
		buttonOrderSlip[Character.getNumericValue(ac.charAt(1))][Character
				.getNumericValue(ac.charAt(2))].setBackground(Color.GREEN);

	}

	public static TableOccupancyMonitorView getInstance() {
		if (INSTANCE == null)
			INSTANCE = new TableOccupancyMonitorView();
		return INSTANCE;
	}
}
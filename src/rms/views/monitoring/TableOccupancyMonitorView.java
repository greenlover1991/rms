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
	JPanel[][] panelTable, panelButtons;
	JScrollPane scrollPaneTables;
	JButton[][] buttonOrderSlip, buttonOccupied, buttonVacant, buttonDirty,
			buttonReserved, buttonInactive;
	JColorChooser chooserTableStatus = new JColorChooser();

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
		buttonOccupied = new JButton[row][column];
		buttonVacant = new JButton[row][column];
		buttonDirty = new JButton[row][column];
		buttonReserved = new JButton[row][column];
		buttonInactive = new JButton[row][column];

		panelTable = new JPanel[row][column];
		panelButtons = new JPanel[row][column];

		panelTables.setLayout(new GridLayout(row, column, 10, 10));

		Dimension buttonDimension = new Dimension(50, 25);

		for (int i = 0; i < row; i++) {
			System.out.println("i:" + i);
			for (int j = 0; j < column; j++) {
				System.out.println("j:" + j);
				buttonOrderSlip[i][j] = new JButton("Order Slip #"
						+ ((i * 3) + (j + 1)));
				buttonOccupied[i][j] = new JButton();
				buttonOccupied[i][j].setBackground(Color.RED);
				buttonOccupied[i][j].setPreferredSize(buttonDimension);
				buttonOccupied[i][j].addActionListener((ActionListener) this);
				buttonOccupied[i][j].setActionCommand("o" + i + "" + j);

				buttonVacant[i][j] = new JButton();
				buttonVacant[i][j].setBackground(Color.GREEN);
				buttonVacant[i][j].setPreferredSize(buttonDimension);
				buttonVacant[i][j].addActionListener((ActionListener) this);
				buttonVacant[i][j].setActionCommand("v" + i + "" + j);

				buttonDirty[i][j] = new JButton();
				buttonDirty[i][j].setBackground(Color.ORANGE);
				buttonDirty[i][j].setPreferredSize(buttonDimension);
				buttonDirty[i][j].addActionListener((ActionListener) this);
				buttonDirty[i][j].setActionCommand("d" + i + "" + j);

				buttonReserved[i][j] = new JButton();
				buttonReserved[i][j].setBackground(Color.BLUE);
				buttonReserved[i][j].setPreferredSize(buttonDimension);
				buttonReserved[i][j].addActionListener((ActionListener) this);
				buttonReserved[i][j].setActionCommand("r" + i + "" + j);

				buttonInactive[i][j] = new JButton();
				buttonInactive[i][j].setBackground(Color.GRAY);
				buttonInactive[i][j].setPreferredSize(buttonDimension);
				buttonInactive[i][j].addActionListener((ActionListener) this);
				buttonInactive[i][j].setActionCommand("i" + i + "" + j);

				panelButtons[i][j] = new JPanel();
				panelButtons[i][j].add(buttonOccupied[i][j]);
				panelButtons[i][j].add(buttonVacant[i][j]);
				panelButtons[i][j].add(buttonDirty[i][j]);
				panelButtons[i][j].add(buttonReserved[i][j]);
				panelButtons[i][j].add(buttonInactive[i][j]);

				panelTable[i][j] = new JPanel();
				panelTable[i][j].setLayout(new BorderLayout(0, 0));
				panelTable[i][j].setPreferredSize(new Dimension(150, 150));
				panelTable[i][j]
						.add(buttonOrderSlip[i][j], BorderLayout.CENTER);
				panelTable[i][j].add(panelButtons[i][j], BorderLayout.SOUTH);

				panelTables.add(panelTable[i][j]);

			}
		}

		scrollPaneTables = new JScrollPane(panelTables);

	}

	public void actionPerformed(ActionEvent ae) {
		String ac = ae.getActionCommand();
		Color color = null;
		switch (ac.charAt(0)) {
		case 'o':
			color = Color.RED;
			break;
		case 'v':
			color = Color.GREEN;
			break;
		case 'd':
			color = Color.ORANGE;
			break;
		case 'r':
			color = Color.BLUE;
			break;
		case 'i':
			color = Color.GRAY;
			break;
		}

		System.out.print(Character.getNumericValue(ac.charAt(1)) + " "
				+ Character.getNumericValue(ac.charAt(2)));
		buttonOrderSlip[Character.getNumericValue(ac.charAt(1))][Character
				.getNumericValue(ac.charAt(2))].setBackground(color);

	}

	public static TableOccupancyMonitorView getInstance() {
		if (INSTANCE == null)
			INSTANCE = new TableOccupancyMonitorView();
		return INSTANCE;
	}
}
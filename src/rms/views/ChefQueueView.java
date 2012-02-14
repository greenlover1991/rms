package rms.views;

/**
 * @author Yu
 *
 */
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class ChefQueueView extends JInternalFrame {

	public ChefQueueView() {
		super("Chef Queue");
		initComponents();
	}

	public void initComponents() {
		String[] columnNames = { "Status", "Particular", "Service" };
		Object[][] data = { { "Pending", "Lasagna", "Dine In" },
				{ "Processing", "Meat Balls", "Take Out" } };

		setClosable(true);
		setIconifiable(true);

		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);

		JTable chefQueue = new JTable(data, columnNames);
		TableColumn column = null;
		column = chefQueue.getColumnModel().getColumn(0);
		column.setPreferredWidth(100);
		column.setMinWidth(100);
		column.setMaxWidth(100);
		column.setCellRenderer(dtcr);
		column = chefQueue.getColumnModel().getColumn(1);
		column.setCellRenderer(dtcr);
		column = chefQueue.getColumnModel().getColumn(2);
		column.setCellRenderer(dtcr);
		column.setPreferredWidth(100);
		column.setMinWidth(100);
		column.setMaxWidth(100);
		// chefQueue.setPreferredScrollableViewportSize(new Dimension(350,
		// 500));

		JScrollPane scrollPaneChefQueue = new JScrollPane(chefQueue);

		JButton buttonProcess = new JButton("Process");
		buttonProcess.setPreferredSize(new Dimension(215, 30));
		JButton buttonReady = new JButton("Ready");
		buttonReady.setPreferredSize(new Dimension(215, 30));
		JButton buttonConfig = new JButton("Config");
		buttonConfig.setPreferredSize(new Dimension(70, 30));

		JPanel panelButtons = new JPanel();
		panelButtons.add(buttonProcess);
		panelButtons.add(buttonReady);
		panelButtons.add(buttonConfig);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(scrollPaneChefQueue, BorderLayout.CENTER);
		add(panelButtons, BorderLayout.SOUTH);

		pack();
		// setSize(new Dimension(500,500));
		// setVisible(false);

		// JFrame frameChefQueue = new JFrame("Chef Queue");
		// frameChefQueue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//
		// frameChefQueue.add(scrollPaneChefQueue, BorderLayout.CENTER);
		// frameChefQueue.add(panelButtons, BorderLayout.SOUTH);
		//
		// frameChefQueue.pack();
		// frameChefQueue.setVisible(true);
	}

}

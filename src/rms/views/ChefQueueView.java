package rms.views;

/**
 * @author Yu
 *
 */
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import rms.models.ChefQueueModel;

public class ChefQueueView extends JInternalFrame {
	String[] columnNames = { "Status", "Particular", "Service" };
	Object[][] data = { { "Pending", "Lasagna", "Dine In" },
			{ "Processing", "Meat Balls", "Take Out" } };
	DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
	JTable chefQueue;
	JScrollPane scrollPaneChefQueue;
	JButton buttonProcess = new JButton("Process");
	JButton buttonReady = new JButton("Ready");
	JButton buttonConfig = new JButton("Config");
	JPanel panelButtons = new JPanel();
	ChefQueueModel model = new ChefQueueModel();

	public ChefQueueView() {
		super("Chef Queue", true,// resizable
				true, // closable
				true, // maximizable
				true); // iconifiable
		setSize(500, 500);

		initComponents();

		add(scrollPaneChefQueue, BorderLayout.CENTER);
		add(panelButtons, BorderLayout.SOUTH);

		pack();
		setVisible(true);
	}

	public void initComponents() {

		dtcr.setHorizontalAlignment(SwingConstants.CENTER);

		chefQueue = new JTable(model);
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

		scrollPaneChefQueue = new JScrollPane(chefQueue);

		buttonProcess.setPreferredSize(new Dimension(215, 30));
		buttonReady.setPreferredSize(new Dimension(215, 30));
		buttonConfig.setPreferredSize(new Dimension(70, 30));

		panelButtons.add(buttonProcess);
		panelButtons.add(buttonReady);
		panelButtons.add(buttonConfig);

	}

}

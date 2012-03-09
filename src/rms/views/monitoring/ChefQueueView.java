package rms.views.monitoring;

/**
 * @author Yu
 *
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import rms.controllers.monitoring.ChefQueueController;
import rms.models.BaseTableModel;

public class ChefQueueView extends JInternalFrame {
	String[] columnNames = { "Status", "Particular", "Service" };
	Object[][] data = { { "Pending", "Lasagna", "Dine In" },
			{ "Processing", "Meat Balls", "Take Out" } };
	DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
	JTable chefQueued, chefProcessing;
	JScrollPane scrollPaneChefQueued, scrollPaneChefProcessing;
	JButton buttonProcess = new JButton("Process");
	JButton buttonReady = new JButton("Ready");
	JButton buttonConfig = new JButton("Config");
	JPanel panelQueued = new JPanel(), panelProcessing = new JPanel();
	BaseTableModel modelQueued, modelProcessing;
	ChefQueueController controller = new ChefQueueController(this);

	private static ChefQueueView INSTANCE;

	private ChefQueueView() {
		super("Chef Queue", true,// resizable
				true, // closable
				true, // maximizable
				true); // iconifiable

		setLayout(new GridLayout(1, 2, 5, 5));

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, (int) (screenSize.width * .85),
				(int) (screenSize.height * .9));

		modelQueued = controller.refreshQueue();
		modelProcessing = controller.refreshProcessing();

		initComponents();

		add(panelQueued);
		add(panelProcessing);

		setVisible(true);
	}

	private void initComponents() {

		buttonProcess.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.setStatusTo(
						Integer.parseInt(chefQueued.getValueAt(
								chefQueued.getSelectedRow(), 0).toString()),
						"Processing");
				chefProcessing.setModel(controller.refreshProcessing());
				chefQueued.setModel(controller.refreshQueue());
			}
		});

		buttonReady.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.setStatusTo(
						Integer.parseInt(chefProcessing.getValueAt(
								chefProcessing.getSelectedRow(), 0).toString()),
						"Ready");
				chefProcessing.setModel(controller.refreshProcessing());
			}
		});

		dtcr.setHorizontalAlignment(SwingConstants.CENTER);

		chefQueued = new JTable(modelQueued) {
			public Component prepareRenderer(TableCellRenderer renderer,
					int Index_row, int Index_col) {
				Component comp = super.prepareRenderer(renderer, Index_row,
						Index_col);
				// even index, selected or not selected
				if (Index_row % 2 == 0 && !isCellSelected(Index_row, Index_col)) {
					comp.setBackground(Color.GREEN);
				} else {
					comp.setBackground(Color.WHITE);
				}
				return comp;
			}
		};
		

		chefProcessing = new JTable(modelProcessing) {
			public Component prepareRenderer(TableCellRenderer renderer,
					int Index_row, int Index_col) {
				Component comp = super.prepareRenderer(renderer, Index_row,
						Index_col);
				// even index, selected or not selected
				if (Index_row % 2 == 0 && !isCellSelected(Index_row, Index_col)) {
					comp.setBackground(Color.GREEN);
				} else {
					comp.setBackground(Color.WHITE);
				}
				return comp;
			}
		};

		// TODO resize processing table.

		chefQueued.setName("Queued");
		chefProcessing.setName("Processing");

		// // table listener
		// chefQueue.getModel().addTableModelListener(model);
		//
		TableColumn column = null;
		column = chefQueued.getColumnModel().getColumn(0);
		chefQueued.removeColumn(column);
		column = chefQueued.getColumnModel().getColumn(0);
		column.setCellRenderer(dtcr);
		column = chefQueued.getColumnModel().getColumn(1);
		column.setCellRenderer(dtcr);

		column = chefProcessing.getColumnModel().getColumn(0);
		chefProcessing.removeColumn(column);
		column = chefProcessing.getColumnModel().getColumn(0);
		column.setCellRenderer(dtcr);

		// column.setPreferredWidth(100);
		// column.setMinWidth(100);
		// column.setMaxWidth(100);
		// column = chefQueue.getColumnModel().getColumn(1);
		// column.setCellRenderer(dtcr);
		// column = chefQueue.getColumnModel().getColumn(2);
		// column.setCellRenderer(dtcr);
		// column.setPreferredWidth(100);
		// column.setMinWidth(100);
		// column.setMaxWidth(100);

		scrollPaneChefQueued = new JScrollPane(chefQueued);
		scrollPaneChefProcessing = new JScrollPane(chefProcessing);

		panelQueued.setLayout(new BorderLayout());
		panelProcessing.setLayout(new BorderLayout());

		panelQueued.add(scrollPaneChefQueued, BorderLayout.CENTER);
		panelQueued.add(buttonProcess, BorderLayout.SOUTH);

		panelProcessing.add(scrollPaneChefProcessing, BorderLayout.CENTER);
		panelProcessing.add(buttonReady, BorderLayout.SOUTH);

		// buttonProcess.setPreferredSize(new Dimension(215, 30));
		// buttonReady.setPreferredSize(new Dimension(215, 30));
		// buttonConfig.setPreferredSize(new Dimension(70, 30));
		//
		// panelButtons.add(buttonProcess);
		// panelButtons.add(buttonReady);
		// panelButtons.add(buttonConfig);

	}
	
	public void refreshChefQueue() {
		chefQueued.setModel(controller.refreshQueue());
	}

	public static ChefQueueView getInstance() {
		if (INSTANCE == null)
			INSTANCE = new ChefQueueView();
		return INSTANCE;
	}

}

package com.future.client.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TradeView extends JSplitPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4504409123680880070L;
	private JTable table;
	private JScrollPane scrollPane;
	private JSplitPane splitPane;

	/**
	 * Create the panel.
	 */
	public TradeView() {
		setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		splitPane = new JSplitPane();
		setRightComponent(splitPane);
		
		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);
		splitPane.setLeftComponent(new OrderBoard());
		panel.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane = new JScrollPane(table);
		panel.add(scrollPane, BorderLayout.CENTER);
		
		DefaultTableModel tableModel = new DefaultTableModel();
		String[] columnNames = {"Name",
                "Description",
                "Sport",
                "# of Years",
                "Vegetarian"};
        Object[][] data = {
                {"Kathy", "Smith",
                 "Snowboarding", new Integer(5), new Boolean(false)},
                {"John", "Doe",
                 "Rowing", new Integer(3), new Boolean(true)},
                {"Sue", "Black",
                 "Knitting", new Integer(2), new Boolean(false)},
                {"Jane", "White",
                 "Speed reading", new Integer(20), new Boolean(true)},
                {"Joe", "Brown",
                 "Pool", new Integer(10), new Boolean(false)}
                };
        tableModel.setDataVector(data, columnNames);
        table.setModel(tableModel);
        
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 704, 430);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
		TradeView tradeView = new TradeView();
		frame.getContentPane().add(tradeView);
		frame.setVisible(true);
		tradeView.splitPane.setDividerLocation(0.25);
	}
}

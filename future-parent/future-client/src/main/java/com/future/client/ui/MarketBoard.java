package com.future.client.ui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * 报价板
 * @author caojia
 */
public class MarketBoard extends JScrollPane {
    /**
     * 
     */
    private static final long serialVersionUID = 263696775562542716L;
    private JTable table;

    /**
     * Create the panel.
     */
    public MarketBoard() {
        
        table = new JTable();
        table.setFillsViewportHeight(true);
        setViewportView(table);

    }
    
    public static void main(String[] args) {
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MarketBoard marketBoard = new MarketBoard();
        frame.getContentPane().add(marketBoard);
        frame.setVisible(true);
    }

}

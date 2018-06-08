package com.future.client.ui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 下单版
 * @author caojia
 *
 */
public class OrderBoard extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6507841203426626305L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public OrderBoard() {
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(58, 41, 96, 26);
		add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("合约");
		label.setBounds(17, 46, 36, 16);
		add(label);
		
		JLabel label_1 = new JLabel("价格");
		label_1.setBounds(17, 81, 36, 16);
		add(label_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(58, 76, 96, 26);
		add(spinner);
		
		JLabel label_2 = new JLabel("手数");
		label_2.setBounds(17, 115, 36, 16);
		add(label_2);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(58, 110, 96, 26);
		add(spinner_1);
		
		JButton btnNewButton = new JButton("开仓");
		btnNewButton.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mousePressed(MouseEvent e) {
		        
		    }
		});
		btnNewButton.setBounds(27, 153, 117, 29);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("平仓");
		btnNewButton_1.setBounds(17, 194, 70, 29);
		add(btnNewButton_1);
		
		JButton button = new JButton("平今");
		button.setBounds(84, 194, 70, 29);
		add(button);
		
		JButton button_1 = new JButton("清仓");
		button_1.setBounds(27, 232, 117, 29);
		add(button_1);

	}
}

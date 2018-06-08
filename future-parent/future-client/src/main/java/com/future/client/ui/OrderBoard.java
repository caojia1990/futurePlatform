package com.future.client.ui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import com.future.instrument.api.vo.InstrumentVO;

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
	
	private List<InstrumentVO> instruments = new ArrayList<InstrumentVO>(){/**
         * 
         */
        private static final long serialVersionUID = -3159518231597250492L;

    {
	    {
	        InstrumentVO instrumentVO = new InstrumentVO();
	        instrumentVO.setInstrumentID("cu1808");
	        add(instrumentVO);
	    }
	}};
	
	private JComboBox<String> comboBox;

	/**
	 * Create the panel.
	 */
	public OrderBoard() {
	    
	    
		setLayout(null);
		
		JLabel label = new JLabel("合约");
		label.setBounds(17, 28, 36, 16);
		add(label);
		
		comboBox = new JComboBox<String>();
		comboBox.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyPressed(KeyEvent e) {
		        //TODO 监听无效?
		        String s = (String) comboBox.getSelectedItem();
		        List<InstrumentVO> list = instruments.stream().filter(i->i.getInstrumentID().indexOf(s)>-1).collect(Collectors.toList());
		        if(list != null){
		            for (InstrumentVO instrumentVO : list) {
		                comboBox.addItem(instrumentVO.getInstrumentID());
                    }
		        }
		    }
		});
		comboBox.setEditable(true);
		comboBox.setBounds(58, 26, 96, 21);
		add(comboBox);
		
		JLabel label_1 = new JLabel("价格");
		label_1.setBounds(17, 63, 36, 16);
		add(label_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(58, 58, 96, 26);
		add(spinner);
		
		JLabel label_2 = new JLabel("手数");
		label_2.setBounds(17, 97, 36, 16);
		add(label_2);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(58, 92, 96, 26);
		add(spinner_1);
		
		JButton btnNewButton_1 = new JButton("平仓");
		btnNewButton_1.setBounds(10, 188, 70, 29);
		add(btnNewButton_1);
		
		JButton button = new JButton("平今");
		button.setBounds(111, 188, 70, 29);
		add(button);
		
		JButton button_1 = new JButton("清仓");
		button_1.setBounds(43, 235, 96, 29);
		add(button_1);
		
		JButton btnNewButton = new JButton("做空");
		btnNewButton.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyPressed(KeyEvent e) {
		        
		    }
		});
		btnNewButton.setBounds(10, 144, 70, 23);
		add(btnNewButton);
		
		JButton button_2 = new JButton("做多");
		button_2.setBounds(111, 144, 70, 23);
		add(button_2);
		
	}
}

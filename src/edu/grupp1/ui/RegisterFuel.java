package edu.grupp1.ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.grupp1.domain.domainfacade.DomainFacade;


public class RegisterFuel extends JPanel{
	
	private String msg;
	private double rate = 0;
	private JButton goBack = new JButton(new ImageIcon(getClass().getClassLoader().getResource("arrow1.png")));
	private JLabel jlabel = new JLabel();
	
	public RegisterFuel(Misma misma, DomainFacade domain, int level){
		setPreferredSize(new Dimension(400, 400));
		setFocusable(true);
		setLayout(new BoxLayout(this, 1));
		
		jlabel.setText("Fuel registered!");
		jlabel.setAlignmentX(CENTER_ALIGNMENT);
		
		goBack.setVisible(true);
		goBack.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
		goBack.setContentAreaFilled(false);
		
		
		JLabel fuelType = new JLabel("Fuel type:");
		String[] message = {"Diesel", "Bensin", "Etanol(E85)"};
		JLabel label = new JLabel("Fuel:" );
		JTextField fuel = new JTextField();
		JButton register = new JButton("Register");
		JComboBox box  = new JComboBox(message);
		
		
		fuel.setText("In liter");
		fuel.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        fuel.setText("");
		    }
		});
		
		goBack.setAlignmentX(CENTER_ALIGNMENT);
		goBack.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				misma.loadMenu(level);
			}
		});
		
		label.setAlignmentX(CENTER_ALIGNMENT);
		fuel.setAlignmentX(CENTER_ALIGNMENT);
		fuelType.setAlignmentX(CENTER_ALIGNMENT);
		fuel.setMaximumSize(new Dimension(150, 20));
		box.setAlignmentX(CENTER_ALIGNMENT);
		box.setMaximumSize(new Dimension(150, 20));
		
		box.setSelectedIndex(1);
		box.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == box){
					JComboBox cb = (JComboBox)e.getSource();
					msg = (String)cb.getSelectedItem();
					
					switch(msg){
						case "Diesel":  rate = 0.003; 
							break;
						case "Bensin":  rate = 0.003;
							break;
						case "Etanol (E85)": rate = 0.001;
							break;
						default: rate = 0.003;
						
					}
				}
				
			}
		});
		
		
		add(Box.createRigidArea(new Dimension(200, 100)));
		add(label);
		add(fuel);
		add(fuelType);
		add(box);
		add(Box.createRigidArea(new Dimension(200, 15)));
		add(register);
		add(goBack);
		
		register.setAlignmentX(CENTER_ALIGNMENT);
		register.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	
		    	Double fuel1 = Double.parseDouble(fuel.getText());
		        domain.saveFuel(fuel1, msg, rate);
		        add(jlabel);
		        validate();
		        
		    }
		});
		
	
	}
}
package ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class RegisterFuel extends JPanel{
	
	public RegisterFuel(){
		setPreferredSize(new Dimension(400, 400));
		setFocusable(true);
		
		setLayout(new BoxLayout(this, 1));
		
		JLabel label = new JLabel("Fuel:" );
		JTextField fuel = new JTextField();
		JButton register = new JButton("Register");
		
		fuel.setText("in liter");
		fuel.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        fuel.setText("");
		    }
		});
		label.setAlignmentX(CENTER_ALIGNMENT);
		fuel.setAlignmentX(CENTER_ALIGNMENT);
		fuel.setMaximumSize(new Dimension(150, 20));
		
		register.setAlignmentX(CENTER_ALIGNMENT);
		add(Box.createRigidArea(new Dimension(200, 100)));
		add(label);
		add(fuel);
		
		add(Box.createRigidArea(new Dimension(200, 15)));
		add(register);
	
	}
}
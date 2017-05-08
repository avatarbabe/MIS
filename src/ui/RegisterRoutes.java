package ui;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterRoutes extends JPanel{
	
	public RegisterRoutes(){
		setPreferredSize(new Dimension(400, 400));
		setFocusable(true);
		
		setLayout(new BoxLayout(this, 1));
		
		JTextField from = new JTextField();
		JTextField to = new JTextField();
		JTextField distance = new JTextField();
		JButton register = new JButton("Register");
		
		from.setText("From");
		from.setAlignmentX(CENTER_ALIGNMENT);
		from.setMaximumSize(new Dimension(150, 20));
		to.setText("To");
		to.setAlignmentX(CENTER_ALIGNMENT);
		to.setMaximumSize(new Dimension(150, 20));
		distance.setText("Distance");
		distance.setAlignmentX(CENTER_ALIGNMENT);
		distance.setMaximumSize(new Dimension(150, 20));

		add(Box.createRigidArea(new Dimension(200, 100)));
		add(from);
		add(to);
		add(distance);
		add(Box.createRigidArea(new Dimension(200, 15)));
		add(register);
	}
}
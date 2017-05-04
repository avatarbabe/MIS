package ui;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JPanel{
	
	public Login(){
		setPreferredSize(new Dimension(400, 400));
		setFocusable(true);
		
		setLayout(new BoxLayout(this, 1));
		
		JTextField username = new JTextField();
		JPasswordField password = new JPasswordField();
		JButton login = new JButton();
		
		username.setText("Username");
		username.setAlignmentX(CENTER_ALIGNMENT);
		username.setMaximumSize(new Dimension(150, 20));
		password.setText("Password");
		password.setAlignmentX(CENTER_ALIGNMENT);
		password.setMaximumSize(new Dimension(150, 20));
		login.setText("Login");
		login.setAlignmentX(CENTER_ALIGNMENT);
		
		add(Box.createRigidArea(new Dimension(200, 100)));
		add(username);
		add(password);
		add(Box.createRigidArea(new Dimension(200, 15)));
		add(login);
	}
}

package ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import broker.DatabaseBroker;
import broker.UserDataBroker;
import domain.User;

public class Login extends JPanel{
	
	public Login(){
		
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
		
		login.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				UserDataBroker broker = new UserDataBroker();
				ArrayList<User> users = broker.getAllUsers();
				
				for (User user : users) {
				    System.out.println(user.getUsername());
				}
			}
		});
		
		add(Box.createRigidArea(new Dimension(200, 100)));
		add(username);
		add(password);
		add(Box.createRigidArea(new Dimension(200, 15)));
		add(login);
	}
}

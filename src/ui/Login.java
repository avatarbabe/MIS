package ui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import broker.UserDataBroker;
import data.UserData;
import datafacade.DataFacade;
import domain.User;
import domainfacade.DomainFacade;

public class Login extends JPanel{
	
	private DataFacade data;
	private DomainFacade domain;
	private int level;
	
	
	public Login(final Misma misma, DataFacade data, DomainFacade domain){
		
		this.data = data;
		
		setFocusable(true);
		
		setLayout(new BoxLayout(this, 1));
		
		JLabel jlabel = new JLabel();
		JLabel loglabel = new JLabel("Log in:");
		JTextField username = new JTextField();
		JPasswordField password = new JPasswordField();
		JButton login = new JButton();
		
		username.setText("Username");
		username.setAlignmentX(CENTER_ALIGNMENT);
		username.setMaximumSize(new Dimension(150, 20));
		jlabel.setText("Not valid login");
		jlabel.setAlignmentX(CENTER_ALIGNMENT);
		username.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        username.setText("");
		    }
		});
		password.setText("Password");
		password.setAlignmentX(CENTER_ALIGNMENT);
		password.setMaximumSize(new Dimension(150, 20));
		password.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        password.setText("");
		    }
		});
		login.setText("Login");
		login.setAlignmentX(CENTER_ALIGNMENT);
		
		login.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String getUsername = username.getText();
				String getPassword = password.getText();
				
				if((domain.login(getUsername, getPassword)) != null){
					misma.loadMenu(domain.getActiveUserLevel());
					
				} else {
					add(jlabel);
					validate();
				}
			}
		});

		add(Box.createRigidArea(new Dimension(200, 100)));
		add(loglabel);
		loglabel.setAlignmentX(CENTER_ALIGNMENT);
		add(username);
		add(password);
		add(Box.createRigidArea(new Dimension(200, 15)));
		add(login);
		revalidate();
		setVisible(true);
	}
	
//	public void setLevel(String username, Misma misma){
//		if (username.equals("truckdriver")){
//			level = 0;
//		} else if (username.equals("ceo")){
//			level = 1;
//		} else if (username.equals("official")){
//			level = 2;
//		}
//		
//		misma.loadMenu(domain.findLevel());
//	}
}

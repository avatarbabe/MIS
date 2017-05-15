package ui;

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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import domain.DomainFacade;

public class NewUser extends JPanel{
	private int level1 = 0;
	private JLabel jlabel = new JLabel();
	private JButton goBack = new JButton(new ImageIcon(getClass().getClassLoader().getResource("arrow1.png")));
	
	public NewUser(Misma misma, DomainFacade domain, int level){
		
		setFocusable(true);
		
		setLayout(new BoxLayout(this, 1));
		
		
		String[] message = {"Truckdriver", "CEO", "Official"};
		JLabel loglabel = new JLabel("Register user:");
		JTextField username = new JTextField();
		JPasswordField password = new JPasswordField();
		JComboBox box = new JComboBox(message);
		JButton register = new JButton();
		
		jlabel.setText("New user registered!");
		jlabel.setAlignmentX(CENTER_ALIGNMENT);
		
		goBack.setVisible(true);
		goBack.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
		goBack.setContentAreaFilled(false);
		
		username.setText("Username");
		username.setAlignmentX(CENTER_ALIGNMENT);
		username.setMaximumSize(new Dimension(150, 20));

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
		
		box.setAlignmentX(CENTER_ALIGNMENT);
		box.setMaximumSize(new Dimension(150, 20));
		
		box.setSelectedIndex(1);
		box.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == box){
					JComboBox cb = (JComboBox)e.getSource();
					String msg = (String)cb.getSelectedItem();
					
					switch(msg){
						case "Truckdriver":  level1 = 0; 
							break;
						case "CEO":  level1 = 1;
							break;
						case "Official": level1 = 2;
							break;
					}
				}
				
			}
		});
		
		register.setText("Register");
		register.setAlignmentX(CENTER_ALIGNMENT);
		
		register.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String getUsername = username.getText();
				String getPassword = password.getText();
				
				domain.saveUser(getUsername, getPassword, level1);
					add(jlabel);
					validate();
				
			}
		});
		
		goBack.setAlignmentX(CENTER_ALIGNMENT);
		goBack.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				misma.loadMenu(level);
			}
		});
		

		add(Box.createRigidArea(new Dimension(200, 100)));
		add(loglabel);
		loglabel.setAlignmentX(CENTER_ALIGNMENT);
		add(username);
		add(password);
		add(box);
		add(Box.createRigidArea(new Dimension(200, 15)));
		add(register);
		add(goBack);
		revalidate();
		setVisible(true);
	}
	}



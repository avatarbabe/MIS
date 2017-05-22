package ui;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.sun.glass.ui.View;

public class Menu extends JPanel{

	private JButton menu1 = new JButton("Register route");
	private JButton menu2 = new JButton("Register fuel");
	private JButton menu3 = new JButton("Edit tax");
	private JButton menu4 = new JButton("View emissions");
	private JButton menu5 = new JButton("Log out");
	private JButton menu6 = new JButton("Create new user");
	private JButton menu7 = new JButton("View total tax");
	
	
	public Menu(Misma misma, int level) {
		setLayout(new BoxLayout(this, 1));
		setPreferredSize(new Dimension(400, 400));
		setFocusable(true);
		add(Box.createRigidArea(new Dimension(200, 100)));
		
		switch(level){
			case 2: addMenu3(misma, level);
			case 1: addMenu2(misma, level);
			case 0: addMenu1(misma, level);
				break;
		}
	}
	
	public void addMenu1 (Misma misma, int level){
		menu1.setAlignmentX(CENTER_ALIGNMENT);
		menu1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				misma.loadRegisterRoutes(level);
			}
		});
		
		menu2.setAlignmentX(CENTER_ALIGNMENT);
		menu2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				misma.loadRegisterFuel(level);
			}
		});
		
		menu5.setAlignmentX(CENTER_ALIGNMENT);
		menu5.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				misma.loadLogin();
			}
		});
		
		
		add(menu1);
		add(menu2);
		add(menu5);
		
	}
	
	public void addMenu2(Misma misma, int level){
		menu4.setAlignmentX(CENTER_ALIGNMENT);
		menu4.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				misma.loadViewEmission(level);
			}
		});
		
		menu6.setAlignmentX(CENTER_ALIGNMENT);
		menu6.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				misma.loadNewUser(level);
			}
		});
		
		menu7.setAlignmentX(CENTER_ALIGNMENT);
		menu7.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				misma.loadFutureProjections(level);
			}
		});
		
		
		add(menu4);
		add(menu6);
		add(menu7);
	}
	
	public void addMenu3 (Misma misma, int level){
		menu3.setAlignmentX(CENTER_ALIGNMENT);
		menu3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				misma.loadEditTax(level);
			}
		});

		add(menu3);
	}
}
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
	private JButton goBack = new JButton(new ImageIcon(getClass().getClassLoader().getResource("images/arrow.png")));
	
	public Menu(Misma misma, int level) {
		setLayout(new BoxLayout(this, 1));
		setPreferredSize(new Dimension(400, 400));
		setFocusable(true);
		add(Box.createRigidArea(new Dimension(200, 100)));
		goBack.setVisible(true);
		goBack.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
		goBack.setContentAreaFilled(false);
	
		
		switch(level){
			case 2: addMenu3(misma);
			case 1: addMenu2(misma);
			case 0: addMenu1(misma, level);
				break;
		}
	}
	
	public void addMenu1 (Misma misma, int level){
		menu1.setAlignmentX(CENTER_ALIGNMENT);
		menu1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				misma.loadRegisterRoutes();
			}
		});
		
		menu2.setAlignmentX(CENTER_ALIGNMENT);
		menu2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				misma.loadRegisterFuel();
			}
		});
		
		menu5.setAlignmentX(CENTER_ALIGNMENT);
		menu5.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				misma.loadLogin();
			}
		});
		
		goBack.setAlignmentX(CENTER_ALIGNMENT);
		goBack.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				misma.loadMenu(level);
			}
		});
		
		add(menu1);
		add(menu2);
		add(menu5);
		add(goBack);
	}
	
	public void addMenu2(Misma misma){
		menu4.setAlignmentX(CENTER_ALIGNMENT);
		menu4.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				misma.loadViewEmission();
			}
		});
		
		add(menu4);
	}
	
	public void addMenu3 (Misma misma){
		menu3.setAlignmentX(CENTER_ALIGNMENT);
		menu3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				misma.loadEditTax();
			}
		});

		add(menu3);
	}
}
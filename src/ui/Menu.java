package ui;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
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
	
	public Menu(Misma misma) {
		setLayout(new BoxLayout(this, 1));
		setPreferredSize(new Dimension(400, 400));
		setFocusable(true);
	
		
		
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
		
		menu3.setAlignmentX(CENTER_ALIGNMENT);
		menu3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				misma.loadEditTax();
			}
		});
		
		menu4.setAlignmentX(CENTER_ALIGNMENT);
		menu4.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				misma.loadViewEmission();
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
		add(menu3);
		add(menu4);
		add(menu5);
		
	}
}
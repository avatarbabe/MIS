package ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.Calendar;
import java.util.Date;


import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import domain.DomainFacade;


public class FutureProjections extends JPanel {
	
	private JButton goBack = new JButton(new ImageIcon(getClass().getClassLoader().getResource("arrow1.png")));
	private JButton getTax = new JButton("Get Tax");
	
	public FutureProjections(Misma misma, DomainFacade domian, int level){
		
		setPreferredSize(new Dimension(400, 400));
		setFocusable(true);
		setLayout(new BoxLayout(this, 1));
		
		JLabel jlabel = new JLabel("Choose two dates to check the tax payments");
		JLabel from = new JLabel("From: ");
		JLabel to = new JLabel("To: ");
		JTextField date1 = new JTextField("YYYY-MM-DD");
		JTextField date2 = new JTextField("YYYY-MM-DD");
		
		date1.setAlignmentX(CENTER_ALIGNMENT);
		date1.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        date1.setText("");

		    }
		});
		
		date2.setAlignmentX(CENTER_ALIGNMENT);
		date2.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        date2.setText("");

		    }
		});
		
		goBack.setVisible(true);
		goBack.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
		goBack.setContentAreaFilled(false);
				
		goBack.setAlignmentX(CENTER_ALIGNMENT);
		goBack.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				misma.loadMenu(level);
			}
		});

		
		add(Box.createRigidArea(new Dimension(200, 100)));
		from.setAlignmentX(CENTER_ALIGNMENT);
		to.setAlignmentX(CENTER_ALIGNMENT);
		date1.setMaximumSize(new Dimension(150, 20));
		date2.setMaximumSize(new Dimension(150, 20));
		add(jlabel);
		add(from);
		add(date1);
		add(to);
		add(date2);
		add(goBack);
	}
}

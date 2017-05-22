package edu.grupp1.ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

import edu.grupp1.domain.domainfacade.DomainFacade;


public class FutureProjections extends JPanel {
	
	private JButton goBack = new JButton(new ImageIcon(getClass().getClassLoader().getResource("arrow1.png")));
	private JButton getTax = new JButton("Get Tax");
	
	public FutureProjections(Misma misma, DomainFacade domain, int level){
		
		setPreferredSize(new Dimension(400, 400));
		setFocusable(true);
		setLayout(new BoxLayout(this, 1));
		
		
		LocalDate today = LocalDate.now();
		LocalDate start = today.withDayOfMonth(1);
		String first = start.toString();
		String todaysDate = today.toString();
		
		Double d = domain.getTaxBetween(first, todaysDate);
		String total = d.toString();
		
		JLabel label1 = new JLabel("The total tax for the month is: "+ total + " kr");
		JLabel jlabel = new JLabel("Choose two dates to check the total tax between those dates");
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
		
		getTax.setAlignmentX(CENTER_ALIGNMENT);
		getTax.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	String firstDate = date1.getText();
		    	String secondDate = date2.getText();
		    	
		    	double result = domain.getTaxBetween(firstDate, secondDate);
		    	String result1 = Double.toString(result);
		    	JLabel res = new JLabel(result1 + " kr");
		    	res.setAlignmentX(CENTER_ALIGNMENT);
		    	add(res);
		    	validate();

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
		label1.setAlignmentX(CENTER_ALIGNMENT);
		jlabel.setAlignmentX(CENTER_ALIGNMENT);
		from.setAlignmentX(CENTER_ALIGNMENT);
		to.setAlignmentX(CENTER_ALIGNMENT);
		date1.setMaximumSize(new Dimension(150, 20));
		date2.setMaximumSize(new Dimension(150, 20));
		add(label1);
		add(jlabel);
		add(from);
		add(date1);
		add(to);
		add(date2);
		add(getTax);
		add(goBack);
	}
}

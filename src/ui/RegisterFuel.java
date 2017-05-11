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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class RegisterFuel extends JPanel{
	
	private JButton goBack = new JButton(new ImageIcon(getClass().getClassLoader().getResource("arrow1.png")));
	
	public RegisterFuel(Misma misma, int level){
		setPreferredSize(new Dimension(400, 400));
		setFocusable(true);
		setLayout(new BoxLayout(this, 1));
		
		goBack.setVisible(true);
		goBack.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
		goBack.setContentAreaFilled(false);
		
		JLabel label = new JLabel("Fuel:" );
		JTextField fuel = new JTextField();
		JButton register = new JButton("Register");
		
		fuel.setText("In liter");
		fuel.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        fuel.setText("");
		    }
		});
		
		goBack.setAlignmentX(CENTER_ALIGNMENT);
		goBack.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				misma.loadMenu(level);
			}
		});
		
		label.setAlignmentX(CENTER_ALIGNMENT);
		fuel.setAlignmentX(CENTER_ALIGNMENT);
		fuel.setMaximumSize(new Dimension(150, 20));
		
		register.setAlignmentX(CENTER_ALIGNMENT);
		add(Box.createRigidArea(new Dimension(200, 100)));
		add(label);
		add(fuel);
		
		add(Box.createRigidArea(new Dimension(200, 15)));
		add(register);
		add(goBack);
	
	}
}
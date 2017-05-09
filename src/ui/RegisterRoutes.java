package ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegisterRoutes extends JPanel{
	
	public RegisterRoutes(Misma misma){
		setPreferredSize(new Dimension(400, 400));
		setFocusable(true);
		
		setLayout(new BoxLayout(this, 1));
		
		JTextField from = new JTextField();
		JTextField to = new JTextField();
		JTextField distance = new JTextField();
		JButton register = new JButton("Register");
		
		from.setText("From");
		from.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        from.setText("");
		    }
		});
		from.setAlignmentX(CENTER_ALIGNMENT);
		from.setMaximumSize(new Dimension(150, 20));
		to.setText("To");
		to.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        to.setText("");
		    }
		});
		to.setAlignmentX(CENTER_ALIGNMENT);
		to.setMaximumSize(new Dimension(150, 20));
		distance.setText("Distance");
		distance.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        distance.setText("");
		    }
		});
		distance.setAlignmentX(CENTER_ALIGNMENT);
		distance.setMaximumSize(new Dimension(150, 20));

		register.setAlignmentX(CENTER_ALIGNMENT);
		add(Box.createRigidArea(new Dimension(200, 100)));
		add(from);
		add(to);
		add(distance);
		add(Box.createRigidArea(new Dimension(200, 15)));
		add(register);
		
		register.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			misma.loadRegisterFuel();
			}
		});
	}
}
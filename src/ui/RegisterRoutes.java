package ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegisterRoutes extends JPanel{
	
	public RegisterRoutes(Misma misma){
		setPreferredSize(new Dimension(400, 400));
		setFocusable(true);
		setLayout(new BoxLayout(this, 1));
		String[] message = {"Truck x2000", "Truck 900", "Truck 30s"};
		
		JLabel vehicle = new JLabel("Vehicle:");
		JTextField from = new JTextField();
		JTextField to = new JTextField();
		JTextField distance = new JTextField();
		JComboBox box  = new JComboBox(message);
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
		vehicle.setAlignmentX(CENTER_ALIGNMENT);
		
		box.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        distance.setText("");
		    }
		});
		box.setAlignmentX(CENTER_ALIGNMENT);
		box.setMaximumSize(new Dimension(150, 20));
		

		
		register.setAlignmentX(CENTER_ALIGNMENT);
		add(Box.createRigidArea(new Dimension(200, 100)));
		add(from);
		add(to);
		add(distance);
		add(vehicle);
		add(box);
		add(Box.createRigidArea(new Dimension(200, 15)));
		add(register);
		
		register.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		box.setSelectedIndex(1);
		box.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == box){
					JComboBox cb = (JComboBox)e.getSource();
					String msg = (String)cb.getSelectedItem();
					switch(msg){
						case "Truck x2000": double t1 = 3.0; 
							break;
						case "Truck 900": double t2 = 1.6;
							break;
						case "Truck 30s": double t3 = 1.2;
							break;
						default: System.out.println("no");
					}
				}
				
			}
		});
		
		
	}
}
package ui;

import domain.DomainFacade;
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
import javax.swing.JTextField;

public class RegisterRoutes extends JPanel{
	private Misma misma;
	private DomainFacade domain;
	private Double t = 1.6;
	private JButton goBack = new JButton(new ImageIcon(getClass().getClassLoader().getResource("arrow1.png")));
	private JLabel jlabel = new JLabel();

	
	public RegisterRoutes(Misma misma, DomainFacade domain, int level){
		this.domain = domain;
		this.misma = misma;
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
		
		jlabel.setText("Route registered!");
		jlabel.setAlignmentX(CENTER_ALIGNMENT);
		
		goBack.setVisible(true);
		goBack.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
		goBack.setContentAreaFilled(false);

		
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
		
		goBack.setAlignmentX(CENTER_ALIGNMENT);
		goBack.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				misma.loadMenu(level);
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
		add(goBack);
		
		
		box.setSelectedIndex(1);
		box.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == box){
					JComboBox cb = (JComboBox)e.getSource();
					String msg = (String)cb.getSelectedItem();
					
					switch(msg){
						case "Truck x2000":  t = 3.0; 
							break;
						case "Truck 900":  t = 1.6;
							break;
						case "Truck 30s": t = 1.2;
							break;
					}
				}
				
			}
		});

			
		register.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				String from1 = from.getText();
				String to1 = to.getText();
				Double distance1 = Double.parseDouble(distance.getText());
				
				domain.saveRoute(from1, to1, distance1, t);
				 add(jlabel);
			     validate();
			}
		});
		
		
	}
}

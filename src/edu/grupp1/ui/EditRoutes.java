package edu.grupp1.ui;

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

import edu.grupp1.domain.domainfacade.DomainFacade;

public class EditRoutes extends JPanel{
	
	private JButton goBack = new JButton(new ImageIcon(getClass().getClassLoader().getResource("arrow1.png")));
	private JLabel jlabel = new JLabel();
	private String type;
	private String msg;
	private double t;
	
	public EditRoutes(Misma misma, DomainFacade domain, int level, Object routeRow){
		String row = routeRow.toString();
		String[] split = row.split("\\s+");
		String [] message = {"x2000", "900", "30s"};
		int id = Integer.parseInt(split[0]);
		String user = split[12];
		
		setPreferredSize(new Dimension(400, 400));
		setFocusable(true);
		setLayout(new BoxLayout(this, 1));
		
		jlabel.setText("Emissions edited!");
		jlabel.setAlignmentX(CENTER_ALIGNMENT);

		goBack.setVisible(true);
		goBack.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
		goBack.setContentAreaFilled(false);
		
		JLabel label = new JLabel("Edit:" );
		JComboBox editTruck = new JComboBox(message);
		JTextField editFrom = new JTextField(split[2]);
		JTextField editTo = new JTextField(split[4]);
		JTextField editDistance = new JTextField(split[6]);
		JButton changeEmissions = new JButton("Change");
		
		
		editTruck.setSelectedItem(split[10]);
		editTruck.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == editTruck){
					JComboBox cb = (JComboBox)e.getSource();
					msg = (String)cb.getSelectedItem();
					
					switch(msg){
						case "x2000":  t = 3.0; 
							break;
						case "900":  t = 1.6;
							break;
						case "30s": t = 1.2;
							break;
						default: t = 1.6;	
						
					}
				}
				
			}
		});
		
		editFrom.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        editFrom.setText("");
		    }
		});
		
		editTo.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        editTo.setText("");
		    }
		});
		
		editDistance.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        editDistance.setText("");
		    }
		});
		
		
		changeEmissions.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	String editFrom1 = editFrom.getText();
		    	String editTo1 = editTo.getText();
		    	Double editDistance1 = Double.parseDouble(editDistance.getText());
		    	
		        domain.updateRoute(editFrom1, editTo1, editDistance1, t, user, id, msg);
		        add(jlabel);
		        validate();
		    }
		});
					
		goBack.setAlignmentX(CENTER_ALIGNMENT);
		goBack.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				misma.loadViewEmission(level);
			}
		});
		
		label.setAlignmentX(CENTER_ALIGNMENT);
		editFrom.setAlignmentX(CENTER_ALIGNMENT);
		editTo.setAlignmentX(CENTER_ALIGNMENT);
		editDistance.setAlignmentX(CENTER_ALIGNMENT);
		editTruck.setAlignmentX(CENTER_ALIGNMENT);
		changeEmissions.setAlignmentX(CENTER_ALIGNMENT);
		
		add(Box.createRigidArea(new Dimension(200, 100)));
		editFrom.setMaximumSize(new Dimension(150, 20));
		editTo.setMaximumSize(new Dimension(150, 20));
		editDistance.setMaximumSize(new Dimension(150, 20));
		editTruck.setMaximumSize(new Dimension(150, 20));
		add(label);
		add(editFrom);
		add(editTo);
		add(editDistance);
		add(editTruck);
		add(changeEmissions);
		add(goBack);
	}
}

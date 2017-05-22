package edu.grupp1.ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.grupp1.data.datatransferobject.DataTransferObject;
import edu.grupp1.data.dto.FuelData;
import edu.grupp1.data.dto.RouteData;
import edu.grupp1.domain.domainfacade.DomainFacade;

public class ViewEmission extends JPanel {

	private JButton goBack = new JButton(new ImageIcon(getClass().getClassLoader().getResource("arrow1.png")));
	private JButton edit = new JButton("Edit fuel");
	private JButton edit1 = new JButton("Edit routes");


	public ViewEmission(Misma misma, DomainFacade domain, int level){
			setPreferredSize(new Dimension(400, 400));
			setFocusable(true);
			setLayout(new BoxLayout(this, 1));
			
			goBack.setVisible(true);
			goBack.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
			goBack.setContentAreaFilled(false);

			
			JLabel label = new JLabel("Fuel: " );
			JLabel label1 = new JLabel("Routes: " );
			DefaultListModel listModel = new DefaultListModel();
			DefaultListModel listModel1 = new DefaultListModel();
			
			
			List<DataTransferObject> fuel = domain.getAllFuel();
			List<DataTransferObject> routes = domain.getAllRoutes();
			
			//g�r om till hashmap ^
			
			for (DataTransferObject dto: fuel){
				String type = ((FuelData) dto).getFuelType();
				double volume = ((FuelData) dto).getVolume();
				double emissions2 = ((FuelData) dto).getEmission();
				int id = ((FuelData) dto).getId();
				String user = ((FuelData) dto).getUser();
				
				listModel.addElement(id + " Type: " + type + " Volume: " + volume + " Emissions: " +emissions2 + " User: " +user);
			}
			
			for (DataTransferObject dto: routes){
				
				String start = ((RouteData) dto).getStart();
				String end = ((RouteData) dto).getEnd();
				double distance = ((RouteData) dto).getDistance();
				double emissions1 = ((RouteData) dto).getEmission();
				int id = ((RouteData) dto).getId();
				String user = ((RouteData) dto).getUser();
				String vehicle = ((RouteData) dto).getVehicle();
				
				listModel1.addElement(id + " From: " + start + " To: " + end + " Distance: " + distance+ " Emissions: " + emissions1 + " Vehicle: " + vehicle + " User: " + user);
			}

			JList emissions = new JList(listModel);
			JList route = new JList(listModel1);
			JScrollPane sp = new JScrollPane(emissions);
			JScrollPane sp1 = new JScrollPane(route);
			
			
			edit.setAlignmentX(CENTER_ALIGNMENT);
			edit.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					
					misma.loadEditFuel(emissions.getSelectedValue(), level);
					//misma.loadEditFuel(level);
				}
			});
			
			edit1.setAlignmentX(CENTER_ALIGNMENT);
			edit1.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					
					misma.loadEditRoutes(route.getSelectedValue(), level);
					//misma.loadEditFuel(level);
				}
			});
			
			goBack.setAlignmentX(CENTER_ALIGNMENT);
			goBack.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					misma.loadMenu(level);
				}
			});
			
			setAlignmentX(CENTER_ALIGNMENT);
			add(Box.createRigidArea(new Dimension(90, 10)));
			add(label);
			add(sp);
			add(edit);
			add(label1);
			add(sp1);
			add(edit1);
			add(goBack);		
		}
}
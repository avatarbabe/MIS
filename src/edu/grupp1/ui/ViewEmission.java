package edu.grupp1.ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Iterator;
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
import edu.grupp1.domain.Fuel;
import edu.grupp1.domain.Route;
import edu.grupp1.domain.domainfacade.DomainFacade;

public class ViewEmission extends JPanel {

	private JButton goBack = new JButton(new ImageIcon(getClass().getClassLoader().getResource("arrow1.png")));
	private JButton edit = new JButton("Edit fuel");
	private JButton edit1 = new JButton("Edit routes");
	private DataTransferObject idFuel;
	private DataTransferObject idRoute;

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
			
			
			List<Fuel> fuel = domain.getAllFuel();
			List<Route> routes = domain.getAllRoutes();
			
			HashMap<Integer, Fuel> f = domain.fuelToHashMap(fuel);
			HashMap<Integer, Route> r = domain.routeToHashMap(routes);
			
			
			Iterator it = f.entrySet().iterator();
			
			while (it.hasNext()){
				HashMap.Entry pair = (HashMap.Entry)it.next();
				int key = (int) pair.getKey();
				Fuel fuel1 = (Fuel) pair.getValue();
				//DataTransferObject dto = (DataTransferObject) pair.getValue();
				
				listModel.addElement(fuel1.getId() + " Volym: " + fuel1.getVolume() + " Type: "+ 
				fuel1.getFuelType() +" Emissions: " + fuel1.getEmission()+ " User: " + fuel1.getUser());
			}
			
			it = r.entrySet().iterator();
			
			while (it.hasNext()){
				HashMap.Entry pair = (HashMap.Entry)it.next();
				int key = (int) pair.getKey();
				//DataTransferObject dto = (DataTransferObject) pair.getValue();
				Route route1 = (Route) pair.getValue();
				listModel1.addElement(route1.getId() + " From: " + route1.getStart() + " To: "+route1.getEnd()+" Distance: "+ route1.getDistance() 
						+ " Vehicle: "+ route1.getVehicle() +" Emissions: " + route1.getEmission()+ " User: " + route1.getUser());
			}
			

			JList emissions = new JList(listModel);
			JList route = new JList(listModel1);
			JScrollPane sp = new JScrollPane(emissions);
			JScrollPane sp1 = new JScrollPane(route);
						
			
			edit.setAlignmentX(CENTER_ALIGNMENT);
			edit.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					
					String row = (String) emissions.getSelectedValue();
					String[] split = row.split("\\s+");
					
					int key = Integer.parseInt(split[0]);
					
					misma.loadEditFuel(f.get(key), level);
					//misma.loadEditFuel(level);
				}
			});
			
			edit1.setAlignmentX(CENTER_ALIGNMENT);
			edit1.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					
					String row = (String) route.getSelectedValue();
					String[] split = row.split("\\s+");
					int key = Integer.parseInt(split[0]);
					misma.loadEditRoutes(r.get(key), level);
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
package ui;

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

import data.FuelData;
import datatransferobject.DataTransferObject;
import domain.DomainFacade;

public class ViewEmission extends JPanel {

	private JButton goBack = new JButton(new ImageIcon(getClass().getClassLoader().getResource("arrow1.png")));


	public ViewEmission(Misma misma, DomainFacade domain, int level){
			setPreferredSize(new Dimension(400, 400));
			setFocusable(true);
			setLayout(new BoxLayout(this, 1));
			
			goBack.setVisible(true);
			goBack.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
			goBack.setContentAreaFilled(false);

			
			JLabel label = new JLabel("View emissions:" );
			DefaultListModel listModel = new DefaultListModel();
			
			
			List<DataTransferObject> fuel = domain.getAllFuel();
			
			for (DataTransferObject dto: fuel){
				String type = ((FuelData) dto).getFuelType();
				double volume = ((FuelData) dto).getVolume();
				listModel.addElement(type + "   " + volume);
			}

			JList emissions = new JList(listModel);
			JScrollPane sp = new JScrollPane(emissions);
			
			goBack.setAlignmentX(CENTER_ALIGNMENT);
			goBack.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					misma.loadMenu(level);
				}
			});
			
			label.setAlignmentX(CENTER_ALIGNMENT);
			add(Box.createRigidArea(new Dimension(200, 100)));
			add(label);
			add(sp);
			add(goBack);
			

		}
}

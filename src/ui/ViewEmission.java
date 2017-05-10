package ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewEmission extends JPanel {

	public ViewEmission(){
			setPreferredSize(new Dimension(400, 400));
			setFocusable(true);
			
			setLayout(new BoxLayout(this, 1));
			
			JLabel label = new JLabel("View emissions:" );
			
			label.setAlignmentX(CENTER_ALIGNMENT);
			add(Box.createRigidArea(new Dimension(200, 100)));
			add(label);

		}
}

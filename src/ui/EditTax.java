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

public class EditTax extends JPanel {

	public EditTax(){
			setPreferredSize(new Dimension(400, 400));
			setFocusable(true);
			
			setLayout(new BoxLayout(this, 1));
			
			JLabel label = new JLabel("Edit:" );
			JTextField tax = new JTextField();
			JButton changeRate = new JButton("change tax rate");
			
			tax.setText("Edit");
			
			tax.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseClicked(MouseEvent e) {
			        tax.setText("");
			    }
			});
			
			label.setAlignmentX(CENTER_ALIGNMENT);
			tax.setAlignmentX(CENTER_ALIGNMENT);
			changeRate.setAlignmentX(CENTER_ALIGNMENT);
			
			add(Box.createRigidArea(new Dimension(200, 100)));
			tax.setMaximumSize(new Dimension(150, 20));
			add(label);
			add(tax);
			add(changeRate);

		}
}
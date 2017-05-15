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

import domain.DomainFacade;

public class EditTax extends JPanel {

	private JButton goBack = new JButton(new ImageIcon(getClass().getClassLoader().getResource("arrow1.png")));
	private JLabel jlabel = new JLabel();
	
	public EditTax(Misma misma, DomainFacade domain, int level){
			setPreferredSize(new Dimension(400, 400));
			setFocusable(true);
			setLayout(new BoxLayout(this, 1));
			
			jlabel.setText("Taxrate registered!");
			jlabel.setAlignmentX(CENTER_ALIGNMENT);

			goBack.setVisible(true);
			goBack.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
			goBack.setContentAreaFilled(false);
			
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
			

			goBack.setAlignmentX(CENTER_ALIGNMENT);
			goBack.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					String tax1 = tax.getText();
					Double taxRate = Double.parseDouble(tax1);
					
					domain.setTaxes(taxRate);
					add(jlabel);
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
			add(goBack);

		}
}
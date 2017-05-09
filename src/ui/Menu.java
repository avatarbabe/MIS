package ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu {

	public Menu(Misma misma) {

		JMenuBar menubar = new JMenuBar();
		JMenuItem menu1 = new JMenuItem("Register route");
		JMenuItem menu2 = new JMenuItem("Register fuel");
		JMenuItem menu3 = new JMenuItem("Edit tax");
		JMenuItem menu4 = new JMenuItem("View emissions");
		menubar.add(menu1);
		menubar.add(menu2);
		menubar.add(menu3);
		menubar.add(menu4);
		misma.setJMenuBar(menubar);
		
		menu1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
					misma.loadRegisterRoutes();
				}
		});
	
	menu2.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
				misma.loadRegisterFuel();
			}
	});
	}
}
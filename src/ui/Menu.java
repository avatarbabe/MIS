package ui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class Menu {

	public Menu(Misma misma) {
	
	JMenuBar menubar = new JMenuBar();
	JMenu menu1 = new JMenu("Register route");
	JMenu menu2 = new JMenu("Register fuel");
	JMenu menu3 = new JMenu("Edit tax");
	JMenu menu4 = new JMenu("View emissions");
	menubar.add(menu1);
	menubar.add(menu2);
	menubar.add(menu3);
	menubar.add(menu4);
	misma.setJMenuBar(menubar);
	}
}

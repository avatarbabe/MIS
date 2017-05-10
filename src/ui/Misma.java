package ui;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import datafacade.DataFacade;
import domain.DomainFacade;

public class Misma extends JFrame {
	
	private DataFacade data;
	private DomainFacade domain;
	
	public Misma(DataFacade data, DomainFacade domain) {
		
		this.data = data;
		this.domain = domain;
		
		setTitle("MISMA");
		loadLogin();
		setPreferredSize(new Dimension(600, 500));
		revalidate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		
		setVisible(true);
		
	}

	public void loadLogin() {
		getContentPane().removeAll();
		JPanel login = new Login(getWindow(), data, domain);
		add(login);

	}
	
	public final Misma getWindow(){
		return this;
	}

	public void loadRegisterRoutes() {
		getContentPane().removeAll();
		JPanel registerRoutes = new RegisterRoutes(this, domain);
		add(registerRoutes);
		pack();
		
	}
	public void loadRegisterFuel() {
		getContentPane().removeAll();
		JPanel registerFuel = new RegisterFuel();
		add(registerFuel);
		pack();
	

}
	}

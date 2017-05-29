package edu.grupp1.ui.swing;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import edu.grupp1.data.datafacade.DataFacade;
import edu.grupp1.data.datatransferobject.DataTransferObject;
import edu.grupp1.domain.Fuel;
import edu.grupp1.domain.Route;
import edu.grupp1.domain.domainfacade.DomainFacade;
import edu.grupp1.ui.observer.IObserver;

public class Misma extends JFrame implements IObserver{
	
	//registrera i dom�nlagret som lyssnare subjekt.register(this)
	
	private DataFacade data;
	private DomainFacade domain;
	
	public Misma(DataFacade data, DomainFacade domain) {
		
		this.data = data;
		this.domain = domain;
		
		
		loadLogin();
		setPreferredSize(new Dimension(600, 500));
		revalidate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		
		setVisible(true);
		
	}

	public final Misma getWindow(){
		return this;
	}

	public void loadLogin() {
		setTitle("MISMA");
		getContentPane().removeAll();
		JPanel login = new Login(getWindow(), data, domain);
		add(login);
		pack();

	}
	
	public void loadMenu(int level){
		getContentPane().removeAll();
		JPanel menu = new Menu(this, level);
		add(menu);
		pack();
	}
	
	public void loadRegisterRoutes(int level) {
		getContentPane().removeAll();
		JPanel registerRoutes = new RegisterRoutes(this, domain, level);
		add(registerRoutes);
		pack();
		
	}
	public void loadRegisterFuel(int level) {
		getContentPane().removeAll();
		JPanel registerFuel = new RegisterFuel(this, domain, level);
		add(registerFuel);
		pack();
}
	public void loadEditTax(int level) {
		getContentPane().removeAll();
		JPanel registerTax = new EditTax(this, domain, level);
		add(registerTax);
		pack();
	}
	public void loadViewEmission(int level){
		getContentPane().removeAll();
		JPanel viewEmission  = new ViewEmission(this, domain, level);
		add(viewEmission);
		pack();
	}
	public void loadNewUser(int level){
		getContentPane().removeAll();
		JPanel newUser  = new NewUser(this, domain, level);
		add(newUser);
		pack();
	}
	public void loadEditFuel(Fuel fuel, int level){
		getContentPane().removeAll();
		JPanel editFuel = new EditFuel(this, domain, level, fuel);
		add(editFuel);
		pack();
	}
	
	public void loadEditRoutes(Route route, int level){
		getContentPane().removeAll();
		JPanel editRoutes = new EditRoutes(this, domain, level, route);
		add(editRoutes);
		pack();
	}
	
	public void loadFutureProjections(int level){
		getContentPane().removeAll();
		JPanel futureProjections = new FutureProjections(this, domain, level);
		add(futureProjections);
		pack();
	}

	@Override
	public void update() {
		setTitle("MISMA - " + domain.getUser().getUsername());
		
	}
}
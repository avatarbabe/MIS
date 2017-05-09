package ui;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import datafacade.DataFacade;
import domain.DomainFacade;

public class Misma extends JFrame {
	
	private DataFacade data;
	private DomainFacade domain;
	
	public Misma(DataFacade data, DomainFacade domain) {
		
		this.data = data;
		this.domain = domain;
		System.out.println("hallo");
		
		setTitle("MISMA");
		setPreferredSize(new Dimension(400, 400));
		loadLogin();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		revalidate();
		setVisible(true);
	}

	public void loadLogin() {
		getContentPane().removeAll();
		JPanel login = new Login(getWindow(), data);
		add(login);

	}
	
	public final Misma getWindow(){
		return this;
	}

	public void loadRegisterRoutes() {
		getContentPane().removeAll();
		JPanel registerRoutes = new RegisterRoutes();
		add(registerRoutes);
		pack();
		
	}

}

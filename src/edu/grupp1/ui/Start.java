package edu.grupp1.ui;

import edu.grupp1.data.datafacade.DataFacade;
import edu.grupp1.domain.domainfacade.DomainFacade;
import edu.grupp1.ui.swing.Misma;

public class Start {
	
	public static void main(String[] args) {
		DataFacade data = new DataFacade();
		data.register();
		DomainFacade domain = new DomainFacade();
		domain.register(data);
		Misma mis = new Misma(data, domain);
	}
}

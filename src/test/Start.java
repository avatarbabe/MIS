package test;

import datafacade.DataFacade;
import domain.DomainFacade;
import ui.Misma;

public class Start {
	
	public static void main(String[] args) {
		DataFacade data = new DataFacade();
		data.register();
		DomainFacade domain = new DomainFacade();
		domain.register(data);
		Misma mis = new Misma(data, domain);
	}
}

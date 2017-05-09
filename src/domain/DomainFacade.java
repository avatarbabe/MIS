package domain;

import datafacade.DataFacade;

public class DomainFacade {

	private DataFacade data;
	
	public void register(DataFacade data) {
		this.data = data;
	}

}

package edu.grupp1.data.datafacade;

import java.util.ArrayList;
import java.util.List;

import edu.grupp1.data.broker.FuelDataBroker;
import edu.grupp1.data.broker.RouteDataBroker;
import edu.grupp1.data.broker.TaxesDataBroker;
import edu.grupp1.data.broker.UserDataBroker;
import edu.grupp1.data.datatransferobject.DataTransferObject;
import edu.grupp1.data.dto.FuelData;
import edu.grupp1.data.dto.RouteData;
import edu.grupp1.data.dto.TaxesData;
import edu.grupp1.data.dto.UserData;
import edu.grupp1.data.persistencyfacade.PersistencyFacade;
import edu.grupp1.domain.Fuel;
import edu.grupp1.domain.Route;
import edu.grupp1.domain.Taxes;
import edu.grupp1.domain.User;

public class DataFacade {

	protected PersistencyFacade persistance = new PersistencyFacade();

	public List<DataTransferObject> find(DataTransferObject dto) {
		List<DataTransferObject> result = persistance.find(dto);

		return result;

	}

	public void save(DataTransferObject dto) {
		persistance.save(dto);
	}

	public void register() {
		persistance.register(UserData.class, new UserDataBroker());
		persistance.register(RouteData.class, new RouteDataBroker());
		persistance.register(FuelData.class, new FuelDataBroker());
		persistance.register(TaxesData.class, new TaxesDataBroker());
	}

	public List<DataTransferObject> findAll(DataTransferObject dto) {
		return persistance.findAll(dto);
	}

	public void update(DataTransferObject dto) {
		persistance.update(dto);

	}

}

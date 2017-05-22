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

	public List<UserData> find(UserData data) {
		List<UserData> result = new ArrayList<>();
		List<DataTransferObject> list = persistance.find(data);

		for (DataTransferObject dto : list) {
			result.add((UserData) dto);
		}
		return result;

	}

	public void save(Route route) {
		DataTransferObject routeData = new RouteData(route);
		persistance.save(routeData);
	}

	public void save(Fuel fuel) {
		DataTransferObject fuelData = new FuelData(fuel);
		persistance.save(fuelData);
	}

	public void save(User user) {
		DataTransferObject userData = new UserData(user);
		persistance.save(userData);
	}

	public void register() {
		persistance.register(UserData.class, new UserDataBroker());
		persistance.register(RouteData.class, new RouteDataBroker());
		persistance.register(FuelData.class, new FuelDataBroker());
		persistance.register(TaxesData.class, new TaxesDataBroker());
	}

	public List<DataTransferObject> findAll(Fuel fuel) {
		DataTransferObject fuelData = new FuelData(fuel);
		return persistance.findAll(fuelData);
	}

	public List<DataTransferObject> findAll(Route route) {
		DataTransferObject routeData = new RouteData(route);
		return persistance.findAll(routeData);
	}

	public void update(Taxes tax) {
		DataTransferObject taxData = new TaxesData(tax);
		persistance.update(taxData);

	}

	public void update(Fuel fuel) {
		DataTransferObject fuelData = new FuelData(fuel);
		persistance.update(fuelData);

	}

	public void update(Route route) {
		DataTransferObject routeData = new RouteData(route);
		persistance.update(routeData);

	}

	public List<DataTransferObject> getTax(Taxes tax) {
		DataTransferObject taxesData = new TaxesData(tax);
		return persistance.find(taxesData);
	}

	public List<DataTransferObject> findBetween(Route route) {
		RouteData routeData = new RouteData(route);
		return persistance.find(routeData);
	}

	public List<DataTransferObject> findBetween(Fuel fuel) {
		FuelData fuelData = new FuelData(fuel);
		return persistance.find(fuelData);
	}

}

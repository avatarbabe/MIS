package datafacade;

import java.util.ArrayList;
import java.util.List;

import broker.FuelDataBroker;
import broker.RouteDataBroker;
import broker.TaxesDataBroker;
import broker.UserDataBroker;
import data.FuelData;
import data.RouteData;
import data.TaxesData;
import data.UserData;
import datatransferobject.DataTransferObject;
import domain.Fuel;
import domain.Route;
import domain.User;
import persistencyfacade.PersistencyFacade;

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

}

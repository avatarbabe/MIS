package datafacade;

import java.util.ArrayList;
import java.util.List;

import broker.FuelDataBroker;
import broker.RouteDataBroker;
import broker.UserDataBroker;
import data.FuelData;
import data.RouteData;
import data.UserData;
import datatransferobject.DataTransferObject;
import domain.Route;
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
		RouteData routeData = new RouteData(route);
		persistance.save(routeData);
	}


	public void register() {
		persistance.register(UserData.class, new UserDataBroker());
		persistance.register(RouteData.class, new RouteDataBroker());
		persistance.register(FuelData.class, new FuelDataBroker());
	}

}

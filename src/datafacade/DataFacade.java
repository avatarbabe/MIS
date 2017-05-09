package datafacade;

import java.util.ArrayList;
import java.util.List;

import broker.UserDataBroker;
import data.UserData;
import datatransferobject.DataTransferObject;
import persistencyfacade.PersistencyFacade;

public class DataFacade {

	protected PersistencyFacade persistance = new PersistencyFacade();

	public List<UserData> find(UserData data) {
		List<UserData> result = new ArrayList<>();
		List<DataTransferObject> list = persistance.find(data);

		for(DataTransferObject dto : list){
			result.add((UserData) dto);
		}
		return result;

	}

	public void register() {
		persistance.register(UserData.class, new UserDataBroker());
	}

}

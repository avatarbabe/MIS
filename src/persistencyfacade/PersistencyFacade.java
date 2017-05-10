package persistencyfacade;

import java.util.HashMap;
import java.util.List;

import broker.Broker;
import data.UserData;
import datatransferobject.DataTransferObject;

public class PersistencyFacade {

	protected HashMap<Class<?>, Broker> brokers = new HashMap<>();

	public List<DataTransferObject> find(UserData data) {
		Broker broker = brokers.get(data.getClass());
		return broker.find(data);
	}

	public void register(Class<?> key, Broker broker) {
		brokers.put(key, broker);
	}

	public void save(DataTransferObject data) {
		Broker broker = brokers.get(data.getClass());
		broker.insert();
	}

}

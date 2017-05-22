package edu.grupp1.data.persistencyfacade;

import java.util.HashMap;
import java.util.List;

import edu.grupp1.data.broker.Broker;
import edu.grupp1.data.datatransferobject.DataTransferObject;
import edu.grupp1.data.dto.RouteData;
import edu.grupp1.data.dto.UserData;

public class PersistencyFacade {

	protected HashMap<Class<?>, Broker> brokers = new HashMap<>();

	public List<DataTransferObject> find(DataTransferObject data) {
		Broker broker = brokers.get(data.getClass());
		return broker.find(data);
	}

	public void register(Class<?> key, Broker broker) {
		brokers.put(key, broker);
	}

	public void save(DataTransferObject data) {
		Broker broker = brokers.get(data.getClass());
		broker.insert(data);
	}

	public List<DataTransferObject> findAll(DataTransferObject data) {
		Broker broker = brokers.get(data.getClass());
		return broker.findAll();
	}
	
	public void update(DataTransferObject data){
		Broker broker = brokers.get(data.getClass());
		broker.update(data);
	}

}

package domain;

import java.util.ArrayList;
import java.util.List;

import data.RouteData;
import data.TaxesData;
import data.UserData;
import datafacade.DataFacade;
import datatransferobject.DataTransferObject;
import ui.Menu;

public class DomainFacade {

	private DataFacade data;
	private User aUser;
	private Calculator calculator;

	public void register(DataFacade data) {
		this.data = data;
	}

	public User login(String username, String password) {

		UserData userData = new UserData(username, password);

		List<UserData> userList = data.find(userData);

		if (userList.size() < 1) {
			return null;
		} else {

			User user = new User(userList.get(0));

			aUser = user;

			return user;
		}

	}

	public void saveRoute(String start, String end, double distance, double fuelConsumption, String vehicle) {

		Route route = new Route(start, end, distance, fuelConsumption, aUser.getUsername(), vehicle);		

		data.save(route);

	}
	
	public void saveFuel(double volume, String fuelType, double emissionRate){
		
		Fuel fuel = new Fuel(volume, fuelType, emissionRate, aUser.getUsername());
		data.save(fuel);
	}
	
	public int getActiveUserLevel(){
		return aUser.getLevel();
	}
	
	public List<DataTransferObject> getAllFuel(){
		Fuel fuel = new Fuel();
		return data.findAll(fuel);
	}
	
	public List<DataTransferObject> getAllRoutes(){
		Route route = new Route();
		return data.findAll(route);
	}
	
	public void resetUser(){
		aUser = null;
	}
	
	public void saveUser(String username, String password, int level){
		User user = new User(username, password, level);
		data.save(user);
	}
	
	public void setTaxes(Double taxrate){
		Taxes tax = new Taxes(taxrate);
		data.update(tax);
	}
	
	public double getTaxes(){
		Taxes tax = new Taxes();
		List<DataTransferObject> taxes = data.getTax(tax);
		double taxrate = ((TaxesData) taxes.get(0)).getTaxRate();
		return taxrate;
	}
	
	public void updateFuel(double volume, String fuelType, double rate, String user, int id){
		Fuel fuel = new Fuel(volume, fuelType, rate, user, id);
		data.update(fuel);
	}
	
	public void updateRoute(String start, String end, double distance, double fuelConsumption, String user, int id, String vehicle){
		Route route = new Route(start, end, distance, fuelConsumption, user, id, vehicle);
		data.update(route);
	}

}

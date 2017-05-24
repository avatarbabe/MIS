package edu.grupp1.domain.domainfacade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.grupp1.data.datafacade.DataFacade;
import edu.grupp1.data.datatransferobject.DataTransferObject;
import edu.grupp1.data.dto.RouteData;
import edu.grupp1.data.dto.TaxesData;
import edu.grupp1.data.dto.UserData;
import edu.grupp1.domain.Calculator;
import edu.grupp1.domain.Fuel;
import edu.grupp1.domain.Route;
import edu.grupp1.domain.Taxes;
import edu.grupp1.domain.User;
import edu.grupp1.ui.Menu;

public class DomainFacade {

	private DataFacade data;
	private User aUser;
	private Calculator calculator;
	private Taxes tax;

	public void register(DataFacade data) {
		this.data = data;
	}

	public User login(String username, String password) {

		UserData userData = new UserData(username, password);

		List<DataTransferObject> userList = data.find(userData);

		if (userList.size() < 1) {
			return null;
		} else {

			User user = new User((UserData) userList.get(0));

			aUser = user;

			return user;
		}

	}

	public void saveRoute(String start, String end, double distance, double fuelConsumption, String vehicle) {

		Route route = new Route(start, end, distance, fuelConsumption, aUser.getUsername(), vehicle);
		data.save(route.transform());

	}

	public void saveFuel(double volume, String fuelType, double emissionRate) {

		Fuel fuel = new Fuel(volume, fuelType, emissionRate, aUser.getUsername());
		data.save(fuel.transform());
	}

	public int getActiveUserLevel() {
		return aUser.getLevel();
	}

	public List<Fuel> getAllFuel() {
		Fuel fuel = new Fuel();
		List<Fuel> fuels = new ArrayList<>();

		List<DataTransferObject> fuelDtos = data.findAll(fuel.transform());

		for (DataTransferObject dto : fuelDtos) {
			fuels.add(new Fuel(dto));
		}

		
		return fuels;
	}

	public List<Route> getAllRoutes() {
		Route route = new Route();
		List<Route> routes = new ArrayList<>();

		List<DataTransferObject> routeDtos = data.findAll(route.transform());

		for (DataTransferObject dto : routeDtos) {
			routes.add(new Route(dto));
		}

		return routes;
	}

	public void resetUser() {
		aUser = null;
	}

	public void saveUser(String username, String password, int level) {
		User user = new User(username, password, level);
		data.save(user.transform());
	}

	public void setTaxes(Double taxrate) {
		tax = new Taxes(taxrate);
		data.update(tax.transform());
	}

	public double getTaxes() {
		tax = new Taxes();
		tax.setId(1);
		List<DataTransferObject> taxes = data.find(tax.transform());
		double taxrate = ((TaxesData) taxes.get(0)).getTaxRate();
		return taxrate;
	}

	public void updateFuel(Fuel fuel) {
		data.update(fuel.transform());
		
	}

	public void updateRoute(Route route) {
		data.update(route.transform());
	}

	public double getTotalTax() {
		List<Route> routes = getAllRoutes();
		List<Fuel> fuel = getAllFuel();

		double taxrate = getTaxes();

		return tax.getTotalTax(fuel, routes, taxrate);

	}

	public double getTaxBetween(String dateFrom, String dateTo) {

		Fuel fuel = new Fuel(dateFrom, dateTo);
		Route route = new Route(dateFrom, dateTo);

		List<DataTransferObject> routeDto = data.find(route.transform());
		List<DataTransferObject> fuelDto = data.find(fuel.transform());

		List<Route> routes = new ArrayList<>();
		List<Fuel> fuels = new ArrayList<>();

		for (DataTransferObject dto : routeDto) {

			routes.add(new Route(dto));
		}
		for (DataTransferObject dto : fuelDto) {

			fuels.add(new Fuel(dto));
		}

		double taxrate = getTaxes();

		return tax.getTotalTax(fuels, routes, taxrate);
	}

	public User getUser() {
		return aUser;
	}

	public HashMap<Integer, Fuel> fuelToHashMap(List<Fuel> fuels) {

		HashMap<Integer, Fuel> hashFuel = new HashMap<>();

		for (Fuel fuel: fuels) {
			hashFuel.put(fuel.getId(), fuel);
		}

		return hashFuel;
	}
	
	public HashMap<Integer, Route> routeToHashMap(List<Route> routes) {

		HashMap<Integer, Route> hashRoutes = new HashMap<>();

		for (Route route: routes) {
			hashRoutes.put(route.getId(), route);
		}

		return hashRoutes;
	}

}

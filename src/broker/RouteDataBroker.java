package broker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import data.FuelData;
import data.RouteData;
import data.TaxesData;
import data.UserData;
import datatransferobject.DataTransferObject;

public class RouteDataBroker extends Broker {

	@Override
	public List<DataTransferObject> find(DataTransferObject data) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insert(DataTransferObject data) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());

		try {
			Connection conn = super.getDBConnection();
			PreparedStatement insertRoutes = conn.prepareStatement(
					"INSERT INTO routes(start, end, distance, emission, username, date, vehicle) VALUES(?,?,?,?,?,?,?)");

			insertRoutes.setString(1, ((RouteData) data).getStart());
			insertRoutes.setString(2, ((RouteData) data).getEnd());
			insertRoutes.setDouble(3, ((RouteData) data).getDistance());
			insertRoutes.setDouble(4, ((RouteData) data).getEmission());
			insertRoutes.setString(5, ((RouteData) data).getUser());
			insertRoutes.setDate(6, sqlDate);
			insertRoutes.setString(7, ((RouteData) data).getVehicle());
			System.out.println(((RouteData) data).getVehicle());

			insertRoutes.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<DataTransferObject> findAll() {

		List<DataTransferObject> routes = new ArrayList<>();

		try {
			Connection conn = super.getDBConnection();

			PreparedStatement selectRoutes = conn.prepareStatement("SELECT * FROM routes");

			ResultSet rst;
			rst = selectRoutes.executeQuery();

			while (rst.next()) {
				routes.add(new RouteData(rst.getString("start"), rst.getString("end"), rst.getDouble("distance"),
						rst.getDouble("emission"), rst.getString("username"), rst.getInt("route_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return routes;
	}

	@Override
	public void update(DataTransferObject data) {
		Connection conn = super.getDBConnection();
		try {
			PreparedStatement updateRoutes = conn.prepareStatement(
					"UPDATE routes SET start = ?, end = ?, distance = ?, emission = ?, username =? WHERE route_id = ?");
			updateRoutes.setString(1, ((RouteData) data).getStart());
			updateRoutes.setString(2, ((RouteData) data).getEnd());
			updateRoutes.setDouble(3, ((RouteData) data).getDistance());
			updateRoutes.setDouble(4, ((RouteData) data).getEmission());
			updateRoutes.setString(5, ((RouteData) data).getUser());
			updateRoutes.setInt(6, ((RouteData) data).getId());

			updateRoutes.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void delete(DataTransferObject data) {
		Connection conn = super.getDBConnection();
		try {
			PreparedStatement deleteRoute = conn.prepareStatement("DELETE from routes WHERE route_id = ?");

			deleteRoute.setInt(1, ((RouteData) data).getId());
			deleteRoute.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}

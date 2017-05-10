package broker;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import data.RouteData;
import data.UserData;
import datatransferobject.DataTransferObject;

public class RouteDataBroker extends Broker {

	@Override
	public List<DataTransferObject> find(UserData data) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insert(RouteData data) {

		try {
			Connection conn = super.getDBConnection();
			Statement stm;
			stm = conn.createStatement();

			String sql = "INSERT INTO routes (start, end, distance, emission, username) VALUES (\"" + data.getStart()
					+ "\"," + " " + "\"" + data.getEnd() + "\"," + " " + data.getDistance() + ", " + data.getEmission()
					+ ", " + "\"" + data.getUser() + "\"" + ")";
			System.out.println(sql);

			stm.execute(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<DataTransferObject> findAll(RouteData data) {

		List<DataTransferObject> routes = new ArrayList<>();

		try {
			Connection conn = super.getDBConnection();
			Statement stm;
			stm = conn.createStatement();

			String sql = "Select * From routes";
			ResultSet rst;
			rst = stm.executeQuery(sql);
			while (rst.next()) {
				routes.add(new RouteData(rst.getString("start"), rst.getString("end"), rst.getDouble("distance"), rst.getDouble("emission"), rst.getString("user")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return routes;
	}

}

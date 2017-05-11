package broker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			PreparedStatement insertRoutes = conn
					.prepareStatement("INSERT INTO routes(start, end, distance, emission, username) VALUES(?,?,?,?,?)");

			insertRoutes.setString(1, data.getStart());
			insertRoutes.setString(2, data.getEnd());
			insertRoutes.setDouble(3, data.getDistance());
			insertRoutes.setDouble(4, data.getEmission());
			insertRoutes.setString(5, data.getUser());

			insertRoutes.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<DataTransferObject> findAll(RouteData data) {

		List<DataTransferObject> routes = new ArrayList<>();

		try {
			Connection conn = super.getDBConnection();

			PreparedStatement selectRoutes = conn.prepareStatement("SELECT * FROM routes");

			ResultSet rst;
			rst = selectRoutes.executeQuery();

			while (rst.next()) {
				routes.add(new RouteData(rst.getString("start"), rst.getString("end"), rst.getDouble("distance"),
						rst.getDouble("emission"), rst.getString("user")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return routes;
	}

}

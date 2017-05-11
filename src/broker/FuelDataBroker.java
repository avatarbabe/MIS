package broker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.FuelData;
import data.UserData;
import datatransferobject.DataTransferObject;

public class FuelDataBroker extends Broker {

	@Override
	public List<DataTransferObject> find(UserData data) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DataTransferObject> findAll(FuelData data) {

		List<DataTransferObject> fuel = new ArrayList<>();
		
		try {
			Connection conn = super.getDBConnection();

			PreparedStatement selectFuel = conn.prepareStatement("SELECT * FROM fuel");

			ResultSet rst;
			rst = selectFuel.executeQuery();

			while (rst.next()) {
				fuel.add(new FuelData(rst.getDouble("volume"), rst.getString("fueltype"), rst.getDouble("emission"),
						rst.getString("user")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fuel;

	}

	public void insert(FuelData data) {

		try {
			Connection conn = super.getDBConnection();
			PreparedStatement insertFuel = conn
					.prepareStatement("INSERT INTO fuel(volume, fueltype emission, user) VALUES(?,?,?,?)");

			insertFuel.setDouble(1, data.getVolume());
			insertFuel.setString(2, data.getFuelType());
			insertFuel.setDouble(3, data.getEmission());
			insertFuel.setString(4, data.getUser());

			insertFuel.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

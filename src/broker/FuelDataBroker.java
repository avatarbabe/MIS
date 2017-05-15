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

	public List<DataTransferObject> findAll() {

		List<DataTransferObject> fuel = new ArrayList<>();
		
		try {
			Connection conn = super.getDBConnection();

			PreparedStatement selectFuel = conn.prepareStatement("SELECT * FROM fuel");

			ResultSet rst;
			rst = selectFuel.executeQuery();

			while (rst.next()) {
				fuel.add(new FuelData(rst.getDouble("volume"), rst.getString("fueltype"), rst.getDouble("emission"),
						rst.getString("username")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fuel;

	}

	public void insert(DataTransferObject data) {

		try {
			Connection conn = super.getDBConnection();
			PreparedStatement insertFuel = conn.prepareStatement("INSERT INTO fuel(volume, fueltype, emission, username) VALUES(?,?,?,?)");

			insertFuel.setDouble(1, ((FuelData) data).getVolume());
			insertFuel.setString(2, ((FuelData) data).getFuelType());
			insertFuel.setDouble(3, ((FuelData) data).getEmission());
			insertFuel.setString(4, ((FuelData) data).getUser());
			insertFuel.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(DataTransferObject data) {
		// TODO Auto-generated method stub
		
	}
}

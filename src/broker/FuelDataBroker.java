package broker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import data.FuelData;
import data.RouteData;
import data.UserData;
import datatransferobject.DataTransferObject;

public class FuelDataBroker extends Broker {

	@Override
	public List<DataTransferObject> find(UserData data) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insert(FuelData data) {

		try {
			Connection conn = super.getDBConnection();
			PreparedStatement insertFuel = conn.prepareStatement("INSERT INTO fuel(volume, emissionrate, emission) VALUES(?,?,?)");
			
			insertFuel.setDouble(1, data.getVolume());
			insertFuel.setDouble(2, data.getEmissionRate());
			insertFuel.setDouble(3, data.getEmission());

			insertFuel.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

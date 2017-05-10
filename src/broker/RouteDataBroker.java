package broker;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
	
	public void insert(RouteData data){
		
		try {
			Connection conn = super.getDBConnection();
			Statement stm;
			stm = conn.createStatement();
			
			String sql = "INSERT INTO routes (start, end, distance, emission, username) VALUES (" + data.getStart() + " " + data.getEnd() + " " + data.getDistance() + " " + data.getEmission() + ")";
			System.out.println(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

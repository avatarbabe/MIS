package broker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import data.TaxesData;
import data.UserData;
import datatransferobject.DataTransferObject;

public class TaxesDataBroker extends Broker {

	@Override
	public List<DataTransferObject> find(UserData data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(DataTransferObject data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DataTransferObject> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void update(DataTransferObject data){
		Connection conn = super.getDBConnection();
		try {
			PreparedStatement updateTaxes = conn
					.prepareStatement("UPDATE taxes SET taxrate = ? WHERE tax_id = 1");
			updateTaxes.setDouble(1, ((TaxesData) data).getTaxRate());
			updateTaxes.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}

package broker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.TaxesData;
import data.UserData;
import datatransferobject.DataTransferObject;

public class TaxesDataBroker extends Broker {

	@Override
	public List<DataTransferObject> find(DataTransferObject data) {
		
		List<DataTransferObject> taxes = new ArrayList<>();

		try {
			Connection conn = super.getDBConnection();

			PreparedStatement selectTaxes = conn
					.prepareStatement("SELECT * FROM taxes WHERE tax_id = ?");

			selectTaxes.setDouble(1, 1);

			ResultSet rst;
			rst = selectTaxes.executeQuery();

			while (rst.next()) {
				taxes.add(new TaxesData(rst.getDouble("taxrate")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return taxes;
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

	public void update(DataTransferObject data) {
		Connection conn = super.getDBConnection();
		try {
			PreparedStatement updateTaxes = conn.prepareStatement("UPDATE taxes SET taxrate = ? WHERE tax_id = ?");
			updateTaxes.setDouble(1, ((TaxesData) data).getTaxRate());
			updateTaxes.setInt(2, 1);
			updateTaxes.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public void selectBetween (DataTransferObject data) {
		Connection conn = super.getDBConnection();
		try {
			PreparedStatement selectTaxesBetween = conn.prepareStatement(
					"SELECT emission FROM taxes WHERE date BETWEEN ? AND ?");
			selectTaxesBetween.setString(1, ((TaxesData) data).getDateFrom());
			selectTaxesBetween.setString(2, ((TaxesData) data).getDateTo());
			selectTaxesBetween.executeQuery();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}

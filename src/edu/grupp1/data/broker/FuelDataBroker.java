package edu.grupp1.data.broker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import edu.grupp1.data.datatransferobject.DataTransferObject;
import edu.grupp1.data.dto.FuelData;
import edu.grupp1.data.dto.RouteData;
import edu.grupp1.data.dto.TaxesData;
import edu.grupp1.data.dto.UserData;

public class FuelDataBroker extends Broker {

	private HashMap<Integer, DataTransferObject> cache = new HashMap<>();

	@Override
	public List<DataTransferObject> findInStorage(DataTransferObject data) {
		Connection conn = super.getDBConnection();

		List<DataTransferObject> fuel = new ArrayList<>();

		if (cache.containsKey(data.getId())) {

			fuel.add(cache.get(data.getId()));
			System.out.println("aba");
			return fuel;
		}

		try {
			PreparedStatement selectBetween = conn.prepareStatement("SELECT * FROM fuel WHERE date BETWEEN ? AND ?");
			selectBetween.setString(1, ((FuelData) data).getDateFrom());
			selectBetween.setString(2, ((FuelData) data).getDateTo());

			ResultSet rst;
			rst = selectBetween.executeQuery();

			while (rst.next()) {

				DataTransferObject dto = new FuelData(rst.getDouble("volume"), rst.getString("fueltype"),
						rst.getDouble("emission"), rst.getString("username"), rst.getInt("fuel_id"));

				fuel.add(dto);
				cache.put(dto.getId(), dto);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return fuel;
	}

	public List<DataTransferObject> findAll() {

		List<DataTransferObject> fuel = new ArrayList<>();

		try {
			Connection conn = super.getDBConnection();

			PreparedStatement selectFuel = conn.prepareStatement("SELECT * FROM fuel");

			ResultSet rst;
			rst = selectFuel.executeQuery();

			while (rst.next()) {
				
				DataTransferObject dto = new FuelData(rst.getDouble("volume"), rst.getString("fueltype"),
						rst.getDouble("emission"), rst.getString("username"), rst.getInt("fuel_id"));

				fuel.add(dto);
				cache.put(dto.getId(), dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fuel;

	}

	public void insert(DataTransferObject data) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());

		try {
			Connection conn = super.getDBConnection();
			PreparedStatement insertFuel = conn
					.prepareStatement("INSERT INTO fuel(volume, fueltype, emission, username, date) VALUES(?,?,?,?,?)");

			insertFuel.setDouble(1, ((FuelData) data).getVolume());
			insertFuel.setString(2, ((FuelData) data).getFuelType());
			insertFuel.setDouble(3, ((FuelData) data).getEmission());
			insertFuel.setString(4, ((FuelData) data).getUser());
			insertFuel.setDate(5, sqlDate);
			insertFuel.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(DataTransferObject data) {
		Connection conn = super.getDBConnection();
		try {
			PreparedStatement updateFuel = conn.prepareStatement(
					"UPDATE fuel SET volume = ?, fueltype = ?, emission = ?, username = ? WHERE fuel_id = ?");
			updateFuel.setDouble(1, ((FuelData) data).getVolume());
			updateFuel.setString(2, ((FuelData) data).getFuelType());
			updateFuel.setDouble(3, ((FuelData) data).getEmission());
			updateFuel.setString(4, ((FuelData) data).getUser());
			updateFuel.setInt(5, ((FuelData) data).getId());
			updateFuel.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void delete(DataTransferObject data) {
		Connection conn = super.getDBConnection();
		try {
			PreparedStatement deleteFuel = conn.prepareStatement("DELETE from fuel WHERE fuel_id = ?");

			deleteFuel.setInt(1, ((FuelData) data).getId());
			deleteFuel.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}

package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.BrigadeChief;
import Model.Policeman;
import Model.Vehicle;

public class VehicleDAO implements DAO<Vehicle> {

	@Override
	public boolean insert(Vehicle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Vehicle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public int update(Vehicle obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vehicle find(int id) {
		Vehicle vehicle = null;
		
		Connection conn=ConnectionDatabase.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Vehicle  WHERE vehicle_id =?");
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				String type = resultSet.getString("vehicle_type");
				vehicle = new Vehicle(type,id);				
			
				return vehicle;
			}
	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				
				conn.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return vehicle;
	}

	@Override
	public ArrayList<Vehicle> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

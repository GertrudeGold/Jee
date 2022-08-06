package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Plate;
import Model.Vehicle;

public class PlateDAO implements DAO<Plate>{

	@Override
	public boolean insert(Plate obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Plate obj) {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public int update(Plate obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Plate find(int id) {
		Plate plate = null;
		
		Connection conn=ConnectionDatabase.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Plate  WHERE plate_id =?");
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				String placenumber = resultSet.getString("plate_number");
				plate = new Plate(id,placenumber);				
			
				return plate;
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
		return plate;
	}

	@Override
	public ArrayList<Plate> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}

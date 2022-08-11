package DAO;

import java.sql.CallableStatement;
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
		Connection conn=ConnectionDatabase.getConnection();
		boolean success=false;
		CallableStatement callableStatement = null;
		try {
			String sql="{call insert_vehicle(?)}";
			callableStatement = conn.prepareCall(sql);
			
			callableStatement.setString(1, obj.getType());
			
			

			callableStatement.executeUpdate();
			success = true;
			return success;
		}
		catch(SQLException e) {
			System.out.println("Erreur SQL insert vehicleDAO " + e.getMessage() + e.toString() );
			return success;
		}
		finally {
			try {
				if(callableStatement!=null) {
					callableStatement.close();
				}	
				conn.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public boolean delete(Vehicle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public boolean update(Vehicle obj) {
		Connection conn=ConnectionDatabase.getConnection();
		boolean success=false;
		CallableStatement callableStatement = null;
		try {
			String sql="{call update_vehicle(?,?)}";
			callableStatement = conn.prepareCall(sql);
			callableStatement.setInt(1, obj.getId());
			callableStatement.setString(2, obj.getType());
			
			

			callableStatement.executeUpdate();
			success = true;
			return success;
		}
		catch(SQLException e) {
			System.out.println("Erreur SQL update vehicleDAO " + e.getMessage() + e.toString() );
			return success;
		}
		finally {
			try {
				if(callableStatement!=null) {
					callableStatement.close();
				}	
				conn.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
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
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		
		Connection conn=ConnectionDatabase.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Vehicle ");
			
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				String type = resultSet.getString("vehicle_type");
				int id = resultSet.getInt("vehicle_id");
				Vehicle vehicle = new Vehicle(type,id);				
			
				vehicles.add(vehicle);
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
		return vehicles;
	}

	@Override
	public boolean delete(int id) {
		Connection conn=ConnectionDatabase.getConnection();
		boolean success=false;
		CallableStatement callableStatement = null;
		try {
			String sql="{call delete_vehicle(?)}";
			callableStatement = conn.prepareCall(sql);
			callableStatement.setInt(1, id);
			callableStatement.executeUpdate();
			success = true;
			return success;
		}
		catch(SQLException e) {
			System.out.println("Erreur SQL delete vehicleDAO " + e.getMessage() + e.toString() );
			return success;
		}
		finally {
			try {
				if(callableStatement!=null) {
					callableStatement.close();
				}	
				conn.close();
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}

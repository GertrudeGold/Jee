package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Administrator;






public class AdministratorDAO implements DAO<Administrator> {

	@Override
	public boolean insert(Administrator obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Administrator obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int update(Administrator obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Administrator find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Administrator> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
//	public  boolean login(int matricule,String password) {
//		Connection conn=DatabaseConnection.getConnection();
//		try {
//			PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Administrator WHERE =?");
//			preparedStatement.setInt(1, matricule);
//			ResultSet resultSet=preparedStatement.executeQuery();
//			if(resultSet.next()) {
//				if(password.equals(resultSet.getString("worker_password"))) {
//					return true;
//				}
//			}
//	
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		finally {
//			try {
//				
//				conn.close();
//			}catch (SQLException e) {
//				System.out.println(e.getMessage());
//			}
//		}
//		return false;
//	}
	
	
	
}

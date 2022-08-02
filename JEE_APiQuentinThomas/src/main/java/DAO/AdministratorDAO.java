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
	public  Administrator login(String matricule,String password) {
		Administrator administrator = null;
		Connection conn=ConnectionDatabase.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement("select * from (Staff s inner join Administrator a on s.staff_id = a.staff_id) where s.staff_matricule=? and s.staff_password= ?;");
			preparedStatement.setString(1, matricule);
			preparedStatement.setString(2, password);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				String name =  resultSet.getString("staff_lastname");
				String firstname= resultSet.getString("staff_lastname");
				int id= resultSet.getInt("staff_id");								
				administrator = new Administrator(name,firstname,matricule,id);				
				return administrator;
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
		return null;
	}
	
	
	
}

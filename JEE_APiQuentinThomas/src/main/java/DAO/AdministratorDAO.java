package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;

import Model.Administrator;






public class AdministratorDAO implements DAO<Administrator> {

	@Override
	public boolean insert(Administrator obj) {
		Connection conn=ConnectionDatabase.getConnection();
		boolean success=false;
		CallableStatement callableStatement = null;
		try {
			String sql="{call insert_staff(?,?,?,?,?)}";
			callableStatement = conn.prepareCall(sql);
			callableStatement.setString(1, obj.getFirstname());
			callableStatement.setString(2, obj.getLastname());
			callableStatement.setString(3, obj.getMatricule());
			callableStatement.setString(4, obj.getPassword());
			callableStatement.registerOutParameter(5, java.sql.Types.NUMERIC);
			callableStatement.executeUpdate();
			success = true;
			return success;
		}
		catch(SQLException e) {
			System.out.println("Erreur SQL update brigadechiefDAO " + e.getMessage() + e.toString() );
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
	public boolean delete(Administrator obj) {
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
			PreparedStatement preparedStatement = conn.prepareStatement("select * from (Staff s inner join Administrator a on s.staff_id = a.staff_id) where s.staff_matricule=? and s.staff_password= ?");
			preparedStatement.setString(1, matricule);
			preparedStatement.setString(2, password);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				String name =  resultSet.getString("staff_lastname");
				String firstname= resultSet.getString("staff_firstname");
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
		return administrator;
	}
	
	
	
}

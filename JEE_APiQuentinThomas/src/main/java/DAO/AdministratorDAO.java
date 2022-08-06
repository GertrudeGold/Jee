package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;

import Model.Administrator;
import Model.BrigadeChief;
import Model.Collector;
import Model.Policeman;
import Model.Vehicle;
import Model.Violation;






public class AdministratorDAO implements DAO<Administrator> {

	@Override
	public boolean insert(Administrator obj) {
		Connection conn=ConnectionDatabase.getConnection();
		boolean success=false;
		CallableStatement callableStatement = null;
		try {
			String sql="{call insert_staff(?,?,?,?)}";
			callableStatement = conn.prepareCall(sql);
			callableStatement.setString(1, obj.getFirstname());
			callableStatement.setString(2, obj.getLastname());
			callableStatement.setString(3, obj.getMatricule());
			callableStatement.setString(4, obj.getPassword());
//			callableStatement.registerOutParameter(5, java.sql.Types.NUMERIC);
			callableStatement.executeUpdate();
			success = true;
			return success;
		}
		catch(SQLException e) {
			System.out.println("Erreur SQL insert administrateurDAO " + e.getMessage() + e.toString() );
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
	public boolean update(Administrator obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Administrator find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Administrator> findAll() {
		ArrayList<Administrator> administrators = new ArrayList<Administrator>();
		Connection conn=ConnectionDatabase.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement("select * from (Staff s inner join Administrator a on s.staff_id = a.staff_id)");
			
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				String name =  resultSet.getString("staff_lastname");
				String firstname= resultSet.getString("staff_firstname");
				String matricule= resultSet.getString("staff_matricule");
				int id= resultSet.getInt("staff_id");				
				
				Administrator administrator = new Administrator(name,firstname,matricule,id);				
				administrators.add(administrator);
				
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
		return administrators;
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
				ArrayList<Policeman> policemans = new ArrayList<Policeman>();
				ArrayList<Collector> collectors = new ArrayList<Collector>();
				ArrayList<BrigadeChief> brigadeChiefs = new ArrayList<BrigadeChief>();
				ArrayList<Administrator> administrators = new ArrayList<Administrator>();
				ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
				ArrayList<Violation> violations = new ArrayList<Violation>();
				policemans= Policeman.findAll();
				collectors = Collector.findAll();
				brigadeChiefs =BrigadeChief.findAll();
				administrators = Administrator.findAll();
				vehicles = Vehicle.findAll();
				violations = Violation.findAll();
				administrator = new Administrator(name,firstname,matricule,id,policemans,collectors,brigadeChiefs,administrators,vehicles,violations);				
			
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

	@Override
	public boolean delete(int id) {
		Connection conn=ConnectionDatabase.getConnection();
		boolean success=false;
		CallableStatement callableStatement = null;
		try {
			String sql="{call delete_staff(?)}";
			callableStatement = conn.prepareCall(sql);
			callableStatement.setInt(1, id);
			callableStatement.executeUpdate();
			success = true;
			return success;
		}
		catch(SQLException e) {
			System.out.println("Erreur SQL delete administratorDAO " + e.getMessage() + e.toString() );
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

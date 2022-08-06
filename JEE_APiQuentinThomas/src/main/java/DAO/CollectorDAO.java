package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.BrigadeChief;
import Model.Collector;
import Model.Fine;

public class CollectorDAO implements DAO<Collector>{

	@Override
	public boolean insert(Collector obj) {
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
			System.out.println("Erreur SQL insert brigadechiefDAO " + e.getMessage() + e.toString() );
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
	public boolean delete(Collector obj) {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public boolean update(Collector obj) {
		Connection conn=ConnectionDatabase.getConnection();
		boolean success=false;
		CallableStatement callableStatement = null;
		try {
			String sql="{call update_staff(?,?,?,?)}";
			callableStatement = conn.prepareCall(sql);
			callableStatement.setString(1, obj.getFirstname());
			callableStatement.setString(2, obj.getLastname());
			callableStatement.setString(3, obj.getMatricule());
			callableStatement.setString(4, obj.getPassword());

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
		}	}

	@Override
	public Collector find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Collector> findAll() {
		ArrayList<Collector> collectors = new ArrayList<Collector>();
		Connection conn=ConnectionDatabase.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM( Staff s inner join BrigadeChief b on s.staff_id=b.staff_id) ");
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				String name =  resultSet.getString("staff_lastname");
				String firstname= resultSet.getString("staff_firstname");
				String matricule= resultSet.getString("staff_matricule");
				int id= resultSet.getInt("staff_id");	
				ArrayList<Fine> fines = new ArrayList<Fine>();
				fines=Fine.Findall();
				Collector collector = new Collector(name,firstname,matricule,id,fines);			
				collectors.add(collector);
				
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
		return collectors;
	}
	public  Collector login(String matricule,String password) {
		Collector collector = null;
		Connection conn=ConnectionDatabase.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM( Staff s inner join BrigadeChief b on s.staff_id=b.staff_id)  where staff_matricule =? and staff_password=?");
			preparedStatement.setString(1, matricule);
			preparedStatement.setString(2, password);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				String name =  resultSet.getString("staff_lastname");
				String firstname= resultSet.getString("staff_firstname");
				int id= resultSet.getInt("staff_id");	
				ArrayList<Fine> fines = new ArrayList<Fine>();
				fines=Fine.Findall();
				collector = new Collector(name,firstname,matricule,id,fines);			
				
				return collector;
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
		return collector;
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
			System.out.println("Erreur SQL delete collectorDAO " + e.getMessage() + e.toString() );
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

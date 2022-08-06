package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.BrigadeChief;
import Model.Collector;
import Model.Policeman;

public class PolicemanDAO implements DAO<Policeman>{

	@Override
	public boolean insert(Policeman obj) {
		Connection conn=ConnectionDatabase.getConnection();
		boolean success=false;
		int createdId=0;
		CallableStatement callableStatement = null;
		try {
			String sql="{call insert_staff(?,?,?,?,?)}";
			callableStatement = conn.prepareCall(sql);
			callableStatement.setString(1, obj.getFirstname());
			callableStatement.setString(2, obj.getLastname());
			callableStatement.setString(3, obj.getMatricule());
			callableStatement.setString(4, obj.getPassword());
			callableStatement.setInt(5, obj.getBrigadeChief().getId());
//			callableStatement.registerOutParameter(6, java.sql.Types.NUMERIC);
			callableStatement.executeUpdate();
//			createdId = callableStatement.getInt(6);
			
			success = true;
			
		
			return success;
		}
		catch(SQLException e) {
			System.out.println("Erreur SQL insert policemanDAO " + e.getMessage() + e.toString() );
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
	public boolean delete(Policeman obj) {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public boolean update(Policeman obj) {
		Connection conn=ConnectionDatabase.getConnection();
		boolean success=false;
		int createdId=0;
		CallableStatement callableStatement = null;
		try {
			String sql="{call update_staff(?,?,?,?,?)}";
			callableStatement = conn.prepareCall(sql);
			callableStatement.setString(1, obj.getFirstname());
			callableStatement.setString(2, obj.getLastname());
			callableStatement.setString(3, obj.getMatricule());
			callableStatement.setString(4, obj.getPassword());
			callableStatement.setInt(5, obj.getBrigadeChief().getId());
			callableStatement.executeUpdate();

			
			success = true;
			
		
			return success;
		}
		catch(SQLException e) {
			System.out.println("Erreur SQL update policemanDAO " + e.getMessage() + e.toString() );
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
	public Policeman find(int id) {
		Policeman policeman = null;
		
		Connection conn=ConnectionDatabase.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM( Staff s inner join Policeman p on s.staff_id = p.staff_id)WHERE p.staff_id =?");
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				String name =  resultSet.getString("staff_lastname");
				String firstname= resultSet.getString("staff_firstname");
				String matricule= resultSet.getString("staff_matricule");
				id= resultSet.getInt("staff_id");
				int	idchief = resultSet.getInt("chief_id");
				BrigadeChief brigadechief= new BrigadeChief();
				brigadechief = brigadechief.find(idchief);
				policeman = new Policeman(name,firstname,matricule,id,brigadechief);				
			
				return policeman;
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
		return policeman;
	}

	@Override
	public ArrayList<Policeman> findAll() {
ArrayList<Policeman> policemans = new ArrayList();
		
		Connection conn=ConnectionDatabase.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM( Staff s inner join Policeman p on s.staff_id = p.staff_id)");
			
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				String name =  resultSet.getString("staff_lastname");
				String firstname= resultSet.getString("staff_firstname");
				String matricule= resultSet.getString("staff_matricule");
				int idpoliceman= resultSet.getInt("staff_id");
				int	idchief = resultSet.getInt("chief_id");
				BrigadeChief brigadechief= new BrigadeChief();
				brigadechief = brigadechief.findBrigadeChiefToAPoliceman(idchief);
				Policeman policeman = new Policeman(name,firstname,matricule,idpoliceman);				
				policemans.add(policeman);
				
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
		return policemans;
	}
	public  Policeman login(String matricule,String password) {
		Policeman policeman = null;
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
				policeman = new Policeman(name,firstname,matricule,id);				
			
				return policeman;
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
		return policeman;
	}
	public ArrayList<Policeman> findPolicemanToAChief (int id) {
		ArrayList<Policeman> policemans = new ArrayList();
		
		Connection conn=ConnectionDatabase.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM( Staff s inner join Policeman p on s.staff_id = p.staff_id)WHERE p.chief_id =?");
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				String name =  resultSet.getString("staff_lastname");
				String firstname= resultSet.getString("staff_firstname");
				String matricule= resultSet.getString("staff_matricule");
				int idpoliceman= resultSet.getInt("staff_id");
				//int	idchief = resultSet.getInt("chief_id");
				//BrigadeChief brigadechief= new BrigadeChief();
				//brigadechief = brigadechief.find(idchief);
				Policeman policeman = new Policeman(name,firstname,matricule,idpoliceman);				
				policemans.add(policeman);
				
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
		return policemans;
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
			System.out.println("Erreur SQL delete policemanDAO " + e.getMessage() + e.toString() );
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

package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import Model.Fine;
import Model.Plate;
import Model.Policeman;
import Model.Vehicle;
import Model.Violation;

public class ViolationDAO implements DAO<Violation>{

	@Override
	public boolean insert(Violation obj) {
		Connection conn=ConnectionDatabase.getConnection();
		boolean success=false;
		CallableStatement callableStatement = null;
		try {
			String sql="{call insert_violation(?,?)}";
			callableStatement = conn.prepareCall(sql);
			callableStatement.setString(1, obj.getType());
			callableStatement.setDouble(2, obj.getPrice());
			

			callableStatement.executeUpdate();
			success = true;
			return success;
		}
		catch(SQLException e) {
			System.out.println("Erreur SQL insert violationDAO " + e.getMessage() + e.toString() );
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
	public boolean delete(Violation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public boolean update(Violation obj) {
		Connection conn=ConnectionDatabase.getConnection();
		boolean success=false;
		CallableStatement callableStatement = null;
		try {
			String sql="{call update_violation(?,?,?)}";
			callableStatement = conn.prepareCall(sql);
			callableStatement.setInt(1, obj.getId());
			callableStatement.setString(2, obj.getType());
			callableStatement.setDouble(3, obj.getPrice());
			

			callableStatement.executeUpdate();
			success = true;
			return success;
		}
		catch(SQLException e) {
			System.out.println("Erreur SQL update violationDAO " + e.getMessage() + e.toString() );
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
	public Violation find(int id) {
    Violation violation =null;
		
		
		
		Connection conn=ConnectionDatabase.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement("Select * from violation where violation_id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				int idviolation =  resultSet.getInt("violation_id");
				String type= resultSet.getString("violation_type");
				double amount= resultSet.getDouble("violation_amount");
				
				
				 violation  = new Violation(idviolation,type,amount);				
				 return violation;
				
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
		return violation;
	}

	@Override
	public ArrayList<Violation> findAll() {
		ArrayList<Violation> violations = new ArrayList<Violation>();
		
		
		
		Connection conn=ConnectionDatabase.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement("Select * from violation");
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int idviolation =  resultSet.getInt("violation_id");
				String type= resultSet.getString("violation_type");
				double amount= resultSet.getDouble("violation_amount");
				
				
				Violation violation  = new Violation(idviolation,type,amount);				
				violations.add(violation);
				
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
		return violations;
	}
	
	public ArrayList<Violation> GetViolationsToAFine(int id){
		ArrayList<Violation> violations = new ArrayList<Violation>();
		
		
		
		Connection conn=ConnectionDatabase.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement("Select * from( violation v inner join finedetail fd on v.violation_id= fd.violation_id) where fine_id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int idviolation =  resultSet.getInt("violation_id");
				String type= resultSet.getString("violation_type");
				double amount= resultSet.getDouble("violation_amount");
				
				
				Violation violation  = new Violation(idviolation,type,amount);				
				violations.add(violation);
				
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
		return violations;
	}

	@Override
	public boolean delete(int id) {
		Connection conn=ConnectionDatabase.getConnection();
		boolean success=false;
		CallableStatement callableStatement = null;
		try {
			String sql="{call delete_violation(?)}";
			callableStatement = conn.prepareCall(sql);
			callableStatement.setInt(1, id);
			callableStatement.executeUpdate();
			success = true;
			return success;
		}
		catch(SQLException e) {
			System.out.println("Erreur SQL delete violationDAO " + e.getMessage() + e.toString() );
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

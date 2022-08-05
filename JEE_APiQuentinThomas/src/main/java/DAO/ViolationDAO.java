package DAO;

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Violation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int update(Violation obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Violation find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Violation> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<Violation> GetViolationsToAFine(int id){
		ArrayList<Violation> violations = new ArrayList<Violation>();
		
		
		
		Connection conn=ConnectionDatabase.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement("Select * from violation v inner join finedetail fd on v.violation_id= fd.violation_id where fine_id=?");
			
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
}

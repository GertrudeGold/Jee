package DAO;

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Policeman obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int update(Policeman obj) {
		// TODO Auto-generated method stub
		return 0;
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
		// TODO Auto-generated method stub
		return null;
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
				int	idchief = resultSet.getInt("chief_id");
				BrigadeChief brigadechief= new BrigadeChief();
				brigadechief = brigadechief.find(idchief);
				Policeman policeman = new Policeman(name,firstname,matricule,idpoliceman,brigadechief);				
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
}

package DAO;

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Collector obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int update(Collector obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collector find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Collector> findAll() {
		// TODO Auto-generated method stub
		return null;
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

}

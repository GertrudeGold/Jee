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

public class FineDAO implements DAO<Fine>{

	@Override
	public boolean insert(Fine obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Fine obj) {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public int update(Fine obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Fine find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Fine> findAll() {
		ArrayList<Fine> fines = null;
		
		
		
		Connection conn=ConnectionDatabase.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Fine ");
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Date date =  resultSet.getDate("fine_date");
				String fineguiltylastname= resultSet.getString("fine_guilty_lastname");
				String fineguiltyfirstname= resultSet.getString("fine_guilty_firstname");
				String  finecommentary= resultSet.getString("fine_commentary");
				int id= resultSet.getInt("fine_id");		
				int validation= resultSet.getInt("fine_validation");	
				int policemanid=resultSet.getInt("policeman_id");
				Policeman policeman = new Policeman();
				policeman =	policeman.find(policemanid);
				int vehicleid=resultSet.getInt("vehicle_id");
				Vehicle vehicle = new Vehicle();
				vehicle.find(vehicleid);
				int plateid=resultSet.getInt(" plate_id");
				Plate plate = new Plate();
				plate.find(plateid);
				ArrayList<Violation> violations = new ArrayList();
				violations = Violation.GetViolationsOfAFine(id);
				Fine fine  = new Fine(id,vehicle,plate,date,fineguiltyfirstname,fineguiltylastname,finecommentary,
						policeman,validation,violations);				
				fines.add(fine);
				
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
		return fines;
	}

}

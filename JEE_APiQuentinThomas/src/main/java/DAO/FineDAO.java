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

public class FineDAO implements DAO<Fine>{

	@Override
	public boolean insert(Fine obj) {
		Connection conn=ConnectionDatabase.getConnection();
		boolean success=false;
		CallableStatement callableStatement = null;
		try {
			String sql="{call insert_fine(?,?,?,?,?,?,?,?,?,?)}";
			callableStatement = conn.prepareCall(sql);
			callableStatement.setInt(1, obj.getTypeVehicle().getId());
			callableStatement.setInt(2, obj.getPlate().getId());
			callableStatement.setDate(3, (java.sql.Date) obj.getDate());
			callableStatement.setString(4, obj.getGultyFirstName());
			callableStatement.setString(5, obj.getGultyLastName());
			callableStatement.setString(6, obj.getComment());
			callableStatement.setInt(7, obj.getPoliceman().getId());
			callableStatement.setInt(8, 0);
			String violations ="";
			int cpt=0;
			for(Violation violation : obj.getViolations()) {
				if(cpt!=0) {
					violations+="-";
				}
				cpt++;
				violations+=String.valueOf(violation.getId());
			}
			callableStatement.setString(9,violations);
			

			callableStatement.executeUpdate();
			success = true;
			return success;
		}
		catch(SQLException e) {
			System.out.println("Erreur SQL insert fineDAO " + e.getMessage() + e.toString() );
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
	public boolean delete(Fine obj) {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public boolean update(Fine obj) {
		Connection conn=ConnectionDatabase.getConnection();
		boolean success=false;
		CallableStatement callableStatement = null;
		try {
			String sql="{call update_fine(?,?)}";
			callableStatement = conn.prepareCall(sql);
			callableStatement.setInt(1, obj.getId());
			callableStatement.setInt(2, obj.getValidation());
			
			

			callableStatement.executeUpdate();
			success = true;
			return success;
		}
		catch(SQLException e) {
			System.out.println("Erreur SQL update fineDAO " + e.getMessage() + e.toString() );
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
	public Fine find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Fine> findAll() {
		ArrayList<Fine> fines = new ArrayList<Fine>();
		
		
		
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
				policeman =	policeman.findPolicemanToAFine(policemanid);
				int vehicleid=resultSet.getInt("vehicle_id");
				Vehicle vehicle = new Vehicle();
				vehicle = vehicle.find(vehicleid);
				int plateid=resultSet.getInt("plate_id");
				Plate plate = new Plate();
				plate = plate.find(plateid);
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

	@Override
	public boolean delete(int id) {
		Connection conn=ConnectionDatabase.getConnection();
		boolean success=false;
		CallableStatement callableStatement = null;
		try {
			String sql="{call delete_fine(?)}";
			callableStatement = conn.prepareCall(sql);
			callableStatement.setInt(1, id);
			callableStatement.executeUpdate();
			success = true;
			return success;
		}
		catch(SQLException e) {
			System.out.println("Erreur SQL delete fineDAO " + e.getMessage() + e.toString() );
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

package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Administrator;
import Model.BrigadeChief;
import Model.Fine;
import Model.Policeman;


public class BrigadeChiefDAO implements DAO<BrigadeChief> {

	@Override
	public boolean insert(BrigadeChief obj) {
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
	public boolean delete(BrigadeChief obj) {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public boolean update(BrigadeChief obj) {
		Connection conn=ConnectionDatabase.getConnection();
		boolean success=false;
		CallableStatement callableStatement = null;
		try {
			String sql="{call update_staff(?,?,?,?)}";
			callableStatement = conn.prepareCall(sql);
			callableStatement.setInt(1, obj.getId());
			callableStatement.setString(2, obj.getFirstname());
			callableStatement.setString(3, obj.getLastname());
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
		}
	}

	@Override
	public BrigadeChief find(int id) {
		BrigadeChief brigadeChief = null;
		Connection conn=ConnectionDatabase.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM(Staff s inner join BrigadeChief b on s.staff_id=b.staff_id)where b.chief_id =? ");
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				String name =  resultSet.getString("staff_lastname");
				String firstname= resultSet.getString("staff_firstname");
				String matricule= resultSet.getString("staff_matricule");	
				int chefid= resultSet.getInt("chief_id");	
				ArrayList<Policeman> policemans= new ArrayList<Policeman>();
				policemans = Policeman.findPolicemanToAChief(id);
				ArrayList<Fine> fines = new ArrayList<Fine>();
				fines = Fine.Findall();
				ArrayList<Fine> finesToAdd = new ArrayList<Fine>();
				for(Fine fine : fines) {
                    if(fine.getPoliceman().getBrigadeChief().getChiefid() == chefid && fine.getValidation()==0){
                    	finesToAdd.add(fine);
                    }
                }
				brigadeChief = new BrigadeChief(name,firstname,matricule,id,fines,policemans,chefid);
				
				
				return brigadeChief;
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
		return brigadeChief;
	}
	public BrigadeChief findBrigadeChiefToAPoliceman(int id) {
		BrigadeChief brigadeChief = null;
		Connection conn=ConnectionDatabase.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM(Staff s inner join BrigadeChief b on s.staff_id=b.staff_id)where b.chief_id =? ");
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				String name =  resultSet.getString("staff_lastname");
				String firstname= resultSet.getString("staff_firstname");
				String matricule= resultSet.getString("staff_matricule");		
				int chefid= resultSet.getInt("chief_id");
				
				brigadeChief = new BrigadeChief(name,firstname,matricule,id,chefid);
				
				
				return brigadeChief;
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
		return brigadeChief;
	}
	@Override
	public ArrayList<BrigadeChief> findAll() {
		ArrayList<BrigadeChief> brigadeChiefs = new ArrayList();
		Connection conn=ConnectionDatabase.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Staff s inner join BrigadeChief b on s.staff_id=b.staff_id ");
			
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				String name =  resultSet.getString("staff_lastname");
				String firstname= resultSet.getString("staff_firstname");
				String matricule= resultSet.getString("staff_matricule");
				int id= resultSet.getInt("staff_id");	
				int chefid= resultSet.getInt("chief_id");	
				ArrayList<Policeman> policemans= new ArrayList<Policeman>();
				policemans=Policeman.findPolicemanToAChief(chefid);
				ArrayList<Fine> fines = new ArrayList<Fine>();
				
				fines = Fine.Findall();
				ArrayList<Fine> finesToAdd = new ArrayList<Fine>();
				for(Fine fine : fines) {
                    if(fine.getPoliceman().getBrigadeChief().getChiefid() == chefid && fine.getValidation()==0){
                    	finesToAdd.add(fine);
                    }
                }
				
				BrigadeChief brigadeChief = new BrigadeChief(name,firstname,matricule,id,finesToAdd,policemans,chefid);
				brigadeChiefs.add(brigadeChief);
				
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
		return brigadeChiefs;
	}
	
	public  BrigadeChief login(String matricule,String password) {
		BrigadeChief brigadeChief = null;
		Connection conn=ConnectionDatabase.getConnection();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Staff s inner join BrigadeChief b on s.staff_id=b.staff_id  where staff_matricule =? and staff_password=?");
			preparedStatement.setString(1, matricule);
			preparedStatement.setString(2, password);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				String name =  resultSet.getString("staff_lastname");
				String firstname= resultSet.getString("staff_firstname");
				int id= resultSet.getInt("staff_id");	
				int chefid= resultSet.getInt("chief_id");	
				ArrayList<Policeman> policemans= new ArrayList<Policeman>();
				policemans=Policeman.findPolicemanToAChief(chefid);
				ArrayList<Fine> fines = new ArrayList<Fine>();
				fines = Fine.Findall();
				ArrayList<Fine> finesToAdd = new ArrayList<Fine>();
				for(Fine fine : fines) {
                    if(fine.getPoliceman().getBrigadeChief().getChiefid() == chefid && fine.getValidation()==0){
                    	finesToAdd.add(fine);
                    }
                }
				
				brigadeChief = new BrigadeChief(name,firstname,matricule,id,fines,policemans,chefid);
				return brigadeChief;
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
		return brigadeChief;
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
			System.out.println("Erreur SQL delete brigadeChiefDAO " + e.getMessage() + e.toString() );
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

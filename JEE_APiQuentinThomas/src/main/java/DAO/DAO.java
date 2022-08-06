package DAO;

import java.util.ArrayList;




public interface DAO<T> {

	public boolean insert(T obj);
	
	public boolean delete(T obj);
	
	public boolean delete(int id);
	
	public boolean update(T obj);
	
	public T find(int id);
	
	public ArrayList<T> findAll();
	
	
	
	
}
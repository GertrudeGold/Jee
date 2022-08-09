package appli.DAO;

import java.net.URI;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import appli.Javabeans.Fine;

public class FineDAO implements DAO<Fine>{
	private WebResource resource;
	private static  String apiUrl;
	private Client client;
	private static URI getBaseUri() {
		return UriBuilder.fromUri(apiUrl).build();
	}
	
	
	
	@Override
	public boolean insert(Fine obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Fine obj) {
		boolean success = false;
		String key = getApiKey();
				
		ClientResponse res= resource
				.path("fine")
				.path(String.valueOf(obj.getId()))
				.header(key, key)
				.delete(ClientResponse.class);
		int StatusCode=res.getStatus();
		
		if(StatusCode == 204) {
			success=true;
		}
		return success;
	}

	@Override
	public boolean update(Fine obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Fine find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Fine> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

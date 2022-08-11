package appli.DAO;

import java.net.URI;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import appli.Javabeans.Policeman;
import appli.Javabeans.Vehicle;

public class VehicleDAO implements DAO<Vehicle>{
	private WebResource resource;
	private static  String apiUrl;
	private Client client;
	private static URI getBaseUri() {
		return UriBuilder.fromUri(apiUrl).build();
	}
	
	
	
	public VehicleDAO() {
		
		ClientConfig config=new DefaultClientConfig();
		client=Client.create(config);
		apiUrl=getApiUrl();
		resource=client.resource(getBaseUri());
	}
	@Override
	public boolean insert(Vehicle obj) {
		boolean success = false;
		String key = getApiKey();
		MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
		parameters.add("vehicle_type", obj.getType());	
		ClientResponse res= resource
				.path("vehicle")
				.path("create")
				.header("AUTHORIZATION", key)
				.post(ClientResponse.class,parameters);
		int StatusCode=res.getStatus();
		if(StatusCode == 201) {
			success=true;
		}
		return success;
	}

	@Override
	public boolean delete(Vehicle obj) {
		boolean success = false;
		String key = getApiKey();
				
		ClientResponse res= resource
				.path("vehicle")
				.path(String.valueOf(obj.getId()))
				.header("AUTHORIZATION", key)
				.delete(ClientResponse.class);
		int StatusCode=res.getStatus();
		
		if(StatusCode == 204) {
			success=true;
		}
		return success;
	}

	@Override
	public boolean update(Vehicle obj) {
		boolean success = false;
		String key = getApiKey();
		MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
		parameters.add("vehicle_type", obj.getType());
		ClientResponse res= resource
				.path("vehicle")
				.path(String.valueOf(obj.getId()))
				.header("AUTHORIZATION", key)
				.put(ClientResponse.class,parameters);
		int StatusCode=res.getStatus();
		if(StatusCode == 204) {
			success=true;
		}
		return success;
	}

	@Override
	public Vehicle find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Vehicle> findAll() {
		String key=getApiKey();
		String res=resource
				.path("vehicle")
				.path("all")
				.header("key",key)
				.header("AUTHORIZATION", key)
				.get(String.class);
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		

				ObjectMapper mapper=new ObjectMapper();
				try {
					
					vehicles= mapper.readValue(res, new TypeReference<ArrayList<Vehicle>>(){});
				 return vehicles;
				} catch (Exception e) {
					System.out.println(e.getMessage());
					return null;
				}
	}

}

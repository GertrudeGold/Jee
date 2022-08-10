package appli.DAO;

import java.net.URI;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import appli.Javabeans.Fine;
import appli.Javabeans.Violation;

public class FineDAO implements DAO<Fine>{
	private WebResource resource;
	private static  String apiUrl;
	private Client client;
	private static URI getBaseUri() {
		return UriBuilder.fromUri(apiUrl).build();
	}
	
	
	
	@Override
	public boolean insert(Fine obj) {
		boolean success = false;
		String key = getApiKey();
		MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
		String violations ="";
		int cpt=0;
		for(Violation violation : obj.getViolations()) {
			if(cpt!=0) {
				violations+="-";
			}
			cpt++;
			violations+=String.valueOf(violation.getId());
		}
		parameters.add("fine_gultyFirstName", obj.getGultyFirstName());
		parameters.add("fine_gultyLastName", obj.getGultyLastName());
		parameters.add("fine_comment", obj.getComment());
		parameters.add("vehicle_id", String.valueOf(obj.getTypeVehicle().getId()));
		parameters.add("plate_id", String.valueOf(obj.getPlate().getId()));
		parameters.add("fine_date", String.valueOf(obj.getDate()));
		parameters.add("policeman_id", String.valueOf(obj.getPoliceman().getId()));
		parameters.add("violation_ids", violations);
		ClientResponse res= resource
				.path("fine")
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
	public boolean delete(Fine obj) {
		boolean success = false;
		String key = getApiKey();
				
		ClientResponse res= resource
				.path("fine")
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
	public boolean update(Fine obj) {
		boolean success = false;
		String key = getApiKey();
		MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
		
		parameters.add("validation", "1");
		ClientResponse res= resource
				.path("fine")
				.path(String.valueOf(obj.getId()))
				.header("AUTHORIZATION", key)
				.put(ClientResponse.class,parameters);
		int StatusCode=res.getStatus();
		if(StatusCode == 201) {
			success=true;
		}
		return success;
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

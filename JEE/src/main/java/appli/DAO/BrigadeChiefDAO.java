package appli.DAO;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.MediaType;
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

import appli.Javabeans.Administrator;
import appli.Javabeans.BrigadeChief;

public class BrigadeChiefDAO implements DAO<BrigadeChief>{

	private WebResource resource;
	private static  String apiUrl;
	private Client client;
	private static URI getBaseUri() {
		return UriBuilder.fromUri(apiUrl).build();
	}
	
	
	private static void saveApiKey(String apiKey) {
		Context ctx;
		try {
			ctx = new InitialContext();
			Context env = (Context) ctx.lookup("java:comp/env");
			env.addToEnvironment("apiKey", apiKey);
		} catch (NamingException e) {
			System.out.println("Error save api key");
		}
	}
	public BrigadeChiefDAO() {
		
		ClientConfig config=new DefaultClientConfig();
		client=Client.create(config);
		apiUrl=getApiUrl();
		resource=client.resource(getBaseUri());
	}
	@Override
	public boolean insert(BrigadeChief obj) {
		boolean success = false;
		String key = getApiKey();
		MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
		parameters.add("staff_lastname", obj.getLastname());
		parameters.add("staff_firstname", obj.getFirstname());
		parameters.add("staff_matricule", obj.getMatricule());
		parameters.add("staff_password", obj.getPassword());
		ClientResponse res= resource
				.path("brigadeChief")
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
	public boolean delete(BrigadeChief obj) {
		boolean success = false;
		String key = getApiKey();
				
		ClientResponse res= resource
				.path("brigadeChief")
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
	public boolean update(BrigadeChief obj) {
		boolean success = false;
		String key = getApiKey();
		MultivaluedMap<String, String> parameters = new MultivaluedMapImpl();
		parameters.add("staff_lastname", obj.getLastname());
		parameters.add("staff_firstname", obj.getFirstname());
		parameters.add("staff_matricule", obj.getMatricule());
		parameters.add("staff_password", obj.getPassword());
		ClientResponse res= resource
				.path("brigadeChief")
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
	public BrigadeChief find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BrigadeChief> findAll() {
		String key=getApiKey();
		String res=resource
				.path("brigadeChief")
				.path("all")
				.header("key",key)
				.header("AUTHORIZATION", key)
				.get(String.class);
		ArrayList<BrigadeChief> brigadeChiefs = new ArrayList<BrigadeChief>();
		

				ObjectMapper mapper=new ObjectMapper();
				try {
					
					brigadeChiefs= mapper.readValue(res, new TypeReference<ArrayList<BrigadeChief>>(){});
				 return brigadeChiefs;
				} catch (Exception e) {
					System.out.println(e.getMessage());
					return null;
				}
	}
	public BrigadeChief login(String matricule,String password) {
		System.out.println("ici10");
		//String key=getApiKey();
		int status;
		MultivaluedMap<String,String> paramsPost=new MultivaluedMapImpl();
		paramsPost.add("matricule", matricule);
		paramsPost.add("password", password);
		ClientResponse responseJSON=resource
				.path("brigadeChief")
				.path("login")
				.accept(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class,paramsPost);
		
		BrigadeChief brigadeChief=null;
		status = responseJSON.getStatus();
		if(status==200) {
			String response=responseJSON.getEntity(String.class);
			
			MultivaluedMap<String, String> headers;
			headers=responseJSON.getHeaders();
			List<String> apiKey=headers.get("api-key");
			saveApiKey(apiKey.get(0));
	
			ObjectMapper mapper=new ObjectMapper();
			try {
				
				return brigadeChief=(BrigadeChief) mapper.readValue(response, BrigadeChief.class);
			} catch (Exception e) {
				
				return null;
			}
			
		}
		
		
		return null;
	
	}
	public BrigadeChief findBrigadeChiefToAPoliceman(int id) {
		
		String key=getApiKey();
		int status;
		
		String res=resource
				.path("brigadeChief")
				.path(String.valueOf(id))
				.header("AUTHORIZATION", key)
				.accept(MediaType.APPLICATION_JSON)
				.get(String.class);
		
		BrigadeChief brigadeChief=null;
		
		ObjectMapper mapper=new ObjectMapper();
		try {
			
			return brigadeChief = (BrigadeChief) mapper.readValue(res, BrigadeChief.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
		
	
	}
	
}

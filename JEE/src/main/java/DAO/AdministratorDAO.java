package DAO;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import Javabeans.Administrator;






public class AdministratorDAO implements DAO<Administrator> {
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
	public AdministratorDAO() {
		
		ClientConfig config=new DefaultClientConfig();
		client=Client.create(config);
		apiUrl=getApiUrl();
		resource=client.resource(getBaseUri());
	}
	@Override
	public boolean insert(Administrator obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Administrator obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Administrator obj) {
		// TODO Auto-Administrator method stub
		return false;
	}

	@Override
	public Administrator find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Administrator> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

//	public Administrator login(String matricule,String password) {
//		Administrator administrator=null;
//		int status;
//		MultivaluedMap<String,String> paramsPost=new MultivaluedMapImpl();
//		paramsPost.add("matricule", String.valueOf(matricule));
//		paramsPost.add("password", password);
//		ClientResponse res=resource
//				.path("Administrator")
//				.path("login")
//				.accept(MediaType.APPLICATION_JSON)
//				.post(ClientResponse.class,paramsPost)
//				;
//		ObjectMapper mapper=new ObjectMapper();
//		try {
//			return administrator=(Administrator) mapper.readValue(res, Administrator.class);
//			MultivaluedMap<String, String> headers;
//			headers=res.getHeaders();
//			List<String> apiKey=headers.get("api-key");
//			saveApiKey(apiKey.get(0));
//		} catch (Exception e) {
//			return administrator;
//		}
//		
//		return administrator;
//	}
	public Administrator login(String matricule,String password) {
		System.out.println("ici10");
		String key=getApiKey();
		int status;
		MultivaluedMap<String,String> paramsPost=new MultivaluedMapImpl();
		paramsPost.add("matricule", matricule);
		paramsPost.add("password", password);
		ClientResponse responseJSON=resource
				.path("administrator")
				.path("login")
				.accept(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class,paramsPost);
		
		Administrator administrator=null;
		status = responseJSON.getStatus();
		if(status==200) {
			String response=responseJSON.getEntity(String.class);
			
			MultivaluedMap<String, String> headers;
			headers=responseJSON.getHeaders();
			List<String> apiKey=headers.get("api-key");
			saveApiKey(apiKey.get(0));
			System.out.println("ici1");
			ObjectMapper mapper=new ObjectMapper();
			try {
				System.out.println("ici2");
				return administrator=(Administrator) mapper.readValue(response, Administrator.class);
			} catch (Exception e) {
				System.out.println("ici3");
				return null;
			}
			
		}
		
		
		return null;
	
	}
	
}

package appli.DAO;

import java.net.URI;
import java.util.ArrayList;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import appli.Javabeans.BrigadeChief;
import appli.Javabeans.Plate;

public class PlateDAO implements DAO<Plate> {
	private WebResource resource;
	private static  String apiUrl;
	private Client client;
	private static URI getBaseUri() {
		return UriBuilder.fromUri(apiUrl).build();
	}
public PlateDAO() {
		
		ClientConfig config=new DefaultClientConfig();
		client=Client.create(config);
		apiUrl=getApiUrl();
		resource=client.resource(getBaseUri());
	}
	@Override
	public boolean insert(Plate obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Plate obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Plate obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Plate find(int id) {
		return null;
	}

	@Override
	public ArrayList<Plate> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public Plate findIfAPlateExist(String plateinfo) {
		String key=getApiKey();
		int status;
		
		String res=resource
				.path("plate")
				.path(plateinfo)
				.header("AUTHORIZATION", key)
				.accept(MediaType.APPLICATION_JSON)
				.get(String.class);
		
		Plate plate=null;
		
		ObjectMapper mapper=new ObjectMapper();
		try {
			
			return plate = (Plate) mapper.readValue(res, Plate.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}

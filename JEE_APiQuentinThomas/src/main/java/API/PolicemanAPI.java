package API;

import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.HttpHeaders;
import DAO.AdministratorDAO;
import DAO.PolicemanDAO;
import Model.BrigadeChief;
import Model.Collector;
import Model.Policeman;
import Model.Staff;
import Other.Error;

@Path("policeman")
public class PolicemanAPI extends BaseAPI{
	private Error error = null;
	boolean success = false;
	Policeman policeman = null;
	private PolicemanDAO policemanDAO = new PolicemanDAO();
	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createPoliceman(
			@FormParam("staff_lastname") String lastname,
			@FormParam("staff_firstname") String firstname,
			@FormParam("staff_matricule") String matricule,
			@FormParam("staff_password") String password,
			@FormParam("chief_id") String idchief,
			@HeaderParam(HttpHeaders.AUTHORIZATION) String key) 
	{

		String apiKey=getApiKey();
		if(key.equals(apiKey)) {
			 
			BrigadeChief brigadeChief = new BrigadeChief();
			brigadeChief=brigadeChief.find(Integer.valueOf(idchief));
			Policeman policeman = new Policeman(lastname,firstname,matricule,password,brigadeChief);
				
						boolean success = policeman.insert(policeman);
						String responseJSON;
						if(success) {
							String baseURI=getBaseUri();
							responseJSON="{\"success\":\"true\"}";
							return Response
									.status(Status.CREATED)
									.entity(responseJSON)
									.build();
							
						}else {
						return Response.status(Status.SERVICE_UNAVAILABLE).build();
						}
				
					
			}
		else{
			return Response.status(Status.UNAUTHORIZED).build();
		}
				
	}
	
	
	
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(
			@FormParam("matricule") String matricule, 
			@FormParam("password") String password) {
		System.out.println(matricule);
		System.out.println(password);
		
		policeman= (Policeman) Staff.login(matricule, password);
		if(policeman != null) {
	
			String apiKey=getApiKey();
			return Response.status(Status.OK)
					.header("api-key", apiKey)
					.entity(policeman).build();
		}else {
			
			error=Error.USER_AUTHENTICATION_FAILED;
			error.setDescription("Invalid data for the login, verify your matricule and password");
			return Response.status(Status.NO_CONTENT).entity(error.getJSON()).build();
		}
		
	}
	@DELETE
	@Path("{id}")
	public Response delete(
			@PathParam("id") int id, 
			@HeaderParam(HttpHeaders.AUTHORIZATION) String key)
	{
		String apiKey=getApiKey();
		if(key.equals(apiKey)) {
		boolean success= policemanDAO.delete(id);
		if(success) {
			return Response.status(Status.NO_CONTENT).build();
		}else {
			return Response.status(Status.SERVICE_UNAVAILABLE).build();
		}
		}
		else {
			return Response.status(Status.UNAUTHORIZED).build();
		}
		
	}
	@PUT
	@Path("{id}")
	public Response update(@PathParam("id") int id,
			@FormParam("staff_lastname") String lastname,
			@FormParam("staff_firstname") String firstname,
			@FormParam("staff_matricule") String matricule,
			@FormParam("staff_password") String password,
			
		
			@HeaderParam(HttpHeaders.AUTHORIZATION) String key) {
		String apiKey=getApiKey();

		if(key.equals(apiKey)) {
			
			Policeman policeman = new Policeman(lastname,firstname,matricule,password,id);
		boolean success= policeman.update(policeman);
		if(success) {
			return Response.status(Status.NO_CONTENT).build();
		}else {
			return Response.status(Status.SERVICE_UNAVAILABLE).build();
		}
		}else {
			return Response.status(Status.UNAUTHORIZED).build();
		}

	}
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetAll(
			@HeaderParam(HttpHeaders.AUTHORIZATION) String key)
			 {
		
		String apiKey=getApiKey();
		if(key.equals(apiKey)) {
		ArrayList<Policeman> policemans = new ArrayList<Policeman>();
		policemans=Policeman.findAll();
		
			return Response.status(Status.OK).entity(policemans).build();
			
		}else {
			return Response.status(Status.UNAUTHORIZED).build();
		}
		
		}
}

package API;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

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
	public Response createMaintenance(
			@FormParam("staff_lastname") String lastname,
			@FormParam("staff_firstname") String firstname,
			@FormParam("staff_matricule") String matricule,
			@FormParam("staff_password") String password,
			@FormParam("chef_id") String idchief,
			@HeaderParam("key") String key) 
	{

		String apiKey=getApiKey();
		if(key.equals(apiKey)) {
			int idchiefint = Integer.valueOf(idchief);
			BrigadeChief brigadeChief = new BrigadeChief();
			brigadeChief=brigadeChief.find(idchiefint);
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
			System.out.println("ici4");
			error=Error.USER_AUTHENTICATION_FAILED;
			error.setDescription("Invalid data for the login, verify your login and password");
			return Response.status(Status.OK).entity(error.getJSON()).build();
		}
		
	}
	@DELETE
	@Path("{id}")
	public Response delete(
			@PathParam("id") int id, 
			@HeaderParam("key") String key)
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
			@FormParam("chef_id") String idchief,
		
			@HeaderParam("key") String key) {
		String apiKey=getApiKey();

		if(key.equals(apiKey)) {
			int idchiefint = Integer.valueOf(idchief);
			BrigadeChief brigadeChief = new BrigadeChief();
			brigadeChief=brigadeChief.find(idchiefint);
			Policeman policeman = new Policeman(lastname,firstname,matricule,password,brigadeChief);
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
}

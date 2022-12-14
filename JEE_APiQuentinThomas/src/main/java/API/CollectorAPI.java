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
import DAO.BrigadeChiefDAO;
import DAO.CollectorDAO;
import Model.BrigadeChief;
import Model.Collector;
import Model.Staff;
import Other.Error;

@Path("/collector")
public class CollectorAPI  extends BaseAPI{
	private Error error = null;
	boolean success = false;
	Collector collector = null;
	private CollectorDAO collectorDAO = new CollectorDAO();
	
	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCollector(
			@FormParam("staff_lastname") String lastname,
			@FormParam("staff_firstname") String firstname,
			@FormParam("staff_matricule") String matricule,
			@FormParam("staff_password") String password,
			@HeaderParam(HttpHeaders.AUTHORIZATION) String key) 
	{

		String apiKey=getApiKey();
		if(key.equals(apiKey)) {
			Collector collector = new Collector(lastname,firstname,matricule,password);
				
						boolean success = collector.insert(collector);
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
		
		
		collector= (Collector) Staff.login(matricule, password);
		if(collector != null) {
			
			String apiKey=getApiKey();
			return Response.status(Status.OK)
					.header("api-key", apiKey)
					.entity(collector).build();
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
		boolean success= collectorDAO.delete(id);
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
		Collector collector = new Collector(lastname,firstname,matricule,password,id);
		boolean success= collector.update(collector);
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
		ArrayList<Collector> collectors = new ArrayList<Collector>();
		collectors=Collector.findAll();
		
			return Response.status(Status.OK).entity(collectors).build();
			
		}else {
			return Response.status(Status.UNAUTHORIZED).build();
		}
		
		}
}

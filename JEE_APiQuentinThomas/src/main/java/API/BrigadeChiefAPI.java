package API;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.ws.rs.core.HttpHeaders;
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

import DAO.AdministratorDAO;
import DAO.BrigadeChiefDAO;
import Model.Administrator;
import Model.BrigadeChief;
import Model.Staff;
import Other.Error;

@Path("/brigadeChief")
public class BrigadeChiefAPI extends BaseAPI{
	private Error error = null;
	boolean success = false;
	BrigadeChief brigadeChief = null;
	private BrigadeChiefDAO brigadeChiefDAO = new BrigadeChiefDAO();
	
	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createMaintenance(
			@FormParam("staff_lastname") String lastname,
			@FormParam("staff_firstname") String firstname,
			@FormParam("staff_matricule") String matricule,
			@FormParam("staff_password") String password,
			@HeaderParam(HttpHeaders.AUTHORIZATION) String key) 
	{

		String apiKey=getApiKey();
		if(key.equals(apiKey)) {
			BrigadeChief brigadeChief = new BrigadeChief(lastname,firstname,matricule,password);
				
						boolean success = brigadeChief.insert(brigadeChief);
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
	
		brigadeChief= (BrigadeChief) Staff.login(matricule, password);
		if(brigadeChief != null) {
		
			String apiKey=getApiKey();
			return Response.status(Status.OK)
					.header("api-key", apiKey)
					.entity(brigadeChief).build();
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
			@HeaderParam(HttpHeaders.AUTHORIZATION) String key)
	{
		String apiKey=getApiKey();
		if(key.equals(apiKey)) {
		boolean success= brigadeChiefDAO.delete(id);
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
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findBrigadeChiefToAPoliceman(
			@PathParam("id") int id, 
			@HeaderParam(HttpHeaders.AUTHORIZATION) String key)
	{
		String apiKey=getApiKey();
		if(key.equals(apiKey)) {
		boolean success= brigadeChiefDAO.delete(id);
		if(success) {
			BrigadeChief brigadeChief = new BrigadeChief();
			brigadeChief=brigadeChief.findBrigadeChiefToAPoliceman(id);
			return Response.status(Status.OK).entity(brigadeChief).build();
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
		BrigadeChief brigadeChief = new BrigadeChief(lastname,firstname,matricule,password);
		boolean success= brigadeChief.update(brigadeChief);
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

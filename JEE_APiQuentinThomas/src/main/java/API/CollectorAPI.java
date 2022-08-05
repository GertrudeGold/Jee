package API;

import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import Model.BrigadeChief;
import Model.Collector;
import Model.Staff;
import Other.Error;

@Path("/collector")
public class CollectorAPI  extends BaseAPI{
	private Error error = null;
	boolean success = false;
	Collector collector = null;
	
	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createMaintenance(
			@FormParam("staff_lastname") String lastname,
			@FormParam("staff_firstname") String firstname,
			@FormParam("staff_matricule") String matricule,
			@FormParam("staff_password") String password,
			@HeaderParam("key") String key) 
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
		
		collector= (Collector) Staff.login(matricule, password);
		if(collector != null) {
			
			String apiKey=getApiKey();
			return Response.status(Status.OK)
					.header("api-key", apiKey)
					.entity(collector).build();
		}else {
			System.out.println("ici4");
			error=Error.USER_AUTHENTICATION_FAILED;
			error.setDescription("Invalid data for the login, verify your login and password");
			return Response.status(Status.OK).entity(error.getJSON()).build();
		}
		
	}
}

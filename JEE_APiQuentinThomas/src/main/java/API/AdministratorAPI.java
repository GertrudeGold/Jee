package API;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import DAO.AdministratorDAO;
import Model.Administrator;
import Model.BrigadeChief;
import Model.Staff;
import Other.Error;

@Path("/administrator")
public class AdministratorAPI extends BaseAPI{
private AdministratorDAO administratorDAO = new AdministratorDAO();
private Error error = null;
boolean success = false;
Administrator administrator = null;

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
		Administrator administrator = new Administrator(lastname,firstname,matricule,password);
			
					boolean success = administrator.insert(administrator);
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

@GET
@Produces(MediaType.APPLICATION_JSON)
@Path("/bidon")
public Response bidon() {
	String test = "test ";
	return Response.status(Status.OK).entity(test).build();
}


@POST
@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
public Response login(
		@FormParam("matricule") String matricule, 
		@FormParam("password") String password) {
	
	
    administrator= (Administrator) Staff.login(matricule, password);
	if(administrator != null) {

		String apiKey=getApiKey();
		return Response.status(Status.OK)
				.header("api-key", apiKey)
				.entity(administrator).build();
	}else {
		
		error=Error.USER_AUTHENTICATION_FAILED;
		error.setDescription("Invalid data for the login, verify your login and password");
		return Response.status(Status.OK).entity(error.getJSON()).build();
	}
	
}
@DELETE
@Path("{id}")
public Response delete(@PathParam("id") int id) {
	boolean success= administratorDAO.delete(id);
	if(success) {
		return Response.status(Status.NO_CONTENT).build();
	}else {
		return Response.status(Status.SERVICE_UNAVAILABLE).build();
	}
}
}

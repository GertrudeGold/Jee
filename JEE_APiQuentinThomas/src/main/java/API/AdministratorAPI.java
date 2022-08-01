package API;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import DAO.AdministratorDAO;
import Other.Error;


@Path("/Administrator")
public class AdministratorAPI extends BaseAPI{
private AdministratorDAO administratorDAO = new AdministratorDAO();
private Error error = null;
boolean success = false;

@POST
@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
public Response login(
		@FormParam("serialNumber") int matricule, 
		@FormParam("pwd") String password) {
	String responseJSON;
	//boolean success= User.login(matricule, password);
	if(success) {
		responseJSON="{\"connected\":\"true\"}";
		String apiKey=getApiKey();
		return Response.status(Status.OK)
				.header("api-key", apiKey)
				.entity(responseJSON).build();
	}else {
		error=Error.USER_AUTHENTICATION_FAILED;
		error.setDescription("Invalid data for the login, verify your login and password");
		return Response.status(Status.OK).entity(error.getJSON()).build();
	}
	
}
}

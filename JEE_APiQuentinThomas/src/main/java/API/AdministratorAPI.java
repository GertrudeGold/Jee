package API;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import DAO.AdministratorDAO;
import Model.Administrator;
import Model.Staff;
import Other.Error;

@Path("/administrator")
public class AdministratorAPI extends BaseAPI{
private AdministratorDAO administratorDAO = new AdministratorDAO();
private Error error = null;
boolean success = false;
Administrator administrator = null;



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
	System.out.println(matricule);
	System.out.println(password);
	
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
}

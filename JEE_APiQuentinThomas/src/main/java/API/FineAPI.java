package API;

import javax.ws.rs.FormParam;
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
@Path("/fine")
public class FineAPI {

	
	private Error error = null;
	boolean success = false;
//	ArrayList<Fines> administrator = null;	
//	@POST
//	@Path("/findallvalidate")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response login(
//			@HeaderParam("key") String key) {
//		
//		
//	    administrator= (Administrator) Staff.login(matricule, password);
//		if(administrator != null) {
//
//			String apiKey=getApiKey();
//			return Response.status(Status.OK)
//					.header("api-key", apiKey)
//					.entity(administrator).build();
//		}else {
//			
//			error=Error.USER_AUTHENTICATION_FAILED;
//			error.setDescription("Invalid data for the login, verify your login and password");
//			return Response.status(Status.OK).entity(error.getJSON()).build();
//		}
//		
//	}
}

package API;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import DAO.AdministratorDAO;
import DAO.CollectorDAO;
import DAO.FineDAO;
import Model.Administrator;
import Model.Staff;
import Other.Error;
@Path("/fine")
public class FineAPI extends BaseAPI{

	private FineDAO fineDAO = new FineDAO();
	private Error error = null;
	boolean success = false;
	@DELETE
	@Path("{id}")
	public Response delete(
			@PathParam("id") int id, 
			@HeaderParam("key") String key)
	{
		String apiKey=getApiKey();
		if(key.equals(apiKey)) {
		boolean success= fineDAO.delete(id);
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
	
}

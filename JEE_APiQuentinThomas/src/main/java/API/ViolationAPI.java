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
import DAO.ViolationDAO;
import Model.Administrator;
import Model.Vehicle;
import Model.Violation;
import Other.Error;
@Path("/violation")
public class ViolationAPI extends BaseAPI {
	private ViolationDAO violationDAO = new ViolationDAO();
	private Error error = null;
	boolean success = false;
	Administrator administrator = null;

	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createViolation(
			@FormParam("violation_type") String type,
			@FormParam("violation_amount") String amount,
			
			@HeaderParam(HttpHeaders.AUTHORIZATION) String key) 
	{

		String apiKey=getApiKey();
		if(key.equals(apiKey)) {
			Violation violation = new Violation(type,Double.valueOf(amount));
				
						boolean success = violation.insert(violation);
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
	@DELETE
	@Path("{id}")
	public Response delete(
			@PathParam("id") int id, 
			@HeaderParam(HttpHeaders.AUTHORIZATION) String key)
	{
		String apiKey=getApiKey();
		if(key.equals(apiKey)) {
		boolean success= violationDAO.delete(id);
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
			@FormParam("violation_type") String type,
			@FormParam("violation_amount") String amount,
		
			@HeaderParam(HttpHeaders.AUTHORIZATION) String key) {
		String apiKey=getApiKey();

		if(key.equals(apiKey)) {
		Violation violation = new Violation(id,type,Double.valueOf(amount));
		boolean success= violation.update(violation);
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
		ArrayList<Violation> violations = new ArrayList<Violation>();
		violations=Violation.findAll();
		
			return Response.status(Status.OK).entity(violations).build();
			
		}else {
			return Response.status(Status.UNAUTHORIZED).build();
		}
		
		}
}

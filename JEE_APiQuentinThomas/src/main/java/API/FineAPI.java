package API;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

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
import DAO.CollectorDAO;
import DAO.FineDAO;
import Model.Administrator;
import Model.Fine;
import Model.Plate;
import Model.Policeman;
import Model.Staff;
import Model.Vehicle;
import Model.Violation;
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
			@HeaderParam(HttpHeaders.AUTHORIZATION) String key)
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
	
	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createFine(
			@FormParam("fine_gultyFirstName") String fine_gultyFirstName,
			@FormParam("fine_gultyLastName") String fine_gultyLastName,
			@FormParam("fine_comment") String fine_comment,
			@FormParam("vehicle_id") String vehicle_id,
			@FormParam("plate_id") String plate_id,
			@FormParam("fine_date") String fine_date,
			@FormParam("policeman_id") String policeman_id,
			@FormParam("violation_ids") String violation_ids,
			
			@HeaderParam(HttpHeaders.AUTHORIZATION) String key) 
	{

		String apiKey=getApiKey();
		if(key.equals(apiKey)) {
			Plate plate = new Plate();
			plate = plate.find(Integer.valueOf(plate_id));
			Vehicle vehicle = new Vehicle();
			vehicle = vehicle.find(Integer.valueOf(vehicle_id));
			Policeman policeman = new Policeman();
			policeman = policeman.find(Integer.valueOf(policeman_id));
			ArrayList<Violation> violations = new ArrayList<Violation>();
			String[] violationSplit = violation_ids.split("-");
			int[] violationIds = new int[violationSplit.length];
			for(int i =0;i<violationSplit.length;i++) {
				violationIds[i]= Integer.valueOf(violationSplit[i]);
			}
			for(int idviolation : violationIds) {
				
				Violation violation = new Violation();
				violation = violation.find(idviolation);
				violations.add(violation);
			}
			Date date1=null;
		
			try {
				
				 
				 date1 = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy",Locale.ENGLISH).parse(fine_date);
				
			} catch (ParseException e) {
				
				e.printStackTrace();
			}  
			
			Fine fine = new Fine(vehicle,plate,date1,fine_gultyFirstName,fine_gultyLastName,fine_comment,
					policeman,0,violations);
				
						boolean success = fine.insert(fine);
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
	@PUT
	@Path("{id}")
	public Response update(@PathParam("id") int id,
			@FormParam("validation") String validation,
			
			
		
			@HeaderParam(HttpHeaders.AUTHORIZATION) String key) {
		String apiKey=getApiKey();

		if(key.equals(apiKey)) {
			  
			Fine fine = new Fine(Integer.valueOf(validation),id);
		boolean success= fine.update(fine);
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
		ArrayList<Fine>fines = new ArrayList<Fine>();
		fines=Fine.findAll();
		
			return Response.status(Status.OK).entity(fines).build();
			
		}else {
			return Response.status(Status.UNAUTHORIZED).build();
		}
		
		}
	
}

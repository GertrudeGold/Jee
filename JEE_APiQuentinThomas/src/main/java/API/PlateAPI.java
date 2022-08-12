package API;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import DAO.BrigadeChiefDAO;
import DAO.PlateDAO;
import Model.BrigadeChief;
import Model.Plate;
import Other.Error;
@Path("/plate")
public class PlateAPI extends BaseAPI{
	private Error error = null;
	boolean success = false;
	
	private PlateDAO plateDAO = new PlateDAO();
	
	@GET
	@Path("{plateinfo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findIfAPlateExist(
			@PathParam("plateinfo") String plateinfo, 
			@HeaderParam(HttpHeaders.AUTHORIZATION) String key)
	{
		String apiKey=getApiKey();
		if(key.equals(apiKey)) {
		
			Plate plate = new Plate();
			plate=Plate.findIfAPlateExist(plateinfo);
			return Response.status(Status.OK).entity(plate).build();
		}else {
			return Response.status(Status.SERVICE_UNAVAILABLE).build();
		}
		
		
	}
}

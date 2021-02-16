package ch.hesge.service1;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import ch.hesge.db.CalculeThread;

import javax.servlet.http.HttpServletResponse;

@Path("/service1")
public class Service1 {

	@GET
	@Path("/number")
	@Produces(MediaType.TEXT_PLAIN)
	public String methode1(@Context HttpServletResponse response, @Context UriInfo uriInfo) {

		new CalculeThread().start();

		String baseURL = uriInfo.getBaseUri().toString();
		response.setStatus(HttpServletResponse.SC_SEE_OTHER);
		response.setHeader(HttpHeaders.LOCATION, baseURL + "service2/number");

		try {
			response.flushBuffer();
		} catch (Exception e) {
		}

		return "Service1 ";

	}

}

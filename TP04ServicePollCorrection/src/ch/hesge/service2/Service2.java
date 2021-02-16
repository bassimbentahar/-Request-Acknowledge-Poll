package ch.hesge.service2;


import javax.ws.rs.*;
import javax.ws.rs.core.*;

import ch.hesge.db.Database;

import javax.servlet.http.HttpServletResponse;


@Path("/service2")
public class Service2 {

@GET 
@Path("number")
@Produces(MediaType.TEXT_PLAIN)
public String methode1(@Context HttpServletResponse response)   {
	
	if(!new Database().reponsePrete()) {
		response.setStatus(HttpServletResponse.SC_ACCEPTED); 
		try { 
			response.flushBuffer(); 		
		}catch(Exception e){}

	}else {
		response.setStatus(HttpServletResponse.SC_OK);
		try { 
			response.flushBuffer(); 
		}catch(Exception e){}
	}
	return "Le calcul est fait ";
	
}


}

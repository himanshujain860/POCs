package com.app.web.services;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import com.app.entities.UserDetail;
 
@Path("/cookie")
public class CookieHandler {
	
	@GET
	@Path("/get")
	public Response printHello(){
		return Response.status(201).entity("Success").cookie(new NewCookie("cookieResponse", "cookieValueInReturn")).build();
	}
	
	@GET
	@Path("/getc")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllEployees() throws Exception{
		UserDetail[] users = new UserDetail[2];
		users[0]= new UserDetail(1, "asdf", "asdf");
		users[1]= new UserDetail(2, "qwert", "qwert");
		return Response.status(201).entity(users).cookie(new NewCookie("cookieResponse", "cookieValueInReturn")).build();
	}
}
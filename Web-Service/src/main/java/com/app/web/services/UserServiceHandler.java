package com.app.web.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.app.entities.UserDetail;
import com.app.service.UserService;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserServiceHandler {
	
	private UserService userService = new UserService();
	
	@GET
	public List<UserDetail> getAllUsers()throws Exception {
		return userService.getAllUsers();
	}
	
	@GET
	@Path("/{userId}")
	public UserDetail getUser(@PathParam("userId")Integer id)throws Exception {
		return userService.getUser(id);
	}
	
	@POST
	public UserDetail addUser(UserDetail user)throws Exception{
		return userService.addUser(user);
	}
	
	@PUT
	@Path("/{userId}")
	public UserDetail updateUser(@PathParam("userId")Integer id, UserDetail user)throws Exception{
		return userService.updateUser(id, user);
	}
	
	@DELETE
	@Path("/{userId}")
	public UserDetail deleteUser(@PathParam("userId")Integer id)throws Exception {
		return userService.deleteUser(id);
	}
}

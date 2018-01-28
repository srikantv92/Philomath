package com.advancese.Philomath;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/login")
public class Login {

	private LoginAuthentication auth = new LoginAuthentication();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String loginUser(LoginUser login) {
		return auth.authenticate(login);
	}
}

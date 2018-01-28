package com.advancese.Philomath;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/editProfile")
public class EditProfile {
	private Edit e = new Edit();
	private GetProfile g = new GetProfile();

	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Edit editProfile(String emailID) {
		g.getProfile(emailID, e);
		return e;
	}

}

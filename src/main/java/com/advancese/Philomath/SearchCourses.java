package com.advancese.Philomath;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/searchCourses")
public class SearchCourses {

	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public SearchResults searchCourses(String message){
		
		String[] receivedMessage = message.split(",");
		String searchBy=receivedMessage[0];
		String value = receivedMessage[1];
		Search search =  new Search();
		List<Course> searchResults = new ArrayList<Course>();
		search.search(searchBy, value, searchResults);
		SearchResults result=  new SearchResults();
		result.setSearchResults(searchResults);
		
		return result;
		
		
	}
	
}

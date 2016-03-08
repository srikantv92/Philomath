package com.advancese.Philomath;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mysql.jdbc.Statement;


@Path("/addCourseYouTeach")
public class addCourseYouTeach {
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String addCourseYouTeach(String request){
		String[] requestMessage=request.split(",");
		String email=requestMessage[0];
		String course = requestMessage[1];
		String category = requestMessage[2];
		
		String result="";
		 final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	        final String DB_URL = "jdbc:mysql://173.194.233.74/philoMath";
	        String response;
	        //  Database credentials
	        String USER = "root";
	        String PASS = "admin";

	        Connection conn = null;
	        Statement stmt = null;
	try{
	        Class.forName("com.mysql.jdbc.Driver");

	        //Connecting to Database
	        conn = DriverManager.getConnection(DB_URL, USER, PASS);


	        stmt = (Statement) conn.createStatement();
	        String sql;
	      
	        sql="INSERT INTO `philoMath`.`Prof_rating` (`prof_email`,`course`,`category`) VALUES ('"+email+"','"+course+"','"+category+"')";
	        System.out.println("insert query is "+sql);
	       ((java.sql.Statement) stmt).executeUpdate(sql);
	       
	       result="success";
	        conn.close();
	}
	catch(Exception e){
		System.out.println(e);
		result=e.toString();
		response=e.toString();
	}
	return result;
	}

}

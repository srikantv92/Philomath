package com.advancese.Philomath;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

public class Search {
	
	public void search(String searchBy, String value, List<Course> searchResults){
		
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
	        Course course;
	        sql="SELECT * FROM `philoMath`.`Prof_rating` WHERE `"+ searchBy +"` like '"+value+"';";
	        System.out.println("Query is "+sql);
	        ResultSet rs = ((java.sql.Statement) stmt).executeQuery(sql);
	        while(rs.next()){
	        	course= new Course();
	        	course.setCategory(rs.getString("category"));
	        	course.setCourseName(rs.getString("course"));
	        	
	        	
	        	String email= rs.getString("prof_email");
	        	System.out.println("Email is "+email);
	        	course.setProfessorEmail(email);
	        	String query="SELECT * from `philoMath`.`RegisterUser` WHERE EMAIL like '"+email+"'";
	        	Statement stmt2 = (Statement) conn.createStatement();
	        	ResultSet rs2= stmt2.executeQuery(query);
	        	
	        	while(rs2.next()){
	        		course.setProfessorName(rs2.getString("FullName"));
	        		course.setAddress(rs2.getString("address"));
	        		course.setPhoneNumber(rs2.getString("phoneNumber"));
	        		if(rs2.getString("travel").contains("true")){
	        			course.setTravel("Willing to travel "+rs2.getString("radius"));
	        		}
	        		else{
	        			course.setTravel("Not Willing to travel");
	        		}
		        	course.setAvailability(rs2.getString("availability"));
		        	course.setPricing(rs2.getString("pricing"));
		        	System.out.println("Pricing info is "+course.getPricing());
		        	String pricing= course.getPricing();
		        	if(pricing==null){
		        		course.setPricing("Pricing information not available");
		        	}
		        	String availability=course.getAvailability();
		        	if(availability == null){
		        		course.setAvailability("Availability information not available");
		        	}
	        		
	        	}
	        	searchResults.add(course);
	        }
	       
	        conn.close();
	}
	catch(Exception e){
		System.out.println(e);
		response=e.toString();
	}
		
	}
	public void searchByProfessor(String value, List<Course> searchResults){
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://173.194.233.74/philoMath";
        String response;
        //  Database credentials
        String USER = "root";
        String PASS = "admin";
        String emailid=null;

        Connection conn = null;
        Statement stmt = null;
try{
        Class.forName("com.mysql.jdbc.Driver");

        //Connecting to Database
        conn = DriverManager.getConnection(DB_URL, USER, PASS);


        stmt = (Statement) conn.createStatement();
        String sql;
        Course course;
        
        
        String queryforEmail="SELECT * from `philoMath`.`RegisterUser` WHERE FullName like '%"+value+"%'";
    	Statement stmt4 = (Statement) conn.createStatement();
    	 System.out.println(" first Query is "+queryforEmail);
    	 System.out.println("result is "+stmt4.executeQuery(queryforEmail));
    	ResultSet sri =  stmt4.executeQuery(queryforEmail);
    	 System.out.println("next "+sri.next());
    	 
    	 emailid = sri.getString("Email");
        
        sql="SELECT * FROM `philoMath`.`Prof_rating` WHERE `"+ "prof_email" +"` like '"+emailid+"';";
        System.out.println("Query is "+sql);
        ResultSet rs = ((java.sql.Statement) stmt).executeQuery(sql);
        while(rs.next()){
        	course= new Course();
        	course.setCategory(rs.getString("category"));
        	course.setCourseName(rs.getString("course"));
        	
        	
        	String email= rs.getString("prof_email");
        	System.out.println("Email is "+email);
        	course.setProfessorEmail(email);
        	String query="SELECT * from `philoMath`.`RegisterUser` WHERE EMAIL like '"+email+"'";
        	Statement stmt2 = (Statement) conn.createStatement();
        	ResultSet rs2= stmt2.executeQuery(query);
        	while(rs2.next()){
        		course.setProfessorName(rs2.getString("FullName"));
        		course.setAddress(rs2.getString("address"));
        		course.setPhoneNumber(rs2.getString("phoneNumber"));
        		if(rs2.getString("travel").contains("true")){
        			course.setTravel("Willing to travel "+rs2.getString("radius"));
        		}
        		else{
        			course.setTravel("Not Willing to travel");
        		}
	        	course.setAvailability(rs2.getString("availability"));
	        	course.setPricing(rs2.getString("pricing"));
	        	System.out.println("Pricing info is "+course.getPricing());
	        	String pricing= course.getPricing();
	        	if(pricing==null){
	        		course.setPricing("Pricing information not available");
	        	}
	        	String availability=course.getAvailability();
	        	if(availability == null){
	        		course.setAvailability("Availability information not available");
	        	}
        		
        	}
        	searchResults.add(course);
        }
       
        conn.close();
}
catch(Exception e){
	System.out.println(e);
	response=e.toString();
}

	}
	

}

package com.advancese.Philomath;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mysql.jdbc.Statement;

@Path("/removeCourseYouTeach")
public class RemoveCourseYouTeach {

	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String remove(String message) {
		String[] messageReceived = message.split(",");
		String email = messageReceived[0];
		String course = messageReceived[1];

		String result = "";
		String response;

		Connection conn = null;
		Statement stmt = null;
		try {
			conn = PhiloMathUtils.getDatabaseConnection();

			stmt = (Statement) conn.createStatement();
			String sql;

			sql = "DELETE FROM `philoMath`.`Prof_rating` WHERE `prof_email` = '" + email + "' and `course` ='" + course
					+ "'";
			System.out.println("delete query is " + sql);
			((java.sql.Statement) stmt).executeUpdate(sql);

			result = "success";
			conn.close();
		} catch (Exception e) {
			result = e.toString();
			response = e.toString();
		}
		return result;
	}
}

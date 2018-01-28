package com.advancese.Philomath;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class RegisterDB {
	public String insertData(RegisterUser user) {
		String response;
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = PhiloMathUtils.getDatabaseConnection();

			stmt = (Statement) conn.createStatement();
			String sql;

			sql = "INSERT INTO `philoMath`.`RegisterUser` (`Email`, `FullName`, `phoneNumber`, `address`, `password`, `securityQuestion`, `answer`, `travel`, `radius`, `tutor` ,`availability`,`pricing`) VALUES ('"
					+ user.getEmail() + "','" + user.getFullName() + "','" + user.getPhoneNumber() + "','"
					+ user.getAddress() + "','" + user.getPassword() + "','" + user.getSecurityQuestion() + "','"
					+ user.getAnswer() + "','" + user.isTravel() + "','" + user.getRadius() + "','" + user.isTutor()
					+ "','" + user.getAvailability() + "','" + user.getPricing() + "')";
			((java.sql.Statement) stmt).executeUpdate(sql);
			if (user.isTutor()) {
				sql = "INSERT INTO Prof_rating (`prof_email`,`course`,`category`,`availability`,`pricing`) values ('"
						+ user.getEmail() + "','" + user.getCourse() + "','" + user.getCategory() + "','"
						+ user.getAvailability() + "','" + user.getPricing() + "')";
				((java.sql.Statement) stmt).executeUpdate(sql);
			}
			response = "success";
			conn.close();
		} catch (Exception e) {
			response = e.toString();
		}
		return response;

	}
}

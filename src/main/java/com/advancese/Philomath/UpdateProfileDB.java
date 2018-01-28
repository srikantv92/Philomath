package com.advancese.Philomath;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class UpdateProfileDB {

	public String update(String field, String value, String Email) {
		String result = "";
		String response;

		Connection conn = null;
		Statement stmt = null;
		try {
			conn = PhiloMathUtils.getDatabaseConnection();

			stmt = (Statement) conn.createStatement();
			String sql;

			sql = "UPDATE `philoMath`.`RegisterUser` SET `" + field + "`='" + value + "'  WHERE `Email` like '" + Email
					+ "';";

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

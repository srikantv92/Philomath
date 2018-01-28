package com.advancese.Philomath;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class ResetPassDB {

	public String authenticate(ResetPass reset) {
		String response = "";

		Connection conn = null;
		Statement stmt = null;
		try {
			conn = PhiloMathUtils.getDatabaseConnection();

			stmt = (Statement) conn.createStatement();
			String sql;

			sql = "UPDATE RegisterUser SET password=" + "'" + reset.getPassword() + "' where email=" + "'"
					+ reset.getEmail() + "'";
			stmt.executeUpdate(sql);

			response = "success";
			stmt.close();
			conn.close();
		} catch (Exception e) {
			response = "failed";
			response = e.toString();
		}

		return response;
	}
}

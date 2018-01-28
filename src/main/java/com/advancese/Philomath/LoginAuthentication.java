package com.advancese.Philomath;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class LoginAuthentication {

	public String authenticate(LoginUser login) {
		String response;
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = PhiloMathUtils.getDatabaseConnection();

			stmt = (Statement) conn.createStatement();
			String sql;

			sql = "SELECT * FROM RegisterUser";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				String user = rs.getString("Email");
				String pwd = rs.getString("password");
				System.out.println(user + pwd);
				if (login.getEmail().equals(user) && login.getPassword().equals(pwd))
					return "success";

			}
			rs.close();
			stmt.close();
			conn.close();
			return "failed";
		} catch (Exception e) {
			response = e.toString();
		}
		return response;
	}
}

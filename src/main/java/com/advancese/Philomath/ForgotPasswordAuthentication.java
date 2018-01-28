package com.advancese.Philomath;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.json.simple.JSONObject;

import com.mysql.jdbc.Statement;

public class ForgotPasswordAuthentication {

	public JSONObject authenticate(ForgotPasswordUser user) {
		JSONObject obj = new JSONObject();
		String response;

		Connection conn = null;
		Statement stmt = null;
		try {

			conn = PhiloMathUtils.getDatabaseConnection();
			stmt = (Statement) conn.createStatement();
			String sql;

			sql = "SELECT * FROM RegisterUser where email=" + "'" + user.getEmail() + "'";
			ResultSet rs = stmt.executeQuery(sql);
			String seq = "";
			String ans = "";

			if (rs.next()) {
				seq = rs.getString("securityQuestion");
				ans = rs.getString("answer");
			}
			obj.put("seq", seq);
			obj.put("ans", ans);
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			response = e.toString();
		}

		return obj;
	}
}

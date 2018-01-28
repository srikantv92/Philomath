package com.advancese.Philomath;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PhiloMathUtils {
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://173.194.236.239/philoMath";
	private static final String USER = "root";
	private static final String PASS = "";
	private static Connection conn = null;

	public static Connection getDatabaseConnection() throws ClassNotFoundException, SQLException {
		Class.forName(JDBC_DRIVER);
		return DriverManager.getConnection(DB_URL, USER, PASS);
	}
}

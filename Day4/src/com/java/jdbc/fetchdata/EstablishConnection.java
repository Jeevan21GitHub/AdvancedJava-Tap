package com.java.jdbc.fetchdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EstablishConnection {
	static Connection con;
	public static Connection establishConnection() {
		try {
//			1 Load the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
//			2 Establish the connection
			con=DriverManager.getConnection(MyCredentials.url, MyCredentials.userName, MyCredentials.password);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
}

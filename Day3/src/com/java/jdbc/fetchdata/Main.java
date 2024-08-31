package com.java.jdbc.fetchdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
	
	static Connection con;
	static Statement stmt;
	static ResultSet rs;
	public static void main(String[] args) {
		try {		
//			1 Load the Driver
//				look at the EstablishConnection class
//			2 Establish the Connection
			con=EstablishConnection.establishConnection();
//			3 Create SQL statement
			stmt=con.createStatement();
//			4 Execute the sql query
			rs=stmt.executeQuery("select * from students");
//			5 Process the result
			while(rs.next()) {
				System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getString("age")+" "+rs.getString("dept"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			MyConnections.closeConnections(con,stmt,rs);
		}
	}
}

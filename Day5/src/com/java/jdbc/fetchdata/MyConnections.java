package com.java.jdbc.fetchdata;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyConnections {
	public static void closeConnections(Connection con,Statement stmt,ResultSet rs) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

package com.java.jdbc.fetchdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	
	static Connection con;
	static Statement stmt;
	static ResultSet rs;
	static String query="select * from students where id=?";
	static String queryInsert="insert into students values(?,?,?,?)";
	public static void main(String[] args) {

		try {		
//			1 Load the Driver
//				look at the EstablishConnection class
//			2 Establish the Connection
			con=EstablishConnection.establishConnection();
//			3 Process SQL statement because of incomplete query
//			fetchSpecificData();
			insertData();
					
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			MyConnections.closeConnections(con,stmt,rs);
		}
	}
	public static void insertData() {
		try {
			PreparedStatement pstmt=con.prepareStatement(queryInsert);
			
			pstmt.setInt(1, 4);
			pstmt.setString(2, "jeeva");
			pstmt.setString(3, "21");
			pstmt.setString(4, "CSE");
			pstmt.executeUpdate();
			System.out.println("Success");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void fetchSpecificData() {
		try {
			PreparedStatement pstmt=con.prepareStatement(query);
//			4 Execute the sql query
			System.out.println("Enter the id");
			int id=new Scanner(System.in).nextInt();
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
//			5 Process the result
			if(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			}
			else {
				System.out.println("Data not found!!!");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}

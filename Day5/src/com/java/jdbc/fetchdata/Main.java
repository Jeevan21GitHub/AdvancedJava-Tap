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
	static String queryUpdate="update `students` set name=? where id=?";
	static String queryDelete="delete from `students` where id=?";
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {

		try {		
//			1 Load the Driver
//				look at the EstablishConnection class
//			2 Establish the Connection
			con=EstablishConnection.establishConnection();
//			3 Process SQL statement because of incomplete query
//			fetchSpecificData();
//			fetchSpecificData();
//			updateData();
			deleteData();
					
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			MyConnections.closeConnections(con,stmt,rs);
			sc.close();
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
	public static void updateData() {
		try {
			PreparedStatement pstmt=con.prepareStatement(queryUpdate);	
			System.out.println("Enter the name want to update");
			String name=sc.next();
			System.out.println("Enter the id want to be change");
			int id=sc.nextInt();
			pstmt.setString(1, name);
			pstmt.setInt(2, id);
			int x=pstmt.executeUpdate();
			System.out.println(x+ "row/s affected");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void deleteData() {
		try {
			System.out.println("Enter the Id which data want to be delete");
			int id=sc.nextInt();
			PreparedStatement pstmt=con.prepareStatement(queryDelete);
			pstmt.setInt(1, id);
			int x=pstmt.executeUpdate();
			System.out.println(x+" row/s affected");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}

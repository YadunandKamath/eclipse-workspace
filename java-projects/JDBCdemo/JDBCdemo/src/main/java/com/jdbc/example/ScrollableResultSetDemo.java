package com.jdbc.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScrollableResultSetDemo {

	public static void main(String[] args) throws Exception {
		
		SpringApplication.run(ScrollableResultSetDemo.class, args);
		
		String url = "jdbc:postgresql://localhost:5432/org";
		String username = "user1";
		String password = "user1";

		try {
			Connection con = DriverManager.getConnection(url,username,password);
			if(con!=null) {
				System.out.println("\n--------------------Connection Successful--------------------\n");
			}
			else {
				System.out.println("\n--------------------Connection Failed--------------------\n");
			}
			con.setAutoCommit(false);
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = st.executeQuery("select * from worker");
			System.out.println("\n-------------Forward Direction--------------\n");
			while(rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getInt(4) + "\t" + rs.getString(5));
			}
			System.out.println("\n-------------Reverse Direction--------------\n");
			while(rs.previous()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getInt(4) + "\t" + rs.getString(5));
			}
			System.out.println("\n-------------Second Last Record--------------\n");
			rs.absolute(-2);
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getInt(4) + "\t" + rs.getString(5));
			System.out.println("\n-------------Delete Last Record--------------\n");
			rs.last();
			rs.deleteRow();
			rs.beforeFirst();
			while(rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getInt(4) + "\t" + rs.getString(5));
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}

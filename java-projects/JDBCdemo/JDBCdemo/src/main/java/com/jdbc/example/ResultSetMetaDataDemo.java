package com.jdbc.example;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ResultSetMetaDataDemo {

	public static void main(String[] args) {
		
		SpringApplication.run(ResultSetMetaDataDemo.class, args);
		
		String url = "jdbc:postgresql://localhost:5432/org";
		String username = "user1";
		String password = "user1";

		try(Connection con = DriverManager.getConnection(url,username,password)){
			if(con!=null) {
				System.out.println("\n--------------Connection successful-----------------\n");
			}
			else {
				System.out.println("\\n--------------Connection failed--------------\n");
			}
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from worker");
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			System.out.println("Number of columns in worker table = " + count);
			for(int i=1;i<=count;i++) {
				System.out.println("Column Number: " + i);
				System.out.println("Column Name: " + rsmd.getColumnName(i));
				System.out.println("Column Type: " + rsmd.getColumnType(i));
				System.out.println("Column Display Size: " + rsmd.getColumnDisplaySize(i));
				System.out.println("---------------------------------------------------");
			}
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}

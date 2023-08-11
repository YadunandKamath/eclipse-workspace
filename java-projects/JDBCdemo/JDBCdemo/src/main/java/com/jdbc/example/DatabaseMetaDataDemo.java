package com.jdbc.example;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatabaseMetaDataDemo {

	public static void main(String[] args) {
		
		SpringApplication.run(DatabaseMetaDataDemo.class, args);
		
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
			
			DatabaseMetaData dbmd = con.getMetaData();
			System.out.println(dbmd.getDatabaseProductName());
			System.out.println(dbmd.getSQLKeywords());
			
			String catalog = null;
			String schemaPattern = null;
			String tableNamePattern = null;
			String[] types = null;
			ResultSet rs = dbmd.getTables(catalog, schemaPattern, tableNamePattern, types);
			int count = 0;
			while(rs.next()) {
				count++;
				System.out.println(rs.getString(1) + "\t" + rs.getString(2)+ "\t" + rs.getString(3));
			}
			System.out.println("Number of tables = " + count);
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}

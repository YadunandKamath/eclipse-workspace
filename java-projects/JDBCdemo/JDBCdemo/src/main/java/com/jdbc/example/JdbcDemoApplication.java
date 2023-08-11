package com.jdbc.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcDemoApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(JdbcDemoApplication.class, args);
		
		//Class.forName("org.postgresql.Driver");
		
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
			//int rowcount = st.executeUpdate("insert into users values (4,'Tim','USER')");
			//System.out.println("ROWS AFFECTED: " + rowcount);
			ResultSet rs = st.executeQuery("select * from users");
			while(rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
			}	
			System.out.println("\nxxxxxxxxxxxxxx Connection closed xxxxxxxxxxxxxxxxx\n");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package com.jdbc.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DateDemo {

	public static void main(String[] args) throws Exception{
		
		SpringApplication.run(DateDemo.class, args);
		
		String url = "jdbc:postgresql://localhost:5432/org";
		String username = "user1";
		String password = "user1";
		
		try(Connection con = DriverManager.getConnection(url,username,password)){
			
			if(con!=null) {
				System.out.println("\n------------------------CONNECTION SUCCESSFUL------------------------\n");
			}
			else {
				System.out.println("\n----------------------X CONNECTION FAILED X----------------------\n");
			}
			
			Statement st = con.createStatement();
			PreparedStatement pst = con.prepareStatement("insert into userdate values(?,?)");
			Scanner sc = new Scanner(System.in);
			System.out.println("Insert data? y/n");
			String b = sc.next();
			if(b.equalsIgnoreCase("y")) {
				System.out.println("Enter user name: ");
				String name = sc.next();
				System.out.println("Enter DOB(dd-mm-yyyy): ");
				String dob = sc.next();
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				java.util.Date uDate = sdf.parse(dob);
				long l = uDate.getTime();
				java.sql.Date sDate = new java.sql.Date(l);
				pst.setString(1, name);
				pst.setDate(2, sDate);
				int rows = pst.executeUpdate();
				System.out.println("\nROWS INSERTED = " + rows);
			}
			System.out.println("\nUpdated Table:");
			ResultSet rs = st.executeQuery("select * from userdate");
			while(rs.next()) {
				System.out.println(rs.getString(1) + "\t" + rs.getDate(2));
			}
			con.close();
			System.out.println("\nxxxxxxxxxxxxx CONNECTION CLOSED xxxxxxxxxxxxxx\n");
		}

	}

}

package com.jdbc.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PreparedStatementDemo {

	public static void main(String[] args) throws Exception {
		
		SpringApplication.run(PreparedStatementDemo.class, args);
		
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
			
			String q1 = "insert into users values (?,?,?)";
			PreparedStatement pst = con.prepareStatement(q1);
			Scanner sc = new Scanner(System.in);
			while(true) {
				System.out.println("Enter user_id: ");
				int uid = sc.nextInt();
				System.out.println("Enter user_name: ");
				String uname = sc.next();
				System.out.println("Enter created_by: ");
				String cby = sc.next().toUpperCase();
				pst.setInt(1, uid);
				pst.setString(2, uname);
				pst.setString(3, cby);
				int rows = pst.executeUpdate();
				System.out.println(rows + " ROW(S) INSERTED\n");
				System.out.println("Enter more records? y/n ");
				String option = sc.next();
				if(option.equalsIgnoreCase("n")) {
					break;
				}
			}
			sc.close();
			con.close();
			System.out.println("\nxxxxxxxxxxxxxxxxxx Connection Closed xxxxxxxxxxxxxxxxxxxxx\n");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}

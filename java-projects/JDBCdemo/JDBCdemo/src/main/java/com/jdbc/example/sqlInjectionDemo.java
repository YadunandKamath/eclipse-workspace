package com.jdbc.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class sqlInjectionDemo {

	public static void main(String[] args) throws Exception {
		
		SpringApplication.run(sqlInjectionDemo.class, args);
		
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
			System.out.println("Usernames and Passwords: ");
			ResultSet rs = st.executeQuery("select * from userpass");
			while(rs.next()) {
				System.out.println(rs.getString(1) + "\t" + rs.getString(2));
			}
			System.out.println();
//			Scanner sc = new Scanner(System.in);
//			System.out.println("Enter username: ");
//			String un = sc.next();
//			System.out.println("Enter password: ");
//			String up = sc.next();
			String un1 = "durga'--";
			String up1 = "pass";
			ResultSet res = st.executeQuery("select count(*) from userpass where uname = '" + un1 + "' and upass = '" + up1 + "'");
			int c = 0;
			if(res.next()) {
				c = res.getInt(1);
			}
			if(c==0) {
				System.out.println("\nINVALID CREDENTIALS\n");
			}
			else {
				System.out.println("\nVALID CREDENTIALS\n");
			}
			System.out.println("\nxxxxxxxxxxxxxx Connection closed xxxxxxxxxxxxxxxxx\n");
		}

	}

}

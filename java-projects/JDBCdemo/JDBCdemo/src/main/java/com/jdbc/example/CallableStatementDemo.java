package com.jdbc.example;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CallableStatementDemo {

	public static void main(String[] args) throws Exception {
		
		SpringApplication.run(CallableStatementDemo.class, args);
		
		String url = "jdbc:postgresql://localhost:5432/org";
		String username = "user1";
		String password = "user1";
		
		try(Connection con = DriverManager.getConnection(url,username,password)){
			if(con!=null) {
				System.out.println("\n--------------------Connection Successful--------------------\n");
			}
			else {
				System.out.println("\n--------------------Connection Failed--------------------\n");
			}
			
			CallableStatement cst = con.prepareCall("{?=call findSal(?)}");
			cst.setInt(2, 6);
			cst.registerOutParameter(1, Types.INTEGER);
			cst.execute();
			System.out.println("Salary: "+ cst.getInt(1));
			cst.closeOnCompletion();
			con.close();
			System.out.println("\nxxxxxxxxxxxxxxxxxx Connection Closed xxxxxxxxxxxxxxxxxxxxx\n");
			
		}
				
	}

}

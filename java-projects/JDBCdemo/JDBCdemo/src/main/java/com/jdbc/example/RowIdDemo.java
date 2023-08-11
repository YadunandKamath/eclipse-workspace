package com.jdbc.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RowIdDemo {

	public static void main(String[] args) throws Exception {
		
		SpringApplication.run(RowIdDemo.class, args);
		
		String url = "jdbc:postgresql://localhost:5432/org";
		String username = "user1";
		String password = "user1";

		Connection con = DriverManager.getConnection(url,username,password);
		if(con!=null) {
			System.out.println("\n--------------------Connection Successful--------------------\n");
		}
		else {
			System.out.println("\n--------------------Connection Failed--------------------\n");
		}
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select rowid, user_id, user_name, created_by from users");
		while(rs.next()){
			
			RowId id = rs.getRowId(1);
			byte[] b = id.getBytes();
			String rowId = new String(b);
			System.out.println(rowId + "\t" + rs.getInt(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));
			
		}

	}

}

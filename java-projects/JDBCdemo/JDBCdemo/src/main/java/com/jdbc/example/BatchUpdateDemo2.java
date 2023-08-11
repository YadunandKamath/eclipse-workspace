package com.jdbc.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BatchUpdateDemo2 {

	public static void main(String[] args) throws SQLException {
		
		SpringApplication.run(BatchUpdateDemo2.class, args);
		
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
			
			PreparedStatement pst = con.prepareStatement("insert into users values (?,?,?)");
			pst.setInt(1, 8);
			pst.setString(2, "Luke");
			pst.setString(3, "ADMIN");
			pst.addBatch();
			pst.setInt(1, 9);
			pst.setString(2, "Alex");
			pst.setString(3, "ADMIN");
			pst.addBatch();
			pst.setInt(1, 10);
			pst.setString(2, "Lily");
			pst.setString(3, "USER");
			pst.addBatch();
			int[] count = pst.executeBatch();
			int updateCount = 0 ;
			for(int c:count) {
				updateCount += c;
			}
			System.out.println("ROWS INSERTED: " + updateCount);
			con.close();
		}

	}

}

package com.jdbc.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BatchUpdateDemo {

	public static void main(String[] args) throws SQLException {
		
		SpringApplication.run(BatchUpdateDemo.class, args);
		
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
			st.addBatch("insert into users values (7, 'Julia', 'ADMIN')");
			st.addBatch("insert into users values (8, 'Juliana', 'ADMIN')");
			st.addBatch("delete from users where user_id=8");
			int[] count = st.executeBatch();
			int updateCount=0;
			for(int c:count) {
				updateCount += c;
			}
			System.out.println("ROWS UPDATED: " + updateCount);
			con.close();
		}

	}

}

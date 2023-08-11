package com.jdbc.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.postgresql.jdbc3.Jdbc3ConnectionPool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConnectionPoolDemo {

	public static void main(String[] args) throws Exception {
		
		SpringApplication.run(ConnectionPoolDemo.class, args);

		Jdbc3ConnectionPool ds = new Jdbc3ConnectionPool();
		ds.setDatabaseName("org");
		ds.setUser("user1");
		ds.setPassword("user1");
		Connection con1 = ds.getConnection();
		if(con1!=null) {
			System.out.println("connection success");
		}
		PreparedStatement ps = con1.prepareStatement("select * from userdate");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString(1) + "\t" + rs.getDate(2));
		}
		con1.close();
	}

}

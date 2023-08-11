package com.jdbc.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CachedRowSetDemo {

	public static void main(String[] args) throws Exception {
		
		SpringApplication.run(CachedRowSetDemo.class, args);
		
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
		ResultSet rs = st.executeQuery("select * from worker");
		
		RowSetFactory rsf = RowSetProvider.newFactory();
		CachedRowSet crs = rsf.createCachedRowSet();
		
		crs.populate(rs);
		con.close();

		while(crs.next()) {
			System.out.println(crs.getInt(1) + "\t" + crs.getString(2) + "\t" + crs.getString(3) + "\t" + crs.getInt(4) + "\t" + crs.getString(5));
		}

	}

}

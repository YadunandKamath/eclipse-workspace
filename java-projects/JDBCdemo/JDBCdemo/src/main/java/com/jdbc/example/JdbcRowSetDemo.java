package com.jdbc.example;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcRowSetDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		SpringApplication.run(JdbcRowSetDemo.class, args);
		
		RowSetFactory rsf = RowSetProvider.newFactory();
		JdbcRowSet jrs = rsf.createJdbcRowSet();
		jrs.setUrl("jdbc:postgresql://localhost:5432/org");
		jrs.setUsername("user1");
		jrs.setPassword("user1");
		jrs.setCommand("select * from worker");
		jrs.execute();
		System.out.println("Worker Details Forward Direction:");
		while(jrs.next()) {
			System.out.println(jrs.getInt(1) + "\t" + jrs.getString(2) + "\t" + jrs.getString(3) + "\t" + jrs.getInt(4) + "\t" + jrs.getString(5));
		}
		System.out.println("\nWorker Details Reverse Direction:");
		while(jrs.previous()) {
			System.out.println(jrs.getInt(1) + "\t" + jrs.getString(2) + "\t" + jrs.getString(3) + "\t" + jrs.getInt(4) + "\t" + jrs.getString(5));
		}

	}

}

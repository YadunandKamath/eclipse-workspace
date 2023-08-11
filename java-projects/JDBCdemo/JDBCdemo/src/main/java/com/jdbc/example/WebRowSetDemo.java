package com.jdbc.example;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebRowSetDemo {

	public static void main(String[] args) throws Exception {
		
		SpringApplication.run(WebRowSetDemo.class, args);

		RowSetFactory rsf = RowSetProvider.newFactory();
		WebRowSet wrs = rsf.createWebRowSet();
		
		wrs.setUrl("jdbc:postgresql://localhost:5432/org");
		wrs.setUsername("user1");
		wrs.setPassword("user1");
		wrs.setCommand("select * from worker");
		wrs.execute();
		
		FileWriter fw = new FileWriter("C:\\Users\\ykamath\\OneDrive - Capgemini\\Documents\\eclipse-workspace\\JDBCdemo\\emp.xml");
		wrs.writeXml(fw);
		System.out.println("Worker data published to xml");
		fw.close();
		wrs.close();


	}

}

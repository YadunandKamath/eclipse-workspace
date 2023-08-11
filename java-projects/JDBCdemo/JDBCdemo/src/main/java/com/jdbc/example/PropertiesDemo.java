package com.jdbc.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PropertiesDemo {

	public static void main(String[] args) throws Exception {
	
		SpringApplication.run(PropertiesDemo.class, args);
		
		FileInputStream fis = new FileInputStream(new File("C:\\Users\\ykamath\\OneDrive - Capgemini\\Documents\\eclipse-workspace\\JDBCdemo\\db.properties.txt"));
		
		Properties p = new Properties();
		p.load(fis);
		
		String url = p.getProperty("url");
		String user = p.getProperty("username");
		String pass = p.getProperty("password");
		
		try(Connection con = DriverManager.getConnection(url,user,pass)){
			if(con!=null) {
				System.out.println("Connection Successful");
			
			}
		}
		
	}

}

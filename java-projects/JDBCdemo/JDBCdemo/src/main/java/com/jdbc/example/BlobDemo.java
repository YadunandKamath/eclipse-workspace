package com.jdbc.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlobDemo {

	public static void main(String[] args) throws Exception{
		
		SpringApplication.run(BlobDemo.class, args);
		
		String url = "jdbc:postgresql://localhost:5432/org";
		String username = "user1";
		String password = "user1";
		
		try(Connection con = DriverManager.getConnection(url,username,password)){
			
			if(con!=null) {
				System.out.println("\n------------------------CONNECTION SUCCESSFUL------------------------\n");
			}
			else {
				System.out.println("\n----------------------X CONNECTION FAILED X----------------------\n");
			}
			
			File f = new File("C:\\Users\\ykamath\\OneDrive - Capgemini\\Documents\\eclipse-workspace\\JDBCdemo\\img1.jpg");
			FileInputStream fis = new FileInputStream(f);
			String q1 = "insert into blobdemo values (?,?)";
			String q2 = "select * from blobdemo";
			PreparedStatement ps1 = con.prepareStatement(q1);
			PreparedStatement ps2 = con.prepareStatement(q2);
			ps1.setString(1, "blob1");
			ps1.setBinaryStream(2, fis);
			System.out.println("Inserting image from: " + f.getAbsolutePath());
			int rowCount = ps1.executeUpdate();
			System.out.println("ROWS INSERTED = " + rowCount);
			ResultSet rs = ps2.executeQuery();
			FileOutputStream fos = new FileOutputStream("C:\\Users\\ykamath\\OneDrive - Capgemini\\Documents\\eclipse-workspace\\JDBCdemo\\img1rec.jpg");
			if(rs.next()) {
				String bname = rs.getString(1);
				InputStream is = rs.getBinaryStream(2);
				byte[] buffer = new byte[1024];
				while(is.read(buffer)>0) {
					fos.write(buffer);
				}
				fos.flush();
				System.out.println("Image retrieved for " + bname);
			}
			con.close();
			System.out.println("\nxxxxxxxxxxxxx CONNECTION CLOSED xxxxxxxxxxxxxx\n");
		}

	}

}

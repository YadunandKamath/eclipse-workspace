package com.jdbc.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.Reader;
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
public class ClobDemo {

	public static void main(String[] args) throws Exception{
		
		SpringApplication.run(ClobDemo.class, args);
		
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
			
			File f = new File("C:\\Users\\ykamath\\OneDrive - Capgemini\\Documents\\eclipse-workspace\\FileIODemo\\mf.txt");
			FileReader fr = new FileReader(f);
			String q1 = "insert into clobdemo values (?,?)";
			String q2 = "select * from clobdemo";
			PreparedStatement ps1 = con.prepareStatement(q1);
			PreparedStatement ps2 = con.prepareStatement(q2);
			ps1.setString(1, "clob1");
			ps1.setCharacterStream(2, fr);
			System.out.println("Inserting image from: " + f.getAbsolutePath());
			int rowCount = ps1.executeUpdate();
			System.out.println("ROWS INSERTED = " + rowCount);
			ResultSet rs = ps2.executeQuery();
			FileWriter fw = new FileWriter("C:\\Users\\ykamath\\OneDrive - Capgemini\\Documents\\eclipse-workspace\\JDBCdemo\\clobrec.txt");
			if(rs.next()) {
				String cname = rs.getString(1);
				Reader r = rs.getCharacterStream(2);
				char[] buffer2 = new char[1024];
				while(r.read(buffer2)>0) {
					fw.write(buffer2);
				}
				fw.flush();
				System.out.println("Inserted " + cname + " into file.");
			}
			con.close();
			System.out.println("\nxxxxxxxxxxxxx CONNECTION CLOSED xxxxxxxxxxxxxx\n");
		}

	}

}

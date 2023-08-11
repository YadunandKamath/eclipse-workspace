package com.demo1;

import java.util.Date;

public class DatevsDate {

	public static void main(String[] args) {

		java.util.Date uDate = new java.util.Date();
		System.out.println("Util Date: " + uDate);

		long l = uDate.getTime();
		java.sql.Date sDate = new java.sql.Date(l);
		System.out.println("sql Date: " + sDate);
		
	}

}

package com.demo1;

class Student{
	
	static {
		System.out.println("Student static class");
	}
}

public class Demo1 {

	public static void main(String[] args) throws Exception{
				
			Class.forName("com.demo1.Student");

	}

}

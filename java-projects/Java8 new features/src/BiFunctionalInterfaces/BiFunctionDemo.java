package BiFunctionalInterfaces;

import java.util.ArrayList;
import java.util.function.BiFunction;

class Student { 
	String name; 
	int rollno; 
	Student(String name,int rollno){ 
		this.name=name; 
		this.rollno=rollno; 
	} 
} 

public class BiFunctionDemo {

	public static void main(String[] args) {
		
		BiFunction<Integer, Integer, Integer> product = (a,b) -> (a*b);
		System.out.println("Product = " + product.apply(10, 15));
		System.out.println();
		
		ArrayList<Student> l = new ArrayList<>();
		BiFunction<String,Integer,Student> f = (name,rollno) -> new Student(name,rollno);  
		l.add(f.apply("Durga",100)); 
		l.add(f.apply("Ravi",200)); 
		l.add(f.apply("Shiva",300)); 
		l.add(f.apply("Pavan",400)); 
		for(Student s : l) { 
			System.out.println("Student Name:"+s.name); 
			System.out.println("Student Rollno:"+s.rollno); 
			System.out.println("----------------------"); 
		} 
	}

}

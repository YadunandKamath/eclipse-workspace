package FunctionInterface;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

class Student {
	
	String name;
	int marks;
	Student(String name, int marks){
		this.name = name;
		this.marks = marks;
	}
	
}

public class StudentGrade {

	public static void populate(ArrayList<Student> l) { 
		l.add(new Student("Sunny",100)); 
		l.add(new Student("Bunny",65)); 
		l.add(new Student("Chinny",55)); 
		l.add(new Student("Vinny",45)); 
		l.add(new Student("Pinny",25)); 
	}
	
	public static void main(String[] args) {
		
		ArrayList<Student> l = new ArrayList<>();
		populate(l);
		
		Predicate<Student> p = s -> s.marks>=60;
		
		Function<Student, String> studentGrade = s -> {
			int marks = s.marks;
			if(marks>=80) {
				return "A[Distinction]";
			}
			else if(marks>=60) {
				return "B[First Class]";
			}
			else if(marks>=35) {
				return "C[Second Class]";
			}
			else {
				return "Fail";
			}
		};
		
		for(Student s:l) {
			
			if(p.test(s)) {
				System.out.println("Name = " + s.name);
				System.out.println("Marks = " + s.marks);
				System.out.println("Grade = " + studentGrade.apply(s));
				System.out.println("------------------------");
			}
			
		}

	}

}

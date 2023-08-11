package LambdaExpressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Employee {
	
	int empno;
	String empname;
	public Employee(int empno, String empname) {
		this.empno = empno;
		this.empname = empname;
	}
	public String toString() {
		return empno + ":" + empname;
	}
	
}

public class SortWLambda {

	public static void main(String[] args) {
		
		// sort ArrayList		
		List<Integer> l = new ArrayList<>();
		l.add(10);
		l.add(0);
		l.add(20);
		l.add(5);
		l.add(15);
		System.out.println("Before sorting: " + l);
		Collections.sort(l, (i1,i2)->(i1>i2)?-1:(i1<i2)?1:0);
		System.out.println("After sorting: " + l);

		// sort TreeSet
		Set<Integer> s = new TreeSet<Integer>((i1,i2)->(i1>i2)?-1:(i1<i2)?1:0);
		s.add(10);
		s.add(0);
		s.add(20);
		s.add(5);
		s.add(15);
		System.out.println(s);
		
		// sort class objects
		ArrayList<Employee> e = new ArrayList<Employee>();
		e.add(new Employee(200, "A"));
		e.add(new Employee(400, "X"));
		e.add(new Employee(300, "L"));
		e.add(new Employee(100, "C"));
		System.out.println("Before sorting: " + e);
		Collections.sort(e,(e1,e2)->(e1.empno<e2.empno)?-1:(e1.empno>e2.empno)?1:0);
		System.out.println("After sorting: " + e);
		
		
	}

}

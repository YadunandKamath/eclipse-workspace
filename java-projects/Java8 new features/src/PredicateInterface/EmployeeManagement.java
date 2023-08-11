package PredicateInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Employee{
	
	String name;
	String designation;
	double salary;
	String city;
	public Employee(String name, String designation, double salary, String city) {
		super();
		this.name = name;
		this.designation = designation;
		this.salary = salary;
		this.city = city;
	}
	public String toString() {
		return String.format("(%s, %s, %.2f, %s)\n", name, designation, salary, city);
	}
	
}

public class EmployeeManagement {

	public static void populate(List<Employee> list) {
		list.add(new Employee("Durga","CEO",30000,"Hyderabad")); 
		list.add(new Employee("Sunny","Manager",20000,"Hyderabad")); 
		list.add(new Employee("Mallika","Manager",20000,"Bangalore")); 
		list.add(new Employee("Kareena","Lead",15000,"Hyderabad")); 
		list.add(new Employee("Katrina","Lead",15000,"Bangalore")); 
		list.add(new Employee("Anushka","Developer",10000,"Hyderabad")); 
		list.add(new Employee("Kanushka","Developer",12000,"Hyderabad")); 
		list.add(new Employee("Sowmya","Developer",10000,"Bangalore")); 
		list.add(new Employee("Ramya","Developer",13000,"Bangalore")); 

	}
	
	public static void display(Predicate<Employee> p, List<Employee> l) {
		for(Employee e: l) {
			if(p.test(e)) {
				System.out.println(e);
			}
		}
		System.out.println("********************************");
	}
	
	public static void main(String[] args) {
		
		List<Employee> el = new ArrayList<>();
		populate(el);
		System.out.println(el);
		System.out.println("-------------------------------------------");
		
		Predicate<Employee> isManager = emp -> emp.designation.equals("Manager");
		System.out.println("\nManagers: \n");
		display(isManager,el);
		
		Predicate<Employee> fromBangalore = emp -> emp.city.equals("Bangalore");
		System.out.println("\nEmployees from Bangalore: \n");
		display(fromBangalore, el);
		
		Predicate<Employee> sal = emp -> emp.salary<20000;
		System.out.println("\nEmployees with Salary less than 20000:\n");
		display(sal, el);
		
		System.out.println("\nManagers from Bangalore:\n");
		display(isManager.and(fromBangalore),el);
		
		System.out.println("\nNot Managers:\n");
		display(isManager.negate(), el);
		
	}

}

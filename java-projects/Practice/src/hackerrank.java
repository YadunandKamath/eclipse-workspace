import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Student implements Comparable<Student> {
	
	private int id;
	private String name;
	private double cgpa;
	public Student() {
		
	}
	public Student(int id, String name, double cgpa) {
		super();
		this.id = id;
		this.name = name;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCgpa() {
		return cgpa;
	}
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

class Priorities {
	
	List<Student> getStudents(List<String> events){
				
		double max = 0;
		double min = 4.0;
		for(String event: events) {
			
			if(event.equalsIgnoreCase("served")) {
				for(Student st : hackerrank.pq) {
					if(st.getCgpa()>max) {
						max = st.getCgpa();
					}
				}
			}
		}
		for(Student smax: hackerrank.pq) {
			if(smax.getCgpa()==max) {
				hackerrank.pq.remove(smax);
			}
		}
		List<Student> student_list = new ArrayList<Student>();
		for(Student smin:hackerrank.pq) {
			if(smin.getCgpa()<min) {
				min = smin.getCgpa();
			}
			student_list.add(smin);
		}
		
		return student_list;
	}
}

public class hackerrank {

	static int n;
	static PriorityQueue<Student> pq = new PriorityQueue<>();
	static Priorities pr = new Priorities();
	static List<String> events = new ArrayList<>();
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		List<Student> temp = new ArrayList<>();
		List<String> res = new ArrayList<>();
		while(n>0)
		{
			String event = sc.next();
			events.add(event);
			if(event.equalsIgnoreCase("enter")) {
				String name = sc.next();
				double cgpa = sc.nextDouble();
				int id = sc.nextInt(); 
				pq.add(new Student(id, name, cgpa));
				n--;
			}
			else {
				temp = pr.getStudents(events);
				n--;
			}
		}
		for(Student x:temp) {
			res.add(x.getName());
		}
		Collections.sort(res);
		System.out.println(res);
	}

}

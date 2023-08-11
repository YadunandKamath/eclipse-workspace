package StreamAPI;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> l = new ArrayList<>();
		l.add(0);
		l.add(21);
		l.add(12);
		l.add(47);
		l.add(33);
		l.add(85);
		l.add(37);
		System.out.println("Original List: " + l);
		System.out.println("Even numbers: " + l.stream().filter(i->i%2==0).collect(Collectors.toList()));
		System.out.println("Squares: " + l.stream().map(i->i*i).collect(Collectors.toList()));
		System.out.println("Count above 30: " + l.stream().filter(i->i>30).count());
		System.out.println("Sorted: " + l.stream().sorted().collect(Collectors.toList()));
		System.out.println("Customized Sorting: " + l.stream().sorted((i1,i2)->-i1.compareTo(i2)).collect(Collectors.toList()));
		System.out.println("Minimum value: " + l.stream().min((i1,i2)->i1.compareTo(i2)).get());
		System.out.println("Maximum value: " + l.stream().max((i1,i2)->i1.compareTo(i2)).get());
		Integer[] x = l.stream().toArray(Integer[]::new);
		System.out.println("Array: ");
		for (Integer integer : x) {
			System.out.print(" " + integer);
		}
		ArrayList<String> s = new ArrayList<>();
		s.add("A");
		s.add("BB");
		s.add("CCC");
		System.out.println();
		s.stream().forEach(System.out::print);
		
		
		
	}

}

package PredicateInterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

	public static void main(String[] args) {
		
		Predicate<Integer> p1 = i -> i>10;	// lambda expression to check if number is greater than 10
		System.out.println("Greater than 10: " + p1.test(32));
		System.out.println("Greater than 10: " + p1.test(5));

		Predicate<String> p2 = s -> s.length()>5;
		System.out.println("String length greater than 5: " + p2.test("hi"));
		System.out.println("String length greater than 5: " + p2.test("example"));
		
		Predicate<Collection> p3 = c -> c.isEmpty();
		List l = new ArrayList<>();
		System.out.println("Collection is empty: " + p3.test(l));
		l.add(5);
		System.out.println("Collection is empty: " + p3.test(l));
		
		Predicate<String> ps = Predicate.isEqual("durga");
		System.out.println(ps.test("abcd"));
		System.out.println(ps.test("durga"));
		
	}

}

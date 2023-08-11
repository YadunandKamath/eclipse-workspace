package PredicateInterface;

import java.util.function.Predicate;

public class PredicateStartsWithK {

	public static void main(String[] args) {
		
		String[] names = {"Sunny","Kajal","Mallika","Katrina","Kareena"}; 
		
		Predicate<String> startsWithK = s -> s.charAt(0)=='K';
		
		System.out.println("Names that start with 'K': ");
		for(String s:names) {
			if(startsWithK.test(s)) {
				System.out.println(s);
			}
		}
		
	}

}

package BiFunctionalInterfaces;

import java.util.function.BiPredicate;

public class BiPredicateDemo {

	public static void main(String[] args) {
		
		BiPredicate<Integer, Integer> isSumEven = (a,b) -> (a + b) % 2 ==0;
		System.out.println("Even = " + isSumEven.test(10, 20));
		System.out.println("Even = " + isSumEven.test(7, 8));

	}

}

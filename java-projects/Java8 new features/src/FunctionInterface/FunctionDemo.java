package FunctionInterface;

import java.util.function.Function;

public class FunctionDemo {

	public static void main(String[] args) {
		
		Function<String, Integer> f1 = s -> s.length();
		System.out.println("String Length = " + f1.apply("durga"));
		
		Function<Integer, Integer> f2 = i -> i*i;
		System.out.println("Square = " + f2.apply(25));
		

	}

}

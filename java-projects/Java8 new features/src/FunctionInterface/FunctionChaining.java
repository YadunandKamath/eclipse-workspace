package FunctionInterface;

import java.util.function.Function;

public class FunctionChaining {

	public static void main(String[] args) {
		
		Function<String, String> f1 = s -> s.toUpperCase();
		Function<String, String> f2 = s -> s.substring(0,6);
		
		System.out.println("Upper case = " + f1.apply("durgasoftware"));
		System.out.println("Substring = " + f2.apply("durgasoftware"));
		System.out.println("Function Chaining = " + f1.andThen(f2).apply("durgasoftware"));
		
		Function<Integer, Integer> f3 = i -> i+i;
		Function<Integer, Integer> f4 = i -> i*i*i;
		
		System.out.println("AndThen = " + f3.andThen(f4).apply(2));
		System.out.println("Compose = " + f3.compose(f4).apply(2));

	}

}

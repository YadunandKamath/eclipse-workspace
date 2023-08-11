package BiFunctionalInterfaces;

import java.util.function.BiConsumer;

public class BiConsumerDemo {

	public static void main(String[] args) {
		
		BiConsumer<String, String> concat = (s1,s2) -> System.out.println(s1+s2);
		concat.accept("Hello", "World");

	}

}

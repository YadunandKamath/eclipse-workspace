package FunctionInterface;

import java.util.function.Function;

public class Spaces {

	public static void main(String[] args) {
		
		Function<String, String> removeSpaces = s -> s.replaceAll(" ", "");
		System.out.println(removeSpaces.apply("Durga Software"));
		
		Function<String, Integer> countSpaces = s -> s.length() - s.replaceAll(" ", "").length();
		System.out.println("Number of spaces = " + countSpaces.apply("durga software solutions"));

	}

}

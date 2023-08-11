package FunctionInterface;

import java.util.function.IntToDoubleFunction;
import java.util.function.ToIntFunction;

public class PrimitiveFunctionDemo {

	public static void main(String[] args) {
		
		ToIntFunction<String> strlen = s -> s.length();
		System.out.println("String Length = " + strlen.applyAsInt("flute"));
		
		IntToDoubleFunction sqroot = i -> Math.sqrt(i);
		System.out.println("Square Root = " + sqroot.applyAsDouble(64));

	}

}

package LambdaExpressions;

@FunctionalInterface
interface Interf1{
	public void add(int a, int b);
}

@FunctionalInterface
interface Interf2{
	public int getLength(String s);
}

@FunctionalInterface
interface Interf3{
	public int squareNumber(int x);
}

public class Demo2 {

	public static void main(String[] args) {
		Interf1 i1 = (a,b) -> System.out.println("Sum = " + (a+b));
		i1.add(5, 5);
		i1.add(40, 60);
		
		Interf2 i2 = s -> s.length();
		System.out.println("Length = " + i2.getLength("hello"));
		
		Interf3 i3 = x -> (x*x);
		System.out.println("Square = " + i3.squareNumber(5));
		
	}
	
}

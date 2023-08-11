package LambdaExpressions;
@FunctionalInterface
interface Interf{
	public void m1();
}
public class Demo1{

	public static void main(String[] args) {
		
		Interf i = () -> System.out.println("m1 method Lambda Expression implementation");
		i.m1();
		
	}

}

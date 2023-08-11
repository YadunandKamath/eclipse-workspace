package OOPS;

public class AbstractExtension extends AbstractClass {
	
	@Override
	void method2() {
		System.out.println("Extended Abstract class method 2");
	}

	public static void main(String[] args) {
		AbstractExtension ax = new AbstractExtension();
		AbstractClass.method1();
		ax.method2();

	}

}

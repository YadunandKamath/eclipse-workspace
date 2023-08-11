package OOPS;

public class Child extends Parent {

	@Override
	void method1() {
		System.out.println("Child - simple method 1");
	}
	
	public static void main(String[] args) {
		Child ch = new Child();
		ch.method1();
		Child.method2();
		ch.method3();
		Child.method4();
	}

}

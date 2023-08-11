package OOPS;

public interface Interface1 {
	abstract void Imethod1();
	void Imethod2();
	default void Imethod3() {
		System.out.println("Default interface method3");
	}
	static void Imethod4() {
		System.out.println("Static interface method4");
	}
}

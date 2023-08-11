package OOPS;

public class ImplementedClass implements Interface1 {	

	@Override
	public void Imethod1() {
		System.out.println("Implemented abstract method 1 with \"abstract\" keyword");
	}
	@Override
	public void Imethod2() {
		System.out.println("Implemented abstract method 2");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplementedClass i = new ImplementedClass();
		i.Imethod1();
		i.Imethod2();
		i.Imethod3();
		Interface1.Imethod4();
		Interface1 i1 = new ImplementedClass();
		i1.Imethod1();
		i1.Imethod2();
		i1.Imethod3();
	}

}

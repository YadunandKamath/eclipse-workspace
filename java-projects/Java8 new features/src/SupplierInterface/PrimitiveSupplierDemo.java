package SupplierInterface;

import java.util.function.IntSupplier;

public class PrimitiveSupplierDemo {

	public static void main(String[] args) {
		
		IntSupplier s = () -> 10;
		System.out.println(s.getAsInt());

	}

}

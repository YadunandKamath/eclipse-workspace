package SupplierInterface;

import java.util.Date;
import java.util.function.Supplier;

public class SupplierDemo {

	public static void main(String[] args) {
		
		Supplier<Date> getDate = () -> new Date();
		System.out.println("Current Date: " + getDate.get());
		
		Supplier<String> getName = () -> {
			String[] str = {"Sunny", "Bunny", "Chinny", "Vinny"};
			int x = (int)(Math.random() * 4);
			return str[x];
		};
		System.out.println("Random name: " + getName.get());
		
		Supplier<String> getOTP = () -> {
			String otp = "";
			for(int i=0;i<6;i++) {
				otp += (int)(Math.random()*10);
			}
			return otp;
		};
		System.out.println("Random OTP: " + getOTP.get());
		
		Supplier<String> getPassword = () -> {
			String pwd = "";
			Supplier<Integer> d = () -> (int)(Math.random()*10);
			String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZ@#$";
			Supplier<Character> s = () -> symbols.charAt((int)(Math.random()*29));
			
			for(int i=1; i<=8; i++) {
				if(i%2==0) {
					pwd += d.get();
				}
				else {
					pwd += s.get();
				}
			}
			
			return pwd;			
		};
		System.out.println("Random password: " + getPassword.get());
		
	}

}

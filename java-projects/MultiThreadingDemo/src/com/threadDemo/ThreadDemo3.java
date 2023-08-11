package com.threadDemo;

class myThread3 extends Thread{
	
	public void run() {
		System.out.println("Child thread");
	}
}

public class ThreadDemo3{

	public static void main(String[] args) {
		
		myThread3 mt = new myThread3();
		Thread t3 = new Thread(mt);
		t3.start();
		System.out.println("Main Thread");

	}

}

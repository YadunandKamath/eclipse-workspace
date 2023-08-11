package com.threadDemo;

class myThread2 extends Thread {
	
	public void start() {
		super.start();
		System.out.println("Start method");
	}
	
	public void run() {
		System.out.println("Run method");
	}
}

public class ThreadDemo2 {

	public static void main(String[] args) {
		
		myThread2 t2 = new myThread2();
		t2.start();
		System.out.println("Main method");

	}

}

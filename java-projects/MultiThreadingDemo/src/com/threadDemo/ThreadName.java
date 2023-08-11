package com.threadDemo;

class myThreadName extends Thread {
	
	public void run() {
		System.out.println("run method executed by thread: " + Thread.currentThread().getName());
	}
	
}


public class ThreadName {

	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getName());
		Thread tn = new Thread();
		System.out.println(tn.getName());
		tn.setName("NewThread");
		System.out.println(tn.getName());
		myThreadName mtn = new myThreadName();
		mtn.start();
		System.out.println("main method executed by thread: " + Thread.currentThread().getName());
		

	}

}

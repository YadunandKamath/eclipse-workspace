package com.threadDemo;

class myRunnable implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("Child thread");
		}
	}
	
}

public class RunnableDemo {

	public static void main(String[] args) {
		
		myRunnable r1 = new myRunnable();
		Thread t = new Thread(r1);
		t.start();
		for(int i=0;i<10;i++) {
			System.out.println("Main thread");
		}

	}

}

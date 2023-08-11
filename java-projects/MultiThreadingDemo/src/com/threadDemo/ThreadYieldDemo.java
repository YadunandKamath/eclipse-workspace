package com.threadDemo;

class myThreadYield extends Thread {
	
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("child thread");
		}
		Thread.yield();
	}
	
}

public class ThreadYieldDemo {

	public static void main(String[] args) {
		
		myThreadYield my = new myThreadYield();
		my.start();
		for(int i=0;i<10;i++) {
			System.out.println("main thread");
		}

	}

}

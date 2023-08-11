package com.threadDemo;

class myThreadJoin extends Thread {
	
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("child thread");
			try {
				Thread.sleep(1000);
			}
			catch(Exception e) {
				
			}
		}
	}
}


public class ThreadSleepDemo {

	public static void main(String[] args) throws InterruptedException {
		
		myThreadJoin mj = new myThreadJoin();
		mj.start();
		mj.join(10000);
		for(int i=0;i<10;i++) {
			System.out.println("main thread");
		}

	}

}

package com.threadDemo;

class myThreadInterrupt extends Thread {
	
	public void run() {
		
		try {
			for(int i=0;i<5;i++) {
				System.out.println("lazy thread");
				Thread.sleep(1000);
			}
		}
		catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
	}
	
}

public class ThreadInterruptDemo {

	public static void main(String[] args) {
		
		myThreadInterrupt mti = new myThreadInterrupt();
		mti.start();
		mti.interrupt();
		System.out.println("end of main");

	}

}

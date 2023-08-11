package com.threadDemo;

class myThreadMain extends Thread {
	
	static Thread mt;
	
	public void run() {
		try {
			mt.join();
		}
		catch (Exception e) {
			
		}
		for(int i=0;i<10;i++) {
			System.out.println("child thread");
		}
	}
	
}

public class MainThreadReference {

	public static void main(String[] args) throws InterruptedException {
		
		myThreadMain.mt = Thread.currentThread();
		myThreadMain mtm = new myThreadMain();
		mtm.start();
		for(int i=0;i<5;i++) {
			System.out.println("main thread");
			Thread.sleep(1000);
		}
		
	}

}

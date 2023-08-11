package com.threadDemo;

class myDaemonThread extends Thread {

	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("child thread");
			try {
				Thread.sleep(500);
			}
			catch(Exception e){}
		}
	}
}


public class DaemonDemo {

	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().isDaemon());
		myDaemonThread dt = new myDaemonThread();
		System.out.println(dt.isDaemon());
		dt.setDaemon(true);
		System.out.println(dt.isDaemon());
		dt.start();
		System.out.println("main thread ends");
	}

}

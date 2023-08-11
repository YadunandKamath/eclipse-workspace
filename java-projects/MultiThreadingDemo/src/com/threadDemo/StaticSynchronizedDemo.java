package com.threadDemo;

class DisplayAgain {
	
	public static synchronized void greet(String name) {
		for(int i=0;i<5;i++) {
			System.out.print("Hello ");
			try {
				Thread.sleep(1000);
			}
			catch (Exception e) {
			}
			System.out.println(name);
		}
	}
	
}

class mySyncThread2 extends Thread {
	
	DisplayAgain da;
	String name;
	public mySyncThread2(DisplayAgain da, String name) {
		this.da = da;
		this.name = name;
	}
	public void run() {
		da.greet(name);
	}
	
}

public class StaticSynchronizedDemo {

	public static void main(String[] args) {

		DisplayAgain da1 = new DisplayAgain();
		DisplayAgain da2 = new DisplayAgain();
		mySyncThread2 mst21 = new mySyncThread2(da1,"A");
		mySyncThread2 mst22 = new mySyncThread2(da2,"B");
		mst21.start();
		mst22.start();

	}

}

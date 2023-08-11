package com.threadDemo;

class Display {
	
	public synchronized void greet(String name) {
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

class mySyncThread extends Thread {
	
	Display d;
	String name;
	public mySyncThread(Display d, String name) {
		this.d = d;
		this.name = name;
	}
	public void run() {
		d.greet(name);
	}
	
}

public class SynchronizedDemo {

	public static void main(String[] args) {
		
		Display d = new Display();
		mySyncThread mst1 = new mySyncThread(d,"A");
		mySyncThread mst2 = new mySyncThread(d,"B");
		mst1.start();
		mst2.start();

	}

}

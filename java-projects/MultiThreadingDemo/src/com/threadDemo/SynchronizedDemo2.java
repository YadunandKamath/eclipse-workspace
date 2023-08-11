package com.threadDemo;

class Display2 {
	
	public synchronized void displayn() {
		for(int i=0;i<10;i++) {
			System.out.print(i);
			try {
				Thread.sleep(200);
			}
			catch (Exception e) {
			}
		}
		
	}
	public synchronized void displayc() {
		for(int i=65;i<75;i++) {
			System.out.print((char)i);
			try {
				Thread.sleep(200);
			}
			catch (Exception e) {
			}
		}
		
	}
	
}

class myNumberThread extends Thread {
	
	Display2 dd;
	public myNumberThread(Display2 dd) {
		this.dd =dd;
	}
	public void run() {
		dd.displayn();
	}
	
}

class myCharThread extends Thread {
	
	Display2 dd;
	public myCharThread(Display2 dd) {
		this.dd =dd;
	}
	public void run() {
		dd.displayc();
	}
	
}

public class SynchronizedDemo2 {

	public static void main(String[] args) {
		
		Display2 dd = new Display2();
		myNumberThread nt = new myNumberThread(dd);
		myCharThread ct = new myCharThread(dd);
		nt.start();
		ct.start();
		
	}

}

package com.threadDemo;

class ThreadB extends Thread {
	
	int total = 0;
	public void run() {
		
		synchronized (this) {
			for(int i=0;i<100;i++) {
				total = total + i;
			}
			System.out.println("notification call");
			this.notify();
		}	
	}
}

public class InterThreadCommDemo {

	public static void main(String[] args) throws Exception {
		
		ThreadB b = new ThreadB();
		b.start();
		//Thread.sleep(0,1);
		//b.join();
		synchronized (b) {
			System.out.println("wait method");
			b.wait();
		}
		System.out.println(b.total);

	}

}

package com.threadDemo;

public class ThreadPriorityDemo {

	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getName() + " thread priority = " + Thread.currentThread().getPriority());
		Thread childThread1 = new Thread();
		System.out.println(childThread1.getName() + " priority = " + childThread1.getPriority());	
		Thread.currentThread().setPriority(7);
		Thread childThread2 = new Thread();
		System.out.println(Thread.currentThread().getName() + " thread priority = " + Thread.currentThread().getPriority());
		System.out.println(childThread1.getName() + " priority = " + childThread1.getPriority());
		System.out.println(childThread2.getName() + " priority = " + childThread2.getPriority());

	}

}

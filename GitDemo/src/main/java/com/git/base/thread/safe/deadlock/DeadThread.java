package com.git.base.thread.safe.deadlock;

public class DeadThread implements Runnable{

	public static Object lockone = new Object();
	
	public static  Object locktwo = new Object();

	private static boolean flag=true;
	
	@Override
	public void run() {
		if(flag){
			flag = false;
			synchronized (lockone) {
				LockOne one = new LockOne();
				one.say();
				try{
					Thread.sleep(600);
				}catch(Exception e){
					e.printStackTrace();
				}
				synchronized (locktwo) {
					one.get();
				}
			}
			
		}else{
			flag = true;
			synchronized (locktwo) {
				LockTwo two = new LockTwo();
				two.say();
				try{
					Thread.sleep(600);
				}catch(Exception e){
					e.printStackTrace();
				}
				synchronized (lockone) {
					two.get();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		DeadThread deadThread1 = new DeadThread();
		DeadThread deadThread2 = new DeadThread();
		Thread thread1 = new Thread(deadThread1);
		Thread thread2 = new Thread(deadThread2);
		thread1.start();
		thread2.start();
		System.err.println("dead lock show one demo");
	}
	
	
	
	
	
}

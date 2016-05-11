package com.git.base.thread.safe;

public class TicketMain {
/**
 * 线程安全问题的产生: 多个线程共同操作相同的共享变量时 由于控制条件无法跨域线程进行控制导致的变量操作问题
 * 解决: 对于控制条件和变量操作加上锁的限制,这部分发生线程安全问题的部分由多线程变为单线程来处理
 * <p>Title: main</p>
 * <p>Description: </p>
 * @param args
 */
	public static void main(String[] args) {
		//启动三个线程进行买票
		TicketDemo t = new TicketDemo();
		Thread thread1 = new Thread(t);
		Thread thread2= new Thread(t);
		Thread thread3 = new Thread(t);
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		
	}

}

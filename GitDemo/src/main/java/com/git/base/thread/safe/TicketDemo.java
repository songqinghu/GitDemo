package com.git.base.thread.safe;
/**
 * 原型类  启动多线程 共享变量
 * <p>Title: TicketDemo.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年5月5日下午11:42:40
 * @version 1.0
 */
public class TicketDemo  implements Runnable{

	private int ticket = 10;
	
	
	@Override
	public void run() {
		//启动多线程进行买票处理
		
		for (int i = 0; i < 100; i++) {
			//synchronized (this) {
//				if(ticket>0){
//					try {
//						Thread.sleep(100);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//					System.out.println(Thread.currentThread().getName() + " 卖出门票,编号: " + ticket--);
//				}
			 print();
			//}
		}
	}
	
	private synchronized void print(){
		if(ticket>0){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " 卖出门票,编号: " + ticket--);
	 }
	}

}

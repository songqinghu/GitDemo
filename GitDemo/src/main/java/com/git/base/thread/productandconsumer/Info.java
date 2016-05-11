package com.git.base.thread.productandconsumer;

/**
 * 中间信息类-核心类!!!
 * 生产者进行生产及消费者进行消费
 * 生产者消费者模式的解决点在中间过渡物体类中
 * 保证中间类的线程唯一性 从而解决多线程问题
 * 什么是多线程问题?其实就是多线程变为单线程再某些点上!
 * <p>Title: Info.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年5月9日下午10:42:08
 * @version 1.0
 */
public class Info {

	private String name;
	
	private String content;

	
	private boolean flag = false;
	
/*	1变
	public synchronized void set(String name,String content){
		this.name = name;
		this.content = content;
	}
	
	public synchronized void get(){
		System.out.println(this.name +" =====" + this.content);
	}
*/	
	
	
	public synchronized void set(String name,String content){
		if(flag){
			try {
				super.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			this.name = name;
			this.content = content;
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			flag = true;
			super.notify();
		
	}
	
	public synchronized void get(){
		if(!flag){
			try {
				super.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			System.out.println(this.name +" =====" + this.content);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			flag = false;
			super.notify();
		
		
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}

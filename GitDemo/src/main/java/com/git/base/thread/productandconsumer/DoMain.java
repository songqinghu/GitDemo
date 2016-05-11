package com.git.base.thread.productandconsumer;
/**
 * 核心实现:
 * 生产者消费者模式:
 * 生产一个,消费一个,如果生产未被消费,那么就等待消费后再生产
 * 如果消费后,没有下一个生产的,就等待生产后在消费
 * <p>Title: DoMain.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年5月9日下午10:59:51
 * @version 1.0
 */
public class DoMain {

	public static void main(String[] args) {
		Info info = new Info();
		ProductInfo product = new ProductInfo(info);
		ConsumerInfo consumer = new ConsumerInfo(info);
		
		Thread t1 = new Thread(product);
		Thread t2 = new Thread(consumer);
		t1.start();
		t2.start();
	}
}

package com.git.base.thread.productandconsumer;

public class ConsumerInfo implements Runnable{

	private Info info;
	
	public ConsumerInfo(Info info) {
		this.info = info;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			info.get();
		}
	}

}

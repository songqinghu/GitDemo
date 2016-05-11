package com.git.base.thread.productandconsumer;

public class ProductInfo implements Runnable{

	
	private boolean flag = true;
	
	private Info info;

	public ProductInfo(Info info) {
		this.info = info;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
				if(flag){
					info.set("宋庆虎","喜欢分布式");
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					flag = false;
				}else{
					info.set("龙志建", "喜欢JAVA");
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					flag = true;	
				}
		}
	}

}

package com.git.base.designpatterns.proxy;
/**
 * 
 * <p>Title: ProxyReadBook.java</p>
 * <p>Description:读书的代理类 用于完成读书的主方法外的额外方法</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年5月3日下午10:46:05
 * @version 1.0
 */
public class ProxyReadBook implements ReadBook{

	private ReadBookInstance read;
	
	/**
	 * 重点在这里--这里在引申一下就是一个典型的AOP了
	 * <p>Title: read</p>
	 * <p>Description: </p>
	 * @see com.git.base.designpatterns.proxy.ReadBook#read()
	 */
	@Override
	public void read() {
		System.out.println("获取到书籍 准备进行读取!");
		read.read();//读书主方法
		System.out.println("读书结束 书籍归位处理!");
	}

	public ReadBookInstance getRead() {
		return read;
	}

	public void setRead(ReadBookInstance read) {
		this.read = read;
	}

}

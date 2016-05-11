package com.git.base.designpatterns.proxy;

public class ProxyTest {

	public static void main(String[] args) {
		
		ReadBookInstance read = new ReadBookInstance();
		ProxyReadBook proxy = new ProxyReadBook();
		proxy.setRead(read);
		proxy.read();
		
	}
}

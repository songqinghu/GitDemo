package com.git.base.designpatterns.proxy;

public class ReadBookInstance  implements ReadBook{

	@Override
	public void read() {
		System.out.println("读书ing");
	}

}

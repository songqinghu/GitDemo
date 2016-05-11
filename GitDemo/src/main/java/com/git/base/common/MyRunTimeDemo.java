package com.git.base.common;

import java.io.IOException;

public class MyRunTimeDemo {

	public static void main(String[] args) throws IOException {
		
		Runtime runtime = Runtime.getRuntime();
		
		//runtime.exec("notepad.exe");
		
		runtime.gc();
		System.out.println("freeMemory : "+runtime.freeMemory());
		
	}
	
}

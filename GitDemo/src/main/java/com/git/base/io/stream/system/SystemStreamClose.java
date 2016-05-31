package com.git.base.io.stream.system;

import java.io.PrintStream;

public class SystemStreamClose {

	public static void main(String[] args) {
		
		PrintStream out = System.out;
		
		out.close();
		
		System.out.println("ddd");
		
		System.err.println("ddd");
		
	}
	
}

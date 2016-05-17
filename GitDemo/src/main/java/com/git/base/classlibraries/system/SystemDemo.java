package com.git.base.classlibraries.system;

import java.io.Console;
import java.io.IOException;
import java.nio.channels.Channel;

public class SystemDemo {

	public static void main(String[] args) throws IOException {
		
		System.err.println("err ");
		System.out.println("err ");
		
		//Console console = System.console();
		
		//Map<String, String> envs = System.getenv();
		//Set<String> set = envs.keySet();
		//for (String key : set) {
		//	System.err.println(key +" " + envs.get(key));
		//}
		
		//System.identityHashCode("one  "+new SystemDemo());
		//System.out.println("two  "+new SystemDemo().hashCode());
		//Channel channel = System.inheritedChannel();
		//.out.println(channel.isOpen());
		
		long nanoTime = System.nanoTime();
		System.out.println(nanoTime);
		
		
		
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
}

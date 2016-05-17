package com.git.base.classlibraries.runtime;

import java.util.Properties;
import java.util.Set;

import org.springframework.core.env.SystemEnvironmentPropertySource;

public class RuntimeDemo {

	public static void main(String[] args) {
		
		
		Runtime runtime = Runtime.getRuntime();
		Thread hook = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("runtimedemo thread start!");
			}
		});
		//新的虚拟机返回钩子
		//runtime.addShutdownHook(hook );
		
		int num = runtime.availableProcessors();
		System.out.println("处理器数目: "+num);
		
		//runtime.exit(-1);
		System.out.println("是否退出!");
		long freeMemory = runtime.freeMemory();
		System.out.println("空余内存: \t"+freeMemory/1024/1024+"M");
		long maxMemory = runtime.maxMemory();
		System.out.println("maxMemory内存: \t"+maxMemory/1024/1024+"M");
		long totalMemory = runtime.totalMemory();
		System.out.println("totalMemory内存: \t"+totalMemory/1024/1024+"M");
		runtime.gc();

		Properties p = System.getProperties();
		Set<Object> keys = p.keySet();
		for (Object key : keys) {
			Object value = p.get(key);
			System.out.println(key+"\t "+value);
		}
	}
}

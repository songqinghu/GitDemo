package com.git.base.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

import org.omg.CORBA.FREE_MEM;

/**
 * 定时调度类的演示
 * <p>Title: TimerDemo.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年5月24日下午10:07:42
 * @version 1.0
 */
public class TimerDemo {

	
	public static void main(String[] args) {
		
		doTimeOutputDate();
		
	}
	
	//1s后 输出时间
	private static void doOutputDate(){
		
		Timer timer = new Timer();
		//1s后执行 只执行一次
		MyTask myTask = new MyTask();
		timer.schedule(myTask, 1000);
		System.out.println(format());
		
	}
	//每三秒输出一次
	private static void doTimeOutputDate(){
		
		Timer timer = new Timer();
		//1s后执行 只执行一次
		MyTask myTask = new MyTask();
		timer.schedule(myTask,0,3000);
		//System.out.println(format());
	}
	public static String format(){
		SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(new Date());
		return time;
	}
	
	
}

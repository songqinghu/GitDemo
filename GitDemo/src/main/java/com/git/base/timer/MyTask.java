package com.git.base.timer;

import java.util.TimerTask;

/**
 * 定时任务类
 * <p>Title: MyTask.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年5月24日下午10:07:23
 * @version 1.0
 */
public class MyTask extends TimerTask{

	
	
	@Override
	public void run() {
		System.out.println(TimerDemo.format());
	}

}

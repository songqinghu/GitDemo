package com.git.base.classlibraries.date;

import java.util.Arrays;
import java.util.Calendar;

public class CalendarDemo {

	public static void main(String[] args) {

		Calendar c = Calendar.getInstance();
		int i = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(i);
		//Arrays.sort(null);优化后的快速排序
	}

}

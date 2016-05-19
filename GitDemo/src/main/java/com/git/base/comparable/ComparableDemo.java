package com.git.base.comparable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 比较器的使用演示:
 * 规则 比较分数 大的在前面 分数相同比较年龄,年龄小的在前面
 * 年龄相同,返回相同
 * <p>Title: ComparableDemo.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年5月18日下午9:23:53
 * @version 1.0
 */
public class ComparableDemo {

	public static void main(String[] args) {
		
		ArrayList<Student> list = new ArrayList<Student>();
		
		list.add(new Student("王虎", 14, 80));
		list.add(new Student("雷虎", 12, 90));
		list.add(new Student("风虎", 15, 70));
		list.add(new Student("虎", 11, 100));
		list.add(new Student("赵虎", 13, 80));
		
		Collections.sort(list,new ComparatorStudent());
		
		for (Student student : list) {
			
			System.out.println(student);
			
		}
		
		Student[] stu  = {
				new Student("王虎", 14, 80),
				new Student("雷虎", 12, 90),
				new Student("风虎", 15, 70),
				new Student("宋庆虎", 11, 100),
				new Student("赵虎", 13, 80)
		};
		
		Arrays.sort(stu);
		
		for (Student student : stu) {
			//System.err.println(student);
		}
		
		
	}
	
	
}

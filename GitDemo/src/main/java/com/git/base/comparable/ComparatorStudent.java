package com.git.base.comparable;

import java.util.Comparator;
/**
 * 比较学生
 * <p>Title: ComparatorStudent.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年5月19日上午12:01:16
 * @version 1.0
 */
public class ComparatorStudent implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		
		if(o1.equals(o2)){
			return 0;
		}else if (o1.getScore() > o2.getScore()) {
			return -1;
		}else if (o1.getScore() < o2.getScore()) {
			return 1;
		}else{
			if(o1.getAge()<o2.getAge()){
				return -1;
			}else if (o1.getAge() > o2.getAge()) {
				return 1;
			}
		}
		return 0;
	}

}

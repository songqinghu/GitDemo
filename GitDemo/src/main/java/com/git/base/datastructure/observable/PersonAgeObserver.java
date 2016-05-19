package com.git.base.datastructure.observable;

import java.util.Observable;
import java.util.Observer;

/**
 * 人类年龄变化监听器
 * <p>Title: PersonAgeObserver.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年5月19日下午11:43:37
 * @version 1.0
 */
public class PersonAgeObserver implements Observer{

	@Override
	public void update(Observable o, Object age) {
		System.out.println(this + "  变化后年龄为 " + age);
	}



}

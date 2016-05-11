package com.git.base.designpatterns.adapter;
/**
 * 适配器核心类  --实现了所有的方法的默认方法 提供给子类进行特殊的复写
 * <p>Title: AbstractLiveAdapter.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年5月3日下午10:56:59
 * @version 1.0
 */
public abstract class AbstractLiveAdapter implements LiveAdapter{

	@Override
	public String eat() {
		return null;
	}

	@Override
	public String sleep() {
		return null;
	}

	@Override
	public String grow() {
		return null;
	}
	
}

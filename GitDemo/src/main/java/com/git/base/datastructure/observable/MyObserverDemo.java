package com.git.base.datastructure.observable;
/*
 * 演示类
 */
public class MyObserverDemo {

	public static void main(String[] args) {
		
		PersonObservable master = new PersonObservable();
		
		PersonAgeObserver ageObserver = new PersonAgeObserver();
		PersonAgeObserver ageObserver2 = new PersonAgeObserver();
		master.addObserver(ageObserver);
		master.addObserver(ageObserver2);
		master.setUpdate("Sage", 22);
		
		
	}
}

package com.git.base.datastructure.link;

/**
 * 
 * <p>Title: LinkTest.java</p>
 * <p>Description: 测试链表结构的使用</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年4月28日下午11:16:06
 * @version 1.0
 */
public class LinkTest {

	public static void main(String[] args) {
		
		LinkNode link = new LinkNode();
		
		link.addNode("A");
		link.addNode("B");
		link.addNode("C");
		link.addNode("D");
		link.addNode("E");
		
		link.printNode();
		
		System.out.println(link.contains("D"));
		System.out.println("=========");
		link.deleteNode("B");		
		link.printNode();
		System.out.println("=========");
		link.deleteNode("A");		
		link.printNode();
	}
	
	
}

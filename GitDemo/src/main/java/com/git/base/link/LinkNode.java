package com.git.base.link;

/**
 * 
 * <p>Title: LinkNode.java</p>
 * <p>Description:链表结构自定义练习类 </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2016年4月28日下午10:36:19
 * @version 1.0
 */
public class LinkNode {

	private Node root;//根节点
	
	
	public void addNode(String data){
		Node node = new Node(data);
		if(this.root==null){//根节点如果为null那么就将新增的节点添加到根节点中
			this.root =node;
		}else{//如果存在根节点,那么进行递归调用类中的方法进行添加节点
			this.root.addNode(node);
		}
	}
	
	public boolean contains(String data){
		
		if(this.root.data.equals(data)){//根节点是该节点 直接返回
			return true;
		}else{//如果根节点不是,那么继续向下找!
			return this.root.contains(data);
		}
	}
	
	
	public void deleteNode(String data){
		if(contains(data)){//如果包含这个节点在进行删除操作
			
			if(this.root.data.equals(data)){//根节点是这个节点--改变根节点的引用
				this.root = this.root.next;
			}else{//不是根节点--递归的查找 改变引用
				root.deleteNode(data);
			}
			
		}
	}
	
	
	public void printNode(){
		if(this.root !=null){
			this.root.printNode();
		}
	}
	
	
	public  class Node{
		
		private String data;//这个节点存的数据
		
		private Node next;//下一个节点的引用
		
		Node(String data){
			this.data = data;
		}
		
		
		
		public void printNode() {
			System.out.println("data:  "+this.data);
			if(this.next!=null){
				this.next.printNode();
			}
		}



		//增加一个节点
		public void addNode(Node node){
			
			if(this.next == null){//如果下个引用中没有被填充,那么就添加到这里
				this.next=node;
			}else{//如果下个节点已经有了,那么继续进行递归的添加
				this.next.addNode(node);
			}
			
		}
		//是否包含指定节点
		public boolean contains(String data){
			if(this.next ==null){
				return false;
			}else{
				if(this.next.data.equals(data)){
					return true;
				}else{
					return this.next.contains(data);
				}
			}
		}
		
		//删除一个节点
		public void deleteNode(String data){
			if(this.next.data.equals(data)){//如果是下个节点是要删除的节点
				this.next =this.next.next;//如果最后是null 那就指向null
			}else{
				this.next.deleteNode(data);
			}
		}
		
	}
	
}

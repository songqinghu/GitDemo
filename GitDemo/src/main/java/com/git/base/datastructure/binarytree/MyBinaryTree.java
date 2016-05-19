package com.git.base.datastructure.binarytree;

public class MyBinaryTree {

	private MyTreeNode root;
	
	
	public  void add(Comparable data){
		MyTreeNode node = new MyTreeNode();
		node.data = data;
		if(root ==null){
			root =node;
		}else{
			root.addNode(node);
		}
	}
	
	public void print(){
		root.printNode();
	}
	
	
	
	class MyTreeNode{
		
		private Comparable data;
		
		private MyTreeNode left;
		
		private MyTreeNode right;
		
		
		public void addNode(MyTreeNode node){
			
			if(node.data.compareTo(this.data)<0){// -1 代表当前的小于传入的
				if(left ==null){
					left = node;
				}else{
					left.addNode(node);
				}
			}else{
				if(right ==null){
					right =	node;
				}else{
					right.addNode(node);
				}
			}
			
		}
		
		
		public void printNode(){//输出节点 从最小左边开始
			
			if(this.left != null){//存在左节点就打印左节点
				this.left.printNode();
			}
			
			System.out.println(this.data);//只有一个输出
			
			if(this.right !=null){
				this.right.printNode();
			}
			
		}
		
		
	}
	
}

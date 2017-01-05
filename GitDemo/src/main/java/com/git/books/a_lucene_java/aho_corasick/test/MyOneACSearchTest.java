package com.git.books.a_lucene_java.aho_corasick.test;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

/**
 * <p>Title: MyOneACSearchTest.java</p>
 * <p>Description:测试 一个小时写一个ac自动机 </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: Sage</p>
 * @author 五虎将
 * @date 2017年1月5日上午8:19:34
 * @version 1.0
 */
public class MyOneACSearchTest {

	//构建树
	//设置失败指针
	//搜索过程

	public MyOneACSearchTest(String[] keywords) {
		buildTree(keywords);
		addFailure();
	}
	private TreeNode root;
	
	private void addFailure() {
		//设置二层失败指针为根节点 收集三层节点
		
		//DFA遍历所有节点 设置失败节点 原则: 节点的失败指针在父节点的失败指针的子节点中查找 最大后缀匹配 
		ArrayList<TreeNode> mid = new ArrayList<TreeNode>();//过程容器
		for (TreeNode node : root.getSonsNode()) {
			node.failure = root;
			for (TreeNode treeNode : node.getSonsNode()) {
				mid.add(treeNode);
			}
		}
		
		//广度遍历所有节点设置失败指针 1.存在失败指针 2.不存在到root结束
		while(mid.size()>0){
			ArrayList<TreeNode> temp = new ArrayList<TreeNode>();//子节点收集器
			
			for (TreeNode node : temp) {
				
				TreeNode r = node.getParent().failure;
				
				while(r!=null && !r.containNode(node.getChar())){
					r = r.failure;//没有找到,保证最大后缀 (最后一个节点字符相同)
				}
				
				//是根结
				if(r==null){
					node.failure = root;
				}else{
					node.failure = r.getSonNode(node.getChar());
				}
				
				//收集子节点
				for (TreeNode treeNode : node.getSonsNode()) {
					temp.add(treeNode);
				}
				
			}
			mid = temp;
		}
		
	}

	private void buildTree(String[] keywords) {
		root = new TreeNode(null, ' ');
		//判断节点是否存在 存在转移 不存在添加
		for (String word : keywords) {
			TreeNode temp = root;
			for (char ch : word.toCharArray()) {
				if(temp.containNode(ch)){
					temp = temp.getSonNode(ch);
				}else{
					TreeNode newNode = new TreeNode(temp, ch);
					temp.addSonNode(newNode);
					temp = newNode;
				}
			}
			temp.addResult(word);
		}
	}


	class TreeNode{
		
		private TreeNode parent;
		
		private TreeNode failure;
		
		private char ch;
		
		private ArrayList<String> results;
		
		private Hashtable<Character, TreeNode> sonsHash;
		
		private TreeNode[] sonsNode;
		
		
		public TreeNode(TreeNode parent,char ch) {
			
			this.parent = parent;
			this.ch = ch;
			results = new ArrayList<String>();
			sonsHash = new Hashtable<Character,TreeNode>();
			sonsNode = new TreeNode[]{};
		}
		
		//添加子节点
		public void addSonNode(TreeNode node){
			sonsHash.put(node.ch, node);
			sonsNode = new TreeNode[sonsHash.size()];
			Iterator<TreeNode> iterator = sonsHash.values().iterator();
			for (int i = 0; i < sonsNode.length; i++) {
				if(iterator.hasNext()){
					sonsNode[i] = iterator.next();
				}
			}
		}
		
		//获取子节点中指定字符节点
		public TreeNode getSonNode(char ch){
			return sonsHash.get(ch);
		}
		
		//判断子节点中是否存在该字符
		public boolean containNode(char ch){
			return getSonNode(ch) !=null;
		}
		
		//添加一个结果到结果字符中
		public void addResult(String result){
			if(!result.contains(result)) results.add(result);
		}
		
		//获取字符
		public char getChar(){
			return ch;
		}
		
		//获取父节点
	    public TreeNode getParent(){
	    	return parent;
	    }
	    //设置失败指针并且返回
	    public TreeNode setFailure(TreeNode failure){
	    	this.failure = failure;
	    	return this.failure;
	    }
	    
	    //获取所有的孩子节点
	    public TreeNode[] getSonsNode(){
	    	return sonsNode;
	    }
	    //获取搜索的字符串
	    public ArrayList<String> getResults(){
	    	return results;
	    }
	}
}

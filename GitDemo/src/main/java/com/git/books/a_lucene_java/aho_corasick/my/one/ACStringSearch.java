package com.git.books.a_lucene_java.aho_corasick.my.one;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import com.git.books.a_lucene_java.aho_corasick.StringSearchResult;

/**
 * 
 * @Description: ac自动机搜索类  实现敏感词过滤  先创建一个trie树 然后设置trie查找的上层跳转引用
 * @author: songqinghu
 * @date: 2017年1月3日 下午2:14:32
 * Version:1.0
 */
public class ACStringSearch {

    public static void main(String[] args) {
        
        String[] keywords = new String[]{"我是好人","我是坏人","好人","坏人"};
        ACStringSearch search = new ACStringSearch(keywords);
        StringSearchResult[] findAll = search.findAll("我是好人吗?这事需要问问自己,人能分成好人坏人吗?这恐怕谁也无法解答");
        for (StringSearchResult result : findAll) {
            System.out.println(result.keyword());
        }
        
    }
    private TreeNode root;//根节点
    
     //构建 和 查找 两个过程!
     public ACStringSearch(String[] keywords) {
         //加载词库 --先跳过
         //构建树
         buildTree(keywords);
         //设置回退引用
         addFailure();
     }
    //逐层设置失败指针   
    private void addFailure() {
        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
        //设置第二层节点的回退节点为根节点且保存该节点进行遍历循环
        for (TreeNode sonNode : root.getSonsNode()) {
            sonNode.lastNode = root;
            for (TreeNode treeNode : sonNode.getSonsNode()) {
                nodes.add(treeNode);
            }
        }
        
        //遍历二层以后的节点直到树被遍历完毕
        while(nodes.size()>0){
            ArrayList<TreeNode> temp = new ArrayList<TreeNode>();//收集下层的节点
            for (TreeNode treeNode : nodes) {
                TreeNode r = treeNode.getParent().lastNode;
                char c = treeNode.nodeChar;
                
                while(r!=null && !r.containsSonNode(c)){
                    r = r.lastNode;
                }
                
                if(r==null){
                    treeNode.lastNode = root;
                }else{
                    //存在回退节点
                    treeNode.lastNode = r.getSonNode(c);
                    for (String result : treeNode.lastNode.getResults()) {
                        treeNode.addResult(result);
                    }
                }
                //下次循环
                for (TreeNode node : treeNode.getSonsNode()) {
                    temp.add(node);
                }
                
            }
            nodes = temp;
        }
        
        root.lastNode = root;
        
    }
    //为每个节点构建一条树路径 考虑已经存在的节点情况
    private void buildTree(String[] keywords) {
        root = new TreeNode(null, ' ');
        for (String word : keywords) {
            TreeNode temp = root;
            for (char ch : word.toCharArray()) {
                TreeNode newNd = null;
                for (TreeNode node : temp.sonsNode) {
                    if(node.nodeChar==ch){
                        newNd = node;
                        break;
                    }
                }
                if(newNd ==null){
                    newNd = new TreeNode(temp, ch);
                    temp.addSonNode(newNd);
                }
                temp = newNd;
            }
            temp.addResult(word);
        }
    }

    //查找过程
    public StringSearchResult[] findAll(String text){
        
        ArrayList<StringSearchResult> ret = new ArrayList<StringSearchResult>();
        
        TreeNode mid = root;
        
        int index =0;
        
        while(index<text.length()){
            TreeNode temp =null;
            while(temp==null){
                temp = mid.getSonNode(text.charAt(index));
                if(mid ==root){
                    break;
                }
                if(temp ==null){
                    mid = mid.lastNode;
                }
            }
            
            if(temp !=null) mid = temp;//节点前进
            //找到 结果添加到结果集中
            for (String result : mid.getResults()) {
                ret.add(new StringSearchResult(index, result));
            }
            index++;
        }
        return ret.toArray(new StringSearchResult[ret.size()]);
    }
    




    //节点内部类
    class TreeNode{
        
        private char nodeChar;//节点单位词
        
        private TreeNode lastNode;//失败后的跳转节点
        
        private TreeNode parentNode;//父节点
        
        private ArrayList<String> results;//模式串的数组变量
        
        private TreeNode[] sonsNode;//孩子节点们
        
        private Hashtable<Character, TreeNode> sonsHash;//孩子节点的哈希表
        
        public TreeNode(TreeNode parentNode,char nodeChar) {
            this.parentNode = parentNode;
            this.nodeChar = nodeChar;
            results = new ArrayList<String>();
            sonsNode = new TreeNode[]{};
            sonsHash = new Hashtable<Character,TreeNode>();
        }
        
        //将不在匹配结果中的添加进来
        public void addResult(String result){
            if(!results.contains(result)) results.add(result);
        }
        
        //添加孩子节点
        public void addSonNode(TreeNode son){
            sonsHash.put(son.nodeChar, son);//添加
            TreeNode[] temp = new TreeNode[sonsHash.size()];//转移
            
            Iterator<TreeNode> iterator = sonsHash.values().iterator();
            for (int i = 0; i < temp.length; i++) {
                if(iterator.hasNext()){
                    temp[i] = iterator.next();
                }
            }
            sonsNode = temp;
        }
        
        //获取指定孩子节点
        public TreeNode getSonNode(char c){
            return sonsHash.get(c);
        }
        //判断节点是否存在
        public boolean containsSonNode(char c){
            return getSonNode(c) !=null;
        }
        //设置失败的跳转节点并且进行返回
        public TreeNode getLastNode(TreeNode node){
             this.lastNode = node;
             return lastNode;
        }
        //获取孩子节点们
        public TreeNode[] getSonsNode(){
            return sonsNode;
        }
        //获取规则数组
        public ArrayList<String> getResults(){
            return results;
        }
        
        //获取父节点
        public TreeNode getParent(){
            return parentNode;
        }
    }
}

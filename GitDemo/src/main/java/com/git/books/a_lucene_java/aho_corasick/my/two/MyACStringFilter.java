package com.git.books.a_lucene_java.aho_corasick.my.two;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import com.git.books.a_lucene_java.aho_corasick.my.StringSearchResult;

/**
 * @Description: 基于AC自动机的字符串中敏感词识别
 * 步骤:
 * 1.构造trie数
 * 2.构建节点的失败指针 --- 基于最大后缀的转移匹配规则 ----节点的父节点的失败指针的子节点为转移节点
 * 3.构建查找过程 查找到继续推进节点,查找不到转移到失败指针指向的节点直到为root节点
 * @author: songqinghu
 * @date: 2017年1月4日 下午3:53:33
 * Version:1.0
 */
public class MyACStringFilter {
    public static void main(String[] args) {
        
        String[] keywords = new String[]{"我是好人","我是坏人","好人","坏人","世界","那么大","世界那么大","大"};
        MyACStringFilter search = new MyACStringFilter(keywords);
        StringSearchResult[] findAll = search.findAll("我是好人吗?这事需要问问自己,人能分成好人坏人吗?这恐怕谁也无法解答.世界那么大,给你的想法那么大,我们世界里,只能想想大而已");
        for (StringSearchResult result : findAll) {
            System.out.println(result.keyword() + " : " +result.index());
        }
        
    }
    private TreeNode root;
    
    public MyACStringFilter(String[] keywords) {
        //构建树
        buildTree(keywords);
        //添加失败指针
        addFailure();
    }
    
    private void addFailure() {
        //二级节点的失败节点为父节点  子节点的失败节点为父节点的失败节点的子节点
        
        ArrayList<TreeNode> mid = new ArrayList<TreeNode>();
        
        for (TreeNode node : root.sonsNode) {
            node.failure = root;
            for (TreeNode treeNode : node.sonsNode) {
                mid.add(treeNode);
            }
        }
        
        //三级节点后需要做DFA依次设置失败指针
        while(mid.size()>0){
            ArrayList<TreeNode> temp = new ArrayList<TreeNode>();
            for (TreeNode treeNode : mid) {
                
                TreeNode r = treeNode.getParent().getFailture();
                
                char ch = treeNode.nodeChar;
                
                while(r!=null && !r.containSonNode(ch)){
                    r = r.failure;
                }
                
                if(r ==null){//没有找到失败指针
                    treeNode.failure = root;
                }else{
                    treeNode.failure = r.getSonNode(ch);
                    
//                    for (String result : treeNode.failure.results) {
//                        treeNode.addResult(result);
//                    }
                    
                }
                
                for (TreeNode node : treeNode.sonsNode) {
                    temp.add(node);
                }
            }
            mid=temp;
        }
        root.failure = root;
    }
    private void buildTree(String[] keywords) {
        root = new TreeNode(null, ' ');
        for (String word : keywords) {
                TreeNode temp = root;
            for (char ch : word.toCharArray()) {
                TreeNode newNode =null;
                for (TreeNode node : temp.sonsNode) {
                    if(node.nodeChar ==ch){
                        newNode = node;
                        break;
                    }
                }
                
                if(newNode ==null){
                    newNode = new TreeNode(temp, ch); 
                    temp.addSonNode(newNode);
                }
                temp = newNode;
            }
            //一个分支结束
            temp.addResult(word);
        }
    }

    //查找所有的模式匹配串
    public StringSearchResult[] findAll(String text){
        ArrayList<StringSearchResult> stringResults = new ArrayList<StringSearchResult>();
        int index =0;
        TreeNode mid = root;
        while(index <text.length()){
              TreeNode temp =null;
              while(temp==null){
                  temp = mid.getSonNode(text.charAt(index));
                  if(mid ==root){
                      break;
                  }
                  if(temp ==null){
                      temp = mid.failure;
                  }
              }

              if(temp !=null) mid = temp; //查找到 节点前进
              
              for (String result : mid.results) {
                   stringResults.add(new StringSearchResult(index -result.length()+1, result));
              }
              
            index++;
        }
        return stringResults.toArray(new StringSearchResult[stringResults.size()]);
    }
    
    
    
    
    //树的节点
    class TreeNode{
        
        private TreeNode parent;//父节点
        
        private TreeNode failure;//失败指针
        
        private char nodeChar;//节点字节
        
        private ArrayList<String> results;//节点结果集合
        
        private Hashtable<Character, TreeNode> sonsHash;//孩子节点 hash查找
        
        private TreeNode[] sonsNode;//孩子节点们
        
        public TreeNode(TreeNode parent,char ch) {
            this.parent = parent;
            this.nodeChar = ch;
            results = new ArrayList<String>();
            sonsHash = new Hashtable<Character,TreeNode>();
            sonsNode = new TreeNode[]{};
        }
        
        //添加一个节点到孩子节点中
        public void addSonNode(TreeNode node){
            sonsHash.put(node.nodeChar,node);
            sonsNode = new TreeNode[sonsHash.size()];
            Iterator<TreeNode> iterator = sonsHash.values().iterator();
            for (int i = 0; i < sonsNode.length; i++) {
                if(iterator.hasNext()){
                    sonsNode[i] = iterator.next();
                }
            }
        }
        
        //获得指定的孩子节点
        public TreeNode getSonNode(char ch){
            return sonsHash.get(ch);
        }
        
        //判断是否存在孩子节点
        public boolean containSonNode(char ch){
            return getSonNode(ch) !=null;
        }
        
        //获取父节点
        public TreeNode getParent(){
            return parent;
        }
        
        //获取失败指针w
        public TreeNode getFailture(){
            return failure;
        }
        
        //添加字符结果
        public void addResult(String result){
            if(results.contains(result)) return;
            results.add(result);
        }
        
        
        
    }
}

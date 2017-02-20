package com.git.books.a_lucene_java.aho_corasick.my;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

/**
 * 
 * @Description: Aho_Corasick算法实现查找节点是否存在
 * @author: songqinghu
 * @date: 2016年12月29日 上午8:52:17
 * Version:1.0
 * http://www.cnblogs.com/xudong-bupt/p/3433506.html
 * https://segmentfault.com/a/1190000000484127
 * Aho-Corasick算法是多模式匹配中的经典算法，目前在实际应用中较多。
        求出模式集合{"nihao","hao","hs","hsr"}在给定文本"sdmfhsgnshejfgnihaofhsrnihao"中所有可能出现的位置。
　　使用Aho-Corasick算法需要三步：

　　1.建立模式的Trie

　　2.给Trie添加失败路径

　　3.根据AC自动机，搜索待处理的文本

   AC自动机的精髓在于失配指针！失配指针的构建方法是这样的：
        对于一个节点C，标识字符a，顺着C的父亲节点的失配指针走，走到第一个有儿子也是a的节点T那么C的失配指针就指向T的标识a的儿子节点。
        如果找不到这个节点，那么失配指针指向Root。在实际操作时，是用广搜来实现，因为这个建构过程要求父亲节点的失配指针已经建好，
        而且一层层都要建好。代码如下：

 */
public class TreeNode {

    private char _char;//节点代表的字符
    
    private TreeNode _parent;//该节点的父节点
    
    public TreeNode _failure;//匹配失败后跳转的节点
    
    private ArrayList<String> _results;//存储模式串的数组变量
    
    private TreeNode[] _transitionsAr;//孩子节点们
    
    private Hashtable<Character, TreeNode> _transHash;////存储孩子节点的哈希表
    
    
    public TreeNode(TreeNode parent,char c){
        this._char = c;
        this._parent = parent;
        this._results = new ArrayList<String>();
        this._transitionsAr = new TreeNode[]{};
        this._transHash = new Hashtable<Character,TreeNode>();
    }
    //将模式串中不在匹配结果中的添加进来
    public void addResult(String result){
        if(!_results.contains(result)) _results.add(result);
    }
    //添加孩子节点
    public void addTransition(TreeNode node){
        _transHash.put(node._char, node);
        TreeNode[] ar = new TreeNode[_transHash.size()];
        Iterator<TreeNode> iterator = _transHash.values().iterator();
        for (int i = 0; i < ar.length; i++) {
            if(iterator.hasNext()){
                ar[i] = iterator.next();
            }
        }
        _transitionsAr = ar;
    }
    
    //获取节点
    public TreeNode getTransition(char c){
        return _transHash.get(c);
    }
    //判断节点是否存在
    public boolean containsTransition(char c){
        return getTransition(c) !=null;
    }
    
    public char getChar(){
        return _char;
    }
    
    public TreeNode getParent(){
        return _parent;
    }
    
    public TreeNode failure(TreeNode node){
        _failure = node;
        return _failure;
    }
    
    public TreeNode[] transitions(){
        
        return _transitionsAr;
    }
    
    public ArrayList<String> results(){
        return _results;
    }
}

















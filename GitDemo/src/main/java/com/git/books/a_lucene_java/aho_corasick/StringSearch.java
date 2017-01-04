package com.git.books.a_lucene_java.aho_corasick;

import java.util.ArrayList;

import org.assertj.core.util.ToString;

/**
 * @Description: 字符搜索过程
 * @author: songqinghu
 * @date: 2016年12月29日 上午9:31:46
 * Version:1.0
 */
public class StringSearch {

    public static void main(String[] args) {
        String[] keywords = {"我是好人","我是坏人","好人","坏人"};
        StringSearch stringSearch = new StringSearch(keywords);
        StringSearchResult[] findAll = stringSearch.findAll("我是好人吗?这事需要问问自己,人能分成好人坏人吗?这恐怕谁也无法解答");
        for (StringSearchResult stringSearchResult : findAll) {
            System.out.println(stringSearchResult.keyword() + " : " + stringSearchResult.index());
        }
        System.out.println(stringSearch.toString());
    }
    
    private TreeNode _root;//根节点
    
    public StringSearch(String[] keywords) {
        buildTree(keywords);//构建树
        addFailure();//增加失败匹配属性
    }

    private void addFailure() {
        //所有词的第n个字节点的集合,n从2开始
        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
        //所有词的第2个字节点的集合
        for(TreeNode nd : _root.transitions()){
            nd.failure(_root);
            for(TreeNode trans : nd.transitions()){
                nodes.add(trans);
            }
        }
        
        //所有词的第n +1 个字节点的集合
        while(nodes.size() !=0){
            ArrayList<TreeNode> newNodes = new ArrayList<>();
            for (TreeNode nd : nodes) {
                TreeNode r = nd.getParent()._failure;
                char c = nd.getChar();
                
                //如果在父节点的失败节点的孩子节点中没有同样的字符结尾的则继续在失败的节点的失败节点中查找
                while(r!=null && !r.containsTransition(c)){
                    r=r._failure;
                }
                if(r ==null){
                    nd._failure = _root;
                }else{
                    nd._failure = r.getTransition(c);
                    for (String result : nd._failure.results()) {
                        nd.addResult(result);
                    }
                }
                
                for (TreeNode child : nd.transitions()) {
                    newNodes.add(child);
                }
                
            }
            nodes = newNodes;
        }
        _root._failure = _root;
        
    }
    private void buildTree(String[] keywords) {
        _root = new TreeNode(null,' ');
        
        for (String p : keywords) {
           TreeNode nd = _root;
           
           for (char c : p.toCharArray()) {
               TreeNode ndNew = null;
               for (TreeNode   trans : nd.transitions()) {
                   if(trans.getChar() ==c){
                       ndNew = trans;
                       break;
                   }
               }
               if(ndNew ==null){
                   ndNew = new TreeNode(nd,c);
                   nd.addTransition(ndNew);
               }
               nd = ndNew;
           }
           nd.addResult(p);
        }
    }
    //深度遍历搜索
    public void depthSearch(TreeNode node,StringBuilder ret,int deapth){
        
        if(node !=null){
            for (int i = 0; i < deapth; i++) {
                ret.append("| ");
            }
            ret.append("|--");
            ret.append(node.getChar() + "\n");
            for (TreeNode child : node.transitions()) {
                int childDeapth = deapth +1;//计算深度并且赋值
                depthSearch(child, ret, childDeapth);
            }
        }
    }
    //打印数节点
    public String toString(){
        StringBuilder ret = new StringBuilder();
        ret.append("打印数节点: \n");
        int deapth =0;
        depthSearch(_root, ret, deapth);
        return ret.toString();
    }
    
    //从输入文本中查找关键词集合过程
    public StringSearchResult[] findAll(String text){
        
        ArrayList<StringSearchResult> ret = new ArrayList<>();
        
        TreeNode ptr = _root;
        
        int index =0;
        
        while(index <text.length()){
            TreeNode trans =null;
            while(trans==null){
                trans = ptr.getTransition(text.charAt(index));
                if(ptr == _root){
                    break;
                }
                if(trans ==null){
                    ptr =ptr._failure;
                }
            }
            if(trans !=null) ptr =trans;
            //增加找到的没一个词到结果中
            for (String found : ptr.results()) {
                ret.add(new StringSearchResult(index -found.length() +1,found));
            }
            index++;
        }
        return ret.toArray(new StringSearchResult[ret.size()]);
    }
}

package com.git.books.c_algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {

    public static void main(String[] args) {

    }

    //广度优先搜索
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
     
        //结果
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(root ==null){
            return result;
        }
        
        int lastNum = 1;//上层节点数目
        int curNum = 0; //本层节点数目统计
        int level = 0;//深度
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while(queue.size()>0){
            
            TreeNode node = queue.pop();
            lastNum--;//上层节点数取出1
            if(result.size()<=level){
                result.add(new ArrayList<Integer>());
            }
            
            result.get(level).add(node.val);
            
            if(node.left !=null){
                queue.add(node.left);
                curNum++;
            }
            
            if(node.right !=null){
                queue.add(node.right);
                curNum++;
            }
            
            if(lastNum == 0){//如果上层节点遍历完了,那么要继续遍历下一层
                lastNum = curNum;
                curNum = 0;
                level++;
            }
        }
        
        Collections.reverse(result);//倒叙输出
        return result;
    }
}

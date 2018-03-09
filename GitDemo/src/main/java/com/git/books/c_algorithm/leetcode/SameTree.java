package com.git.books.c_algorithm.leetcode;

public class SameTree {

    public static void main(String[] args) {

    }

    //树的遍历 结束条件
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        if(p==null && q ==null){
            return true;
        }
        
        if(p ==null || q ==null){
            return false;
        }
        
        if(p.val != q.val){
            return false;
        }
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
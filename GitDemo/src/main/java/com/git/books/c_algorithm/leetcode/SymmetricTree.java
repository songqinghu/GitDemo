package com.git.books.c_algorithm.leetcode;

public class SymmetricTree {

    public static void main(String[] args) {

    }
    
    //树的遍历--->结束条件
    public boolean isSymmetric(TreeNode root) {
        
        if(root ==null){
            return true;
        }
        return isSymmetricHelp(root.left, root.right);
    }

    public boolean isSymmetricHelp(TreeNode left,TreeNode right){
        if(left ==null && right ==null){
            return true;
        }
        if(left ==null ||right ==null){
            return false;
        }
        if(left.val !=right.val){
            return false;
        }
        //左右对称
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }
    
}

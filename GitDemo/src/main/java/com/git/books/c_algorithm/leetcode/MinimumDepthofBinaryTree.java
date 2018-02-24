package com.git.books.c_algorithm.leetcode;

public class MinimumDepthofBinaryTree {

    public static void main(String[] args) {

    }
    //深度优先  维护最小深度
    public int minDepth(TreeNode root) {
        
        if(root ==null){//递归结束
            return 0;
        }   
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(left!=0 && right!=0){
            return Math.min(left, right)+1;//当前节点最小深度
        }
        if(left ==0){
            return right+1;
        }
        
        return left+1;
    }
}

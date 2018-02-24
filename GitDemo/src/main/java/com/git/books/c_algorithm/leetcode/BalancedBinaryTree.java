package com.git.books.c_algorithm.leetcode;

public class BalancedBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        BalancedBinaryTree b = new BalancedBinaryTree();
        System.out.println(b.isBalanced(root));
    }
    //递归  深度优先  维护深度
    public boolean isBalanced(TreeNode root) {
        return isBalancedHelp(root) >=0;
    }
    
    public int isBalancedHelp(TreeNode root){
        if(root ==null){ //递归正常结束条件
            return 0;
        }
        int left = isBalancedHelp(root.left);//深度
        int right = isBalancedHelp(root.right);//同层 right
        if(left < 0 || right <0){ //不平衡提前结束条件
            return -1;
        }
        if(Math.abs(left - right)>1){//判断是否不平衡
            return -1;
        }
        return Math.max(left, right)+1;//维护到当前节点最大深度
    }
}

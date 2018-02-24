package com.git.books.c_algorithm.leetcode;

public class PathSum {

    public static void main(String[] args) {
        PathSum ps = new PathSum();
        ps.hasPathSum(new TreeNode(1), 1);
    }

    //深度优先  维护要完成的剩余目标值
    public boolean hasPathSum(TreeNode root, int sum) {
       
        if(root ==null){//以最后空接点作为递归结束
            return false;
        }
        //满足题意的结束条件
        if(root.left ==null && root.right ==null && root.val == sum){
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val) ;
    }

}

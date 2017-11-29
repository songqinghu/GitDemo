package com.git.books.c_algorithm.leetcode;

public class ClimbingStairs {

    public static void main(String[] args) {

        System.out.println(climbStairs(6));
    }
    //斐波那契数列f(n) = f(n-1) + f(n -2)
    public static int climbStairs(int n) {
        if(n ==1){
          return 1;
        }
        if(n ==2){
          return 2;
        }
        int f1 = 1;
        int f2 = 2;
        for (int i = 3; i <=n; i++) {
            int f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f2;
       // return climbStairs(n-1) + climbStairs(n-2);
    }
}

package com.git.books.c_algorithm.leetcode;

public class BestTimetoBuyandSellStock {

    public static void main(String[] args) {

    }
    //动态规划
    public int maxProfit(int[] prices) {
        //[7, 1, 5, 3, 6, 4]

        int local = 0;
        int global = 0;
        
        for (int i = 0; i < prices.length-1; i++) {
            local = Math.max(local+prices[i+1] - prices[i],0);//当前为止最优解
            global = Math.max(local, global);
        }
        return global;
    }
    
}

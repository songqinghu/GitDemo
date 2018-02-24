package com.git.books.c_algorithm.leetcode;

public class BestTimetoBuyandSellStockII {

    public static void main(String[] args) {

    }
    //累加
    public int maxProfit(int[] prices) {
        //[7, 1, 5, 3, 6, 4]
        int price = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if(prices[i]<prices[i+1]){//当日买明天卖是否赚钱
                price = price +prices[i+1] - prices[i];
            }
        }
        return price;
    }
    
}

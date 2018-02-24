package com.git.books.c_algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {

    }
    
    //维护上一行和当前行
    public List<List<Integer>> generate(int numRows) {
       
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        
        ArrayList<Integer> pre = new ArrayList<>();
        
        pre.add(1);
        
        for (int i = 0; i < numRows; i++) {
            
            ArrayList<Integer> cur = new ArrayList<Integer>();
            cur.add(1);
            for (int j = 1; j < pre.size(); j++) {
                cur.add(pre.get(j-1) +pre.get(j));
            }
            cur.add(1);
            
            result.add(pre);
            
            pre = cur;
        }
        
        return result;
    }
}

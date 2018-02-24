package com.git.books.c_algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {

    public static void main(String[] args) {

    }
    
    //从后向前
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> cur = new ArrayList<Integer>();
        cur.add(1);
        for (int i = 0; i < rowIndex; i++) {
            
            for (int j = cur.size()-1; j >0; j--) {
                cur.set(j, cur.get(j)+cur.get(j-1));
            }
            cur.add(1);
        }
        return cur;
    }
    
}

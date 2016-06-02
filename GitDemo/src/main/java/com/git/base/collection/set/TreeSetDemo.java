package com.git.base.collection.set;

import java.util.TreeSet;

public class TreeSetDemo {

    public static void main(String[] args) {
        
        
        TreeSet<Integer> tree = new TreeSet<Integer>();
        
        tree.add(1);
        tree.add(2);
        tree.add(4);
        
        for (Integer i : tree) {
            System.out.println(i);
        }
        //treeset 排序的底层原理
//        do {
//            parent = t;
//            cmp = cpr.compare(key, t.key);
//            if (cmp < 0)
//                t = t.left;
//            else if (cmp > 0) 
//                t = t.right;
//            else
//                return t.setValue(value);
//        } while (t != null);
//        final int compare(Object k1, Object k2) {
//            return comparator==null ? ((Comparable<? super K>)k1).compareTo((K)k2)
//                : comparator.compare((K)k1, (K)k2);
//        }
        
    }
}

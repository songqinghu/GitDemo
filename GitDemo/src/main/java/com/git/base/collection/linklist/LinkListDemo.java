package com.git.base.collection.linklist;

import java.util.LinkedList;

public class LinkListDemo {

    public static void main(String[] args) {
        
        LinkedList<Integer> link = new LinkedList<Integer>();
        
        //FIFO
        link.add(1);
        link.add(2);
        link.add(3);
        link.add(4);
        link.add(5);

        for (Integer out : link) {
            System.out.println(out);
        }
        
        
        
    }
}

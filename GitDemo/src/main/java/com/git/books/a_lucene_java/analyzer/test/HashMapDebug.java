package com.git.books.a_lucene_java.analyzer.test;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @Description: hashmap执行过程追踪
 * @author: songqinghu
 * @date: 2017年2月14日 下午7:29:26
 * Version:1.0
 */
public class HashMapDebug {

    
    public static void main(String[] args) {
        
        System.out.println(100 & 15);
        
        
        
        Map<String, String> maps = new HashMap<String,String>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 2000000; i++) {
            maps.put(i+"", "xx"+i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end -start);
        for (int i = 0; i < 10000; i++) {
            maps.get("325875");
        }
        System.out.println(System.currentTimeMillis() - end);
        
        
    }
    
}

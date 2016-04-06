package com.git.test;

import com.git.utils.MD5Utils;
import com.git.utils.WordCountCache;

/**
 * 测试map能存储的键值对大小
 * @author songqinghu
 *
 */
public class MapSizeTest {

    
    public static void main(String[] args) throws InterruptedException {
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 1000000; i++) {
                WordCountCache.putCount(MD5Utils.MD5(i+""),1111);
                System.out.println(i);
            }
            Thread.sleep(1000);;
            WordCountCache.clear();
            System.out.println(j);
        }
        
        System.out.println("===========OVER==================");
        
    }
    
    
}

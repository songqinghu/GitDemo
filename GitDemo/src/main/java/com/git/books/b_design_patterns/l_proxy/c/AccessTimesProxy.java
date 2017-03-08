package com.git.books.b_design_patterns.l_proxy.c;
/**
 * @Description: 具体类
 * @author: songqinghu
 * @date: 2017年3月8日 下午6:18:58
 * Version:1.0
 */
public class AccessTimesProxy implements AccessTimes {

    @Override
    public void access() {
        System.out.println("your access the bloging");
    }

}

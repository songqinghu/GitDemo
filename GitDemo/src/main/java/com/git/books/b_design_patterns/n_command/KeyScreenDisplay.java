package com.git.books.b_design_patterns.n_command;
/**
 * @Description: 屏幕打印操作
 * @author: songqinghu
 * @date: 2017年3月10日 上午11:43:40
 * Version:1.0
 */
public class KeyScreenDisplay implements ScreenDisplay {

    @Override
    public void printKey(String key) {
        System.out.println("the screen print : " + key);
    }

}

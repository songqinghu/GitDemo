package com.git.books.b_design_patterns.j_facade;

public class Heater {
    //打开热水器
    public void openHeater(){
        System.out.println("the Heater is open!");
    }
    //洗澡
    public void bathe(){
        System.out.println("You are taking a bath!");
    }
    //关闭热水器
    public void closeHeater(){
        System.out.println("the Heater is close!");
    }
}

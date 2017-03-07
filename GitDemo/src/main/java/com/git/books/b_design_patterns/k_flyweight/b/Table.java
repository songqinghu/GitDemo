package com.git.books.b_design_patterns.k_flyweight.b;
/**
 * @Description: 外部状态,咖啡将要被送到的桌子信息
 * @author: songqinghu
 * @date: 2017年3月7日 下午8:16:35
 * Version:1.0
 */
public class Table {

    private int number;
    
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Table(int number) {
        this.number = number;
    }
    
    
}

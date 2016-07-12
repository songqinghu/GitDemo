package com.git.digget;

import java.math.BigDecimal;

public class ONe {

    public static void main(String[] args) {
        
        String listPrice = "123456799";
        String straightPrice = "1234468.0";
        BigDecimal multiply = new BigDecimal(straightPrice).multiply(new BigDecimal(100));
        System.out.println(multiply);
        BigDecimal subtract = new BigDecimal(listPrice).subtract(multiply);
        String valueOf = String.valueOf(subtract);
        System.out.println(valueOf);
        String value="123446799";
        
        BigDecimal divide = new BigDecimal(String.valueOf(value)).divide(new BigDecimal(100));
        System.out.println(divide);
        
    }
}

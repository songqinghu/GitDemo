package com.git.test;

public class Demo {

    public static void main(String[] args) {

        Double replyNumScore = normalization(0.94980025, 
                0.7598402, 
                4.298305, 
                0.0, 1.0);
        System.out.println(replyNumScore);
    }
    
    public static Double normalization(Double v, Double min, Double max, Double newMin, Double newMax) {
        return (v - min) / (max - min) * (newMax - newMin) + newMin;
    }
}

package com.git.books.b_design_patterns.a_abstract_factroy;

public class Car extends Vehicle {

    public Car() {
        
        System.out.println(" the car  is created!");
        
    }

    @Override
    public void run() {
        
        System.out.println("the car is run !");
    }
    
    
    
    
    
}

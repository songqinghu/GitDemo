package com.git.books.b_design_patterns.b_build.one;

public class Car {

    private String engine;
    
    private String tyre;
    
    
    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getTyre() {
        return tyre;
    }

    public void setTyre(String tyre) {
        this.tyre = tyre;
    }

    public void run(){
        System.out.println("the engine is :" +engine + "  the tyre is : " +tyre + " the car is run !");
    }

}

package com.git.books.b_design_patterns.p_iterator;

public class SomeThing {

    public SomeThing(String name) {
        this.name = name;
    }
    
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "the thing name: " + name + " ";
    }
    
    
}

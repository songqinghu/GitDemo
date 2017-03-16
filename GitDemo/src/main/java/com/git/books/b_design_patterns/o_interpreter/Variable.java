package com.git.books.b_design_patterns.o_interpreter;

public class Variable implements Expression {

    private String name;
    
    public Variable(String name) {
        this.name = name;
    }
    
    @Override
    public boolean interpreter(Context context) {
        
        return context.lookup(this);
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj !=null && obj instanceof Variable){
            
            return this.name.equals(((Variable)obj).name);
            
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }
    
    @Override
    public String toString() {
        return  name.toString();
    }

}

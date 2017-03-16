package com.git.books.b_design_patterns.o_interpreter;

public class And implements Expression {

    private Expression left;
    
    private Expression right;
    
    public And(Expression left,Expression right) {
        this.left = left;
        this.right = right;
    }
    
    
    @Override
    public boolean interpreter(Context context) {
        return left.interpreter(context) && right.interpreter(context);
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj !=null && obj instanceof And){
            return this.left.equals(((And)obj).left) && this.right.equals(((And)obj).right);
        }
        return false;
    }
    
    
    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }
    
    
    @Override
    public String toString() {
        return " ("+left.toString() +" And " + right.toString() + ") ";
    }
    
    

}

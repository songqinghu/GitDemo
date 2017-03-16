package com.git.books.b_design_patterns.o_interpreter;

public class Or implements Expression {

    private Expression left;
    
    private Expression right;
    
    public Or(Expression left,Expression right) {
        this.left = left;
        this.right = right;
    }
    
    @Override
    public boolean interpreter(Context context) {
        return left.interpreter(context) || right.interpreter(context);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj !=null && obj instanceof Or){
            return this.left.equals(((Or)obj).left) && this.right.equals(((Or)obj).right);
        }
        return false;
    }
    
    
    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }
    
    
    @Override
    public String toString() {
        return " ("+left.toString() +" Or " + right.toString() + ") ";
    }
    
    
    
}

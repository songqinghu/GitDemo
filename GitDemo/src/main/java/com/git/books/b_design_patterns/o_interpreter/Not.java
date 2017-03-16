package com.git.books.b_design_patterns.o_interpreter;

public class Not implements Expression {

    private Expression exp;
    
    public Not(Expression exp) {
        this.exp = exp;
    }
    
    @Override
    public boolean interpreter(Context context) {
        return  ! exp.interpreter(context);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj !=null && obj instanceof Not){
            return this.exp.equals(((Not)obj).exp) ;
        }
        return false;
    }
    
    
    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }
    
    
    @Override
    public String toString() {
        return " (Not "+exp.toString() +") ";
    }
    
    
}

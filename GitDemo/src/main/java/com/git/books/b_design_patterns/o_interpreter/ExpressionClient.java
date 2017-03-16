package com.git.books.b_design_patterns.o_interpreter;

public class ExpressionClient {

    public static void main(String[] args) {
        
        Context context = new Context();
        Variable a = new Variable("a");
        Variable b = new Variable("b");
        Variable c = new Variable("c");
        context.assgin(a, true);
        context.assgin(b, false);
        context.assgin(c, false);
        
        Or result = new Or(new And(new Not(new Or(new Constant(true), a)), new Or(new Not(b), c)), new And(new Or(a, b), c));
        
        
        System.out.print(result.toString());
        System.out.print(" = ");
        System.out.println(result.interpreter(context));
        
        
        
        
    }
}

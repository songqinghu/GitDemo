package com.git.books.b_design_patterns.o_interpreter;
/**
 * @Description: 结束节点 要返回 true或者false
 * @author: songqinghu
 * @date: 2017年3月13日 下午7:55:22
 * Version:1.0
 */
public class Constant implements Expression {

    private Boolean constant;
    
    public Constant(Boolean constant) {
        this.constant = constant;
    }
    
    
    @Override
    public boolean interpreter(Context context) {
        return constant;
    }

    @Override
    public boolean equals(Object obj) {
        
        if(obj !=null && obj instanceof Constant){
            return constant == ((Constant) obj).constant;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        
        return this.toString().hashCode();
    }
    
    @Override
    public String toString() {
        return constant.toString();
    }
}

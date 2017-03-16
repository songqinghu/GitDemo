package com.git.books.b_design_patterns.o_interpreter;

import java.util.HashMap;
import java.util.Map;
/**
 * @Description: 解释器环境类
 * @author: songqinghu
 * @date: 2017年3月13日 下午7:41:18
 * Version:1.0
 */
public class Context {

    private Map<Variable, Boolean> contexts = new HashMap<Variable, Boolean>();
    
    public void assgin(Variable variable,Boolean flag){
        contexts.put(variable, flag);
    }
    
    public boolean lookup(Variable variable){
        Boolean result = contexts.get(variable);
        if(result !=null){
            return result;
        }else{
            throw new RuntimeException("the variable is not Definition" );
        }
    }
}

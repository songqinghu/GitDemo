package com.git.books.b_design_patterns.o_interpreter;
/**
 * @Description: 解释器顶级接口定义类
 * Expression :: Expression And Expression |
 *               Expression Or Expression  |
 *               Not Expression |
 *               Variable |
 *               Constant
 * 
 * @author: songqinghu
 * @date: 2017年3月13日 下午7:40:43
 * Version:1.0
 */
public interface Expression {

    /***
     * @描述：定义解释过程
     * @author: songqinghu
     */
    public boolean interpreter(Context context);
    
    
    @Override
    boolean equals(Object obj);
    
    @Override
    int hashCode();
    
    
    @Override
    String toString();
    
}

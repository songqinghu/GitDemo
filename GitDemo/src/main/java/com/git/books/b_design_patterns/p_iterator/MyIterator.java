package com.git.books.b_design_patterns.p_iterator;
/**
 * @Description: 迭代器顶级接口
 * @author: songqinghu
 * @date: 2017年3月16日 下午2:36:51
 * Version:1.0
 */
public interface MyIterator<T> {

    /**
     * @描述：移动光标 返回当前元素
     * @return T
     * @createTime：2017年3月16日
     * @author: songqinghu
     */
    public T next();
    /**
     * @描述：光标移动到第一个
     * @return void
     * @createTime：2017年3月16日
     * @author: songqinghu
     */
    public void first();
    /**
     * @描述：是否还有下一个
     * @return boolean
     * @createTime：2017年3月16日
     * @author: songqinghu
     */
    public boolean isDone();
    
}

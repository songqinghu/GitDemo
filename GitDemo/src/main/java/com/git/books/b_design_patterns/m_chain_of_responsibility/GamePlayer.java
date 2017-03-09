package com.git.books.b_design_patterns.m_chain_of_responsibility;
/**
 * @Description: 职责链模式  击鼓传花顶级接口类
 * @author: songqinghu
 * @date: 2017年3月9日 下午3:06:16
 * Version:1.0
 */
public interface GamePlayer {

    /**
     * @描述：游戏处理过程
     * @return void
     * @createTime：2017年3月9日
     * @author: songqinghu
     */
    public void gomeHandle();
    
    /**
     * @描述：传递给下一个用户
     * @return void
     * @createTime：2017年3月9日
     * @author: songqinghu
     */
     void next();
    
    
     public void setPlayer(GamePlayer player);
    
}

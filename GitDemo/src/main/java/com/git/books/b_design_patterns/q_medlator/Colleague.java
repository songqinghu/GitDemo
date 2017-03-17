package com.git.books.b_design_patterns.q_medlator;

public abstract class Colleague {

    private AgreementMedlator medlator;
    
    public Colleague(AgreementMedlator medlator) {
        this.medlator = medlator;
    }
    /**
     * @描述：子类行动方法
     * @return void
     * @exception
     * @createTime：2017年3月17日
     * @author: songqinghu
     */
    public abstract void action(Action action);
    /**
     * @描述：子类改变方法
     * @return void
     * @createTime：2017年3月17日
     * @author: songqinghu
     */
    public abstract void change(Change change);
    
    /**
     * @描述：返回当前协议对象
     * @return AgreementMedlator
     * @createTime：2017年3月17日
     * @author: songqinghu
     */
    public  AgreementMedlator getMedlator(){
        return this.medlator;
    }
    
}

/**
 * @Description: 改变操作
 * @author: songqinghu
 * @date: 2017年3月17日 下午7:40:24
 * Version:1.0
 */
enum Change{
    Join,SignOut,Activity        
}
/**
 * @Description: 具体行动指令
 * @author: songqinghu
 * @date: 2017年3月17日 下午7:43:22
 * Version:1.0
 */
enum Action{
    Expand,Fade,Exchange
}

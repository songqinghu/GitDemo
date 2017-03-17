package com.git.books.b_design_patterns.q_medlator;
/**
 * @Description:协议中介者
 * @author: songqinghu
 * @date: 2017年3月17日 下午7:25:01
 * Version:1.0
 */
public abstract class AgreementMedlator {

    /**
     * @描述：国家同事改变时触发具体处理
     * @param colleague
     * @return void
     * @createTime：2017年3月17日
     * @author: songqinghu
     */
    public abstract void countryColleagueChanged(Colleague colleague,Action action);
    
    
    
}

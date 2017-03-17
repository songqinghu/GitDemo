package com.git.books.b_design_patterns.q_medlator;
/**
 * @Description: 中介者模式测试类
 * @author: songqinghu
 * @date: 2017年3月17日 下午8:03:19
 * Version:1.0
 */
public class MedlatorClient {

    public static void main(String[] args) {
        
        AgreementMedlator medlator = new WTOAgreementMedlator();
        
        Colleague china = new ChinaColleague(medlator);
        
        Colleague america = new AmericaColleague(medlator);
        
        china.change(Change.Join);
        
        america.change(Change.Join);
        
        china.change(Change.Activity);
        
        america.change(Change.SignOut);
        
    }
    
    
}

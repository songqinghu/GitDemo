package com.git.books.b_design_patterns.q_medlator;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Description: WTO国际贸易协议
 * @author: songqinghu
 * @date: 2017年3月17日 下午7:58:12
 * Version:1.0
 */
public class WTOAgreementMedlator extends AgreementMedlator {

    private  Set<Colleague> colleagues = new HashSet<Colleague>();
    
    @Override
    public void countryColleagueChanged(Colleague colleague, Action action) {
        if(Action.Expand.equals(action)){
            colleagues.add(colleague);
        }else if(Action.Fade.equals(action)){
            colleagues.remove(colleague);
        }
        
        for (Colleague c : colleagues) {
            c.action(action);
        }
    }

}

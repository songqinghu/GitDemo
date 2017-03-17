package com.git.books.b_design_patterns.q_medlator;
/**
 * @Description: 中国伙伴
 * @author: songqinghu
 * @date: 2017年3月17日 下午7:37:58
 * Version:1.0
 */
public class ChinaColleague extends Colleague {

    private String name ="china";
    
    public ChinaColleague(AgreementMedlator medlator) {
        super(medlator);
    }

    @Override
    public void action(Action action) {
        //can create factroy process this action
        if(Action.Expand.equals(action)){
            System.out.println("the " + name + " expanding !");
        }else if(Action.Fade.equals(action)){
            System.out.println("the " + name + " backward !");
        }else{
            System.out.println("the " + name + " get some thing!");
        }
    }

    @Override
    public void change(Change change) {
        if(change ==null)
            throw new RuntimeException("the change can't null ");
        Action action ;
        if(Change.Join.equals(change)){
            action = Action.Expand;
        }else if(Change.SignOut.equals(change)){
            action = Action.Fade;
        }else{
            action = Action.Exchange;
        }
        this.getMedlator().countryColleagueChanged(this,action);
    }



}

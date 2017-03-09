package com.git.books.b_design_patterns.m_chain_of_responsibility;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Description: 责任链模式测试类
 * @author: songqinghu
 * @date: 2017年3月9日 上午11:52:33
 * Version:1.0
 */
public class ChainOfResponsibilityClient {
    
    private  Timer timer;
    
    public static void main(String[] args) {
        
        ChainOfResponsibilityClient client = new ChainOfResponsibilityClient();
        GamePlayer onePlayer =new OnePeoplePlayer("one people ",null);
        GamePlayer twoPlayer = new TwoPeoplePlayer("two people ",null);
        GamePlayer threePlayer = new ThreePeoplePlayer("three people ", null);
        GamePlayer fourPlayer = new FourPeoplePlayer("four people ", null);
        
        onePlayer.setPlayer(twoPlayer);
        twoPlayer.setPlayer(threePlayer);
        threePlayer.setPlayer(fourPlayer);
        fourPlayer.setPlayer(onePlayer);
        
        
        client.startGame(1000);
        onePlayer.gomeHandle();
        
        
        
        
    }
    
    public void startGame(int second){
        
        timer= new Timer();
        System.out.println("the timer task is start!");
        timer.schedule(new DrumsTimes(),second);
    }
    
    
    class DrumsTimes extends TimerTask{

        @Override
        public void run() {
            System.out.println("the timer task is end !");
            Drums.getInstance().getOrSetNoise("false");
            timer.cancel();
        }

       

    }
    
}

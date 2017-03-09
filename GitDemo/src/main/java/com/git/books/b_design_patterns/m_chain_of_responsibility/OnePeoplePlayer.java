package com.git.books.b_design_patterns.m_chain_of_responsibility;

import java.util.Random;

import org.apache.commons.lang.math.RandomUtils;

public class OnePeoplePlayer implements GamePlayer {

    private GamePlayer player;
    
    private String name ;
    
    public OnePeoplePlayer(String name,GamePlayer player) {
        this.player = player;
        this.name = name;
    }
    
    
    @Override
    public void gomeHandle() {
        try {
            Thread.sleep(RandomUtils.nextInt(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(Drums.getInstance().getOrSetNoise(null)){
            System.out.println(name + " is pass,the game is continue!");
            next();
        }else{
            //不同的类,这里的处理过程不同
            System.out.println(name + " is last people! the gome over!");
        }
    }

    @Override
    public void next() {
        if(player !=null){
            player.gomeHandle();
        }else{
            throw new RuntimeException(name);
        }
    }


    @Override
    public void setPlayer(GamePlayer player) {
        this.player = player;
    }

}

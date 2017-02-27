package com.git.books.b_design_patterns.d_prototype.one;

import java.io.Serializable;

/**
 * 
 * @Description: 宝马车引擎
 * @author: songqinghu
 * @date: 2017年2月27日 下午7:29:39
 * Version:1.0
 */
public class BMWCarEngine implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -8855588455186407728L;
    private String sound;

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
    
}

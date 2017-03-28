package com.git.books.b_design_patterns.v_template_method;
/**
 * @Description: 模板方法类 定义播放视频不同人的不同处理方式
 * @author: songqinghu
 * @date: 2017年3月28日 上午11:09:01
 * Version:1.0
 */
public abstract class WatchMovie {
    
    public void playMovie(){
        
        String ahead = doSomeThingAhead();
        
        String quality = doGetMoiveQuality();
        
        play(ahead, quality);
    }
    
    public abstract String doSomeThingAhead();
    
    public abstract String doGetMoiveQuality();
    
    private void play(String ahead,String quality){
        System.out.println(ahead + " cache "+quality + " start play");
    }
}

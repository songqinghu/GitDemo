package com.git.books.b_design_patterns.v_template_method;
/**
 * @Description: 模板方法测试类
 * @author: songqinghu
 * @date: 2017年3月28日 上午11:19:46
 * Version:1.0
 */
public class TemplateMethodClient {

    
    public static void main(String[] args) {
        
        WatchMovie watchMovie = new OrdinaryUserWatchMovie();
        
        watchMovie.playMovie();
        
        System.out.println("he Recharge members");
        
        watchMovie = new MemberUserWatchMovie();
        
        watchMovie.playMovie();
        
        
    }
    
    
}

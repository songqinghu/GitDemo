package com.git.books.b_design_patterns.v_template_method;
/**
 * @Description: 普通用户看电影
 * @author: songqinghu
 * @date: 2017年3月28日 上午11:16:39
 * Version:1.0
 */
public class OrdinaryUserWatchMovie extends WatchMovie {

    @Override
    public String doSomeThingAhead() {
        return " play some ad ";
    }

    @Override
    public String doGetMoiveQuality() {
        return " standard definition ";
    }

}

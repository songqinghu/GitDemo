package com.git.books.b_design_patterns.v_template_method;
/**
 * @Description: 会员用户看电影 没有广告 还能看到超清的
 * @author: songqinghu
 * @date: 2017年3月28日 上午11:18:03
 * Version:1.0
 */
public class MemberUserWatchMovie extends WatchMovie {

    @Override
    public String doSomeThingAhead() {
        return " no ad ";
    }

    @Override
    public String doGetMoiveQuality() {
        return " Super clear";
    }

}

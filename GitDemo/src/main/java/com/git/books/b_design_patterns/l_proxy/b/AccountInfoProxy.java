package com.git.books.b_design_patterns.l_proxy.b;
/**
 * @Description: 保护代理  账号信息顶级接口
 * @author: songqinghu
 * @date: 2017年3月8日 下午5:38:36
 * Version:1.0
 */
public interface AccountInfoProxy {

    /**
     * @描述：展示指定的用户信息
     * @param userId
     * @return void
     * @createTime：2017年3月8日
     * @author: songqinghu
     */
    public void showUserInfo(String userId);
}

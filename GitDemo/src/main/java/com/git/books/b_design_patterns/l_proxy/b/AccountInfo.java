package com.git.books.b_design_patterns.l_proxy.b;

public class AccountInfo implements AccountInfoProxy {

    @Override
    public void showUserInfo(String userId) {
        System.out.println("the user name is :xxx and The amount of the account is $100000 ");
    }

}

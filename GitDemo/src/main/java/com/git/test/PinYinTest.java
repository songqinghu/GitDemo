package com.git.test;

import java.util.Set;

import com.git.utils.SearchMachinUtils;

public class PinYinTest {

    public static void main(String[] args) {
        String[] matching = SearchMachinUtils.getMatching("盛世1234ksdjakl光明");
        for (String string : matching) {
            System.out.println(string);
        }
    }
}

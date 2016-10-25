package com.git.search.lightning.bean;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/**
 * term的查找字典
 * 使用 hash + 链表方式
 * B+树暂时不会
 * @Description: TODO
 * @author: songqinghu
 * @date: 2016年10月25日 下午5:37:58
 * Version:1.0
 */
public class TermFind {

    private static Map<Integer,LinkedList<IndexBean>> termdic = new HashMap<Integer,LinkedList<IndexBean>>();

    public static Map<Integer, LinkedList<IndexBean>> getTermdic() {
        return termdic;
    }

}

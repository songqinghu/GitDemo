package com.git.search.lightning.bean;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 一个文档的缓存数据
 * @Description: TODO
 * @author: songqinghu
 * @date: 2016年10月25日 下午6:08:39
 * Version:1.0
 */
public class OneDocCache {

    private static Map<String, List<Long>> cache = new HashMap<>();

    public static Map<String, List<Long>> getCache() {
        return cache;
    }
    
}

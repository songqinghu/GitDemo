package com.git.books.a_lucene_java.aho_corasick.my;
/**
 * 
 * @Description: 查询结果类
 * @author: songqinghu
 * @date: 2016年12月29日 上午11:32:02
 * Version:1.0
 */
public class StringSearchResult {

    private int _index;//所在位置
    private String _keyword;//关键词

    public StringSearchResult(int index, String keyword) {
        _index = index;
        _keyword = keyword;
    }

    public int index() {
        return _index;
    }

    public String keyword() {
        return _keyword;
    }
    
    

}

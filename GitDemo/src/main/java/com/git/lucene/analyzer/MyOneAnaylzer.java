package com.git.lucene.analyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.HMMChineseTokenizer;
import org.apache.lucene.analysis.core.LowerCaseFilter;
import org.apache.lucene.analysis.reverse.ReverseStringFilter;
import org.apache.lucene.analysis.standard.ClassicFilter;

/**
 * 
 * @Description: 第一个自定义分词器
 * @author: songqinghu
 * @date: 2016年12月7日 下午5:13:09
 * Version:1.0
 */
public class MyOneAnaylzer  extends Analyzer{

    /**
     * 重写这个方法  返回一个tokenStreamComponents 对象  
     * solr中提供的分词器的一般流程为
     *  一个  Tokenizer
     *  后跟着多个 filter对象
     *  或者重写 tokenStream 方法 在以前的版本中
     */
    @Override
    protected TokenStreamComponents createComponents(String fieldName) {
       
        //马尔科夫解析器
        MyOneTokenizer source = new MyOneTokenizer();
        //添加过滤器  -- tokenfilter 下
        TokenStream result = new ClassicFilter(source);
        result = new LowerCaseFilter(result);
        
        return new TokenStreamComponents(source, new ReverseStringFilter(result));
    }

}

package com.git.solr.tokenizer;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.analysis.core.KeywordAnalyzer;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.queryparser.surround.parser.ParseException;
import org.apache.lucene.search.Query;
import org.apache.lucene.util.Version;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.chenlb.mmseg4j.analysis.MMSegAnalyzer;

/**
 * 几种solr内部的分词器分词测试--加入汉语元素
 * @author songqinghu
 *
 */
public class TokenizerTreatsTextDemo {

    Version matchVersion ;
    @Before
    public void init(){
        System.out.println("start ! ");
        matchVersion =  Version.LUCENE_CURRENT;;
    }
    @Test //报错
    public void analyzer() throws IOException, ParseException, org.apache.lucene.queryparser.classic.ParseException{
        
      Analyzer analyzer = new SmartChineseAnalyzer();//org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer ;

      QueryParser parser = new QueryParser(matchVersion, "test", analyzer);        
      
      Query parse = parser.parse("这是一个测试的例子");
      
      System.out.println(parse);
                
    } 
    @Test //报错
    public void keywordTokenizer() throws IOException, ParseException, org.apache.lucene.queryparser.classic.ParseException{
        
        Analyzer analyzer = new MMSegAnalyzer();
        QueryParser parser = new QueryParser(matchVersion, "test", analyzer);        
        Query parse = parser.parse("这是一个测试的例子");
        System.out.println(parse.toString());
    } 
    

    
    
    @After
    public void destroy(){
        System.out.println("end !");
    }
    
    
}

package com.git.solr.tokenizer;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.KeywordAnalyzer;
import org.apache.lucene.analysis.ngram.NGramTokenizer;
import org.apache.lucene.queryparser.surround.parser.ParseException;
import org.apache.lucene.util.Version;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
    public void standardTokenizer() throws IOException, ParseException, org.apache.lucene.queryparser.classic.ParseException{
        
                String text = "测试ngram";
                
                StringReader reader = new StringReader(text);
        
                myAnalyzer a = new myAnalyzer();
                
                TokenStream tokenStream = a.tokenStream("c", reader);
                
                
        } 
    @Test //报错
    public void keywordTokenizer() throws IOException, ParseException, org.apache.lucene.queryparser.classic.ParseException{
        
        KeywordAnalyzer analyzer = new KeywordAnalyzer();
        Reader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream("eq ewre dsfa dsafd".getBytes())));
        TokenStream tokenStream = analyzer.tokenStream(null, reader);
        System.out.println(tokenStream.toString());
    } 
    
    private class myAnalyzer extends Analyzer{

        @Override
        protected TokenStreamComponents createComponents(String fieldName, Reader reader) {
            NGramTokenizer t ;
            try {
                String text = "测试ngram";
               t =  new NGramTokenizer();
               t.setReader(reader);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return new TokenStreamComponents(new NGramTokenizer());
        }
        
    }
    
    
    @After
    public void destroy(){
        System.out.println("end !");
    }
    
    
}

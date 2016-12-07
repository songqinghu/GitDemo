package com.git.lucene.analyzer;

import java.io.IOException;
import java.io.Reader;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.util.Attribute;
/**
 * 
 * @Description: 我的分析器
 * @author: songqinghu
 * @date: 2016年12月7日 下午6:37:14
 * Version:1.0
 */
public class MyOneTokenizer extends Tokenizer{

    private static MyTernarySearchTrie dic = new MyTernarySearchTrie("");//字典树
    
    private Attribute termAtt;//词属性
    
    private static final int IO_BUFFER_SIZE = 4096;
    
    private char[] ioBUffer  = new char[IO_BUFFER_SIZE];
    
    private boolean done;
    
    private int i =0;// 控制匹配的其实位置
    
    private int upto =0;
    
    
    public MyOneTokenizer(Reader reader) {
        setReader(reader);
        addAttribute(CharTermAttribute.class);
        this.done = false;
    }
    
    
    
    @Override
    public boolean incrementToken() throws IOException {
       
        
        
        
        
        
        
        return false;
    }

}

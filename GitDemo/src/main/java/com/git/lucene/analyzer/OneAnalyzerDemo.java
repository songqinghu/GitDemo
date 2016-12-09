package com.git.lucene.analyzer;

import java.io.IOException;
import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.junit.Test;

/**
 * 
 * @Description: 第一个基于lucene的使用尝试
 * @author: songqinghu
 * @date: 2016年12月7日 下午4:54:22
 * Version:1.0
 */
public class OneAnalyzerDemo {

    
    @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException {
        
        Analyzer analyzer = new CJKAnalyzer(); //创建中文分词器
        
        //添加 要字段 和待分词内容
        TokenStream ts = analyzer.tokenStream("test", new StringReader("这是第一个分词尝试语句,this my one test!"));
        //重置
        ts.reset();
        while(ts.incrementToken()){
            //原始输出
            System.out.println("this token : " + ts );
            //添加属性信息  -- 分词内容
            CharTermAttribute term = ts.addAttribute(CharTermAttribute.class);
            // 词语的偏移量
            OffsetAttribute offset = ts.addAttribute(OffsetAttribute.class);
            //词语类型
            TypeAttribute typeAtt = ts.addAttribute(TypeAttribute.class);
            
            System.out.println("term :" + term.toString() +
                    "  start offset : " + offset.startOffset()
                    + "  end offset : " + offset.endOffset()
                    + "  type : " + typeAtt.type());
            
        }
        
        
        
    }
    @Test
    public void testMyOneAnaylzer() throws IOException{
        
        Analyzer analyzer = new MyOneAnaylzer(); //创建中文分词器
        for (int i = 0; i < 10; i++) {
            //添加 要字段 和待分词内容
            TokenStream ts = analyzer.tokenStream("test", new StringReader("这是第一个分词尝试语句 this My one test"));
            //重置
            ts.reset();
            while(ts.incrementToken()){
                //原始输出
                System.out.println("this token : " + ts );
                //添加属性信息  -- 分词内容
                CharTermAttribute term = ts.addAttribute(CharTermAttribute.class);
                // 词语的偏移量
               // OffsetAttribute offset = ts.addAttribute(OffsetAttribute.class);
                //词语类型
                //TypeAttribute typeAtt = ts.addAttribute(TypeAttribute.class);
                
                System.out.println("term :" + term.toString() 
                       // + "  start offset : " + offset.startOffset()
                      //  + "  end offset : " + offset.endOffset()
                      //  + "  type : " + typeAtt.type()
                        );
                
            }
            ts.reset();
        }
    }
    
    
}

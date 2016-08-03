package com.git.solr.tokenizer;

import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.ngram.NGramTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionLengthAttribute;
import org.apache.lucene.analysis.tokenattributes.TermToBytesRefAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
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
    public void analyzer() throws IOException, ParseException, org.apache.lucene.queryparser.classic.ParseException{
        
        String s = "更加厉害了";  
        StringReader sr = new StringReader(s);    
        //N-gram模型分词器  
        Tokenizer tokenizer = new NGramTokenizer(1, 10);
        tokenizer.setReader(sr);
        //Edge-NGram 边缘模型，范围模型分词器  
        //Tokenizer tokenizer=new EdgeNGramTokenizer(Version.LUCENE_46, sr, 1, 10);       
        //Tokenizer tokenizer=new Lucene43NGramTokenizer(sr);  
        //Tokenizer tokenizer=new Lucene43EdgeNGramTokenizer(Version.LUCENE_46, sr, 1, 10);  
        testtokenizer(tokenizer);
        
                
    } 
    private void testtokenizer(Tokenizer tokenizer) {
        try {         
            /*            
            Iterator<Class<? extends Attribute>> iterator = tokenizer 
                    .getAttributeClassesIterator(); 
            while (iterator.hasNext()) { 
                Class<? extends Attribute> attrClass = iterator.next(); 
                System.out.println(attrClass.getSimpleName()); 
            }*/                       
            tokenizer.reset();  
            while(tokenizer.incrementToken())  
            {  
                //CharTermAttribute  
                //TermToBytesRefAttribute  
                //PositionIncrementAttribute  
                //PositionLengthAttribute  
                //OffsetAttribute  
                CharTermAttribute charTermAttribute=tokenizer.addAttribute(CharTermAttribute.class);  
                TermToBytesRefAttribute termToBytesRefAttribute=tokenizer.addAttribute(TermToBytesRefAttribute.class);  
                PositionIncrementAttribute positionIncrementAttribute=tokenizer.addAttribute(PositionIncrementAttribute.class);  
                PositionLengthAttribute positionLengthAttribute=tokenizer.addAttribute(PositionLengthAttribute.class);  
                OffsetAttribute offsetAttribute=tokenizer.addAttribute(OffsetAttribute.class);  
                TypeAttribute typeAttribute = tokenizer.addAttribute(TypeAttribute.class);  
                //System.out.println(attribute.toString());  
                System.out.println("term="+charTermAttribute.toString()+","+offsetAttribute.startOffset()+"-"+offsetAttribute.endOffset()  
                        +",type="+typeAttribute.type()+",PositionIncrement="+positionIncrementAttribute.getPositionIncrement()  
                        +",PositionLength="+positionLengthAttribute.getPositionLength());  
                  
            }             
            tokenizer.end();  
            tokenizer.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }         
    }  
        
    @Test //报错
    public void keywordTokenizer() throws IOException, ParseException, org.apache.lucene.queryparser.classic.ParseException{
        
//        Analyzer analyzer = new MMSegAnalyzer();
//        QueryParser parser = new QueryParser(matchVersion, "test", analyzer);        
//        Query parse = parser.parse("这是一个测试的例子");
//        System.out.println(parse.toString());
    } 
    

    
    
    @After
    public void destroy(){
        System.out.println("end !");
    }
    
    
}

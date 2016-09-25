package com.git.lucene;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.ngram.NGramTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NGramTokenizerUtil {

	    private static final Logger logger = LoggerFactory.getLogger(NGramTokenizerUtil.class);  
	  
	    private static Tokenizer tokenizer = new NGramTokenizer(2,2);  
	  
	    private static Object lock = new Object();  
	  
	    private static Tokenizer getTokenizer(){  
	        if(tokenizer ==null){  
	            tokenizer = new NGramTokenizer(1,1);  
	        }  
	        return tokenizer;  
	    }  
	    /** 
	     *  
	     * @描述：对输入的文本使用n-gram进行处理 
	     * @param text 
	     * @return Set<String> 
	     * @createTime：2016年8月3日 
	     * @author: songqinghu 
	     */  
	    public static  List<String> analyzer(String text) {  
	        synchronized (lock) {  
	            StringReader sr = new StringReader(text);      
	            //N-gram模型分词器    
	            getTokenizer().setReader(sr);  
	            List<String> words = tokenizer(getTokenizer());  
	            return words;  
	        }  
	    }   
	  
	  
	    private static List<String>  tokenizer(Tokenizer tokenizer) {  
	    	List<String>  words = new ArrayList<String>();  
	        try {  
	            tokenizer.reset();  
	            while(tokenizer.incrementToken())    
	            {     
//	                CharTermAttribute word=tokenizer.addAttribute(CharTermAttribute.class);  
//	                System.out.println(word);  
//	                words.add(word.toString());  
	                CharTermAttribute charTermAttribute=tokenizer.addAttribute(CharTermAttribute.class);    
	              //  OffsetAttribute offsetAttribute=tokenizer.addAttribute(OffsetAttribute.class);    
	                //words.put(offsetAttribute.startOffset()+"-"+offsetAttribute.endOffset(), charTermAttribute.toString());  
	                words.add(charTermAttribute.toString());
	            }       
	            tokenizer.reset();  
	        } catch (IOException e) {  
	            logger.error("tokenizer occor error :  " + e);  
	            try {  
	                tokenizer.end();  
	                tokenizer.close();  
	            } catch (IOException e1) {  
	                logger.error("tokenizer close error :  " + e);  
	            }    
	            tokenizer = null;  
	        }           
	        return words;  
	    }    
}

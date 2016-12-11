package com.git.lucene.analyzer;

import java.io.IOException;
import java.io.Reader;

import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.util.Attribute;
import org.junit.experimental.theories.Theories;

import com.gargoylesoftware.htmlunit.html.HtmlIsIndex;
/**
 * 
 * @Description: 我的分析器
 * @author: songqinghu
 * @date: 2016年12月7日 下午6:37:14
 * Version:1.0
 */
public class MyOneTokenizer extends Tokenizer{

    private static MyTernarySearchTrie dic = new MyTernarySearchTrie("D:\\tmep\\words\\WordList.txt");//字典树
    
    private CharTermAttribute termAtt;//词属性
    private OffsetAttribute offset;//词属性
    
    private static final int IO_BUFFER_SIZE = 4096;
    
    private char[] ioBUffer  = new char[IO_BUFFER_SIZE];
    
    private boolean done;
    
    private int i =0;// 控制匹配的其实位置
    
    private int upto =0;
    
    
    public MyOneTokenizer() {
        this.termAtt = addAttribute(CharTermAttribute.class);
        this.offset = addAttribute(OffsetAttribute.class);
        this.done = false;
    }
    
    /**
     * @描述：重置iobuffer大小
     * @param newSize
     * @return void
     * @createTime：2016年12月8日
     * @author: songqinghu
     */
    public void resizeIOBuffer(int newSize){
        
        if(ioBUffer.length<newSize){
            final char[] newCharBuffer = new char[newSize];
            
            System.arraycopy(ioBUffer, 0, newCharBuffer, 0, ioBUffer.length);
            
            ioBUffer = newCharBuffer;
            
        }
        
        
    }
    
    
    
    
    @Override
    public boolean incrementToken() throws IOException {
       
        if(!done){
            
            clearAttributes();
            
            done = true;
            
            upto = 0;
            
            i=0;
            
            while(true){
                
                final int length = input.read(ioBUffer, upto, ioBUffer.length - upto);
                
                if(length ==-1){
                    break;
                }
                
                upto +=length;
                
                if(upto  == ioBUffer.length){
                    resizeIOBuffer(upto * 2);
                }
                
                
                
                
            }
            
            
        }
        
        
        if(i<upto){
            //正向最大匹配
            char[] word = dic.matchLong(ioBUffer,i,upto);
            if(word !=null){ //已经匹配上
                termAtt.copyBuffer(word, 0, word.length);
                offset.setOffset(i, i + word.length);
                i+= word.length;
            }else{
                
                termAtt.copyBuffer(ioBUffer, i, 1);
                
                offset.setOffset(i, i+1);
                i++; //下次匹配点在这个之后
            }
            return true;
        }
        
        return false;
    }

    @Override
    public void reset() throws IOException {
        super.reset();
        
        this.i = 0;
        
        this.done = false;
        
        this.upto = 0;
        
    }

    @Override
    public void end() throws IOException {
        //设置最后的偏移量
        final int finalOffset = correctOffset(upto);
        
        offset.setOffset(finalOffset, finalOffset);
        
    }

    
    
    
}

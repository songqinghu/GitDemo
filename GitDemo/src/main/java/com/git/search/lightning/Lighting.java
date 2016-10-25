package com.git.search.lightning;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.git.search.lightning.bean.IndexBean;
import com.git.search.lightning.bean.InvertedIndexEntries;
import com.git.search.lightning.bean.TermFind;
import com.git.search.lightning.segment.DocmentSegment;
import com.google.common.io.Files;

/**
 * 闪电搜索主类
 * @Description: TODO
 * @author: songqinghu
 * @date: 2016年10月25日 下午5:18:26
 * Version:1.0
 */
public class Lighting {

    
    public static void main(String[] args) throws IOException {
        
        File file = new File("E:\\lightning\\docment");
        
        String[] names = file.list();
        
        for (String name : names) {
             List<String> contents = Files.readLines(new File(file, name), Charset.forName("gb2312"));
             StringBuffer temp = new StringBuffer();
             for (String content : contents) {
                 temp.append(content);
            }
            DocmentSegment.getIndexWord(temp.toString()); 
             
            
        }
        long start = System.currentTimeMillis();
        Map<Integer, LinkedList<IndexBean>> termdic = TermFind.getTermdic();
        
        String term = "宋";
        
        int hash = term.hashCode();
        
        LinkedList<IndexBean> linkedList = termdic.get(hash);
        
        for (IndexBean indexBean : linkedList) {
            
            if(indexBean.getTerm().equals(term)){//找到搜索词
                
                List<InvertedIndexEntries> invertIndexs = indexBean.getInvertIndexs();
                
                for (InvertedIndexEntries temp : invertIndexs) {
                        
                    System.out.println(temp.getDocId() + " : " + temp.getStartIndexs());
                }
                
            }
        }
        
        System.out.println(System.currentTimeMillis() -start);
        
    }
}

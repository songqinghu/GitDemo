package com.git.search.lightning.segment;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import com.git.lucene.NGram11TokenizerUtil;
import com.git.search.lightning.bean.IndexBean;
import com.git.search.lightning.bean.InvertedIndexEntries;
import com.git.search.lightning.bean.TermFind;
import com.google.common.hash.HashCode;

/**
 * 文档分词过程
 * @Description: TODO
 * @author: songqinghu
 * @date: 2016年10月25日 下午5:17:57
 * Version:1.0
 */
public class DocmentSegment {

    /**
     * @描述：将文章分词,扫描 使用 归并法 建立索引 文档有限,就模拟一次两个文档为固定内存吧
     * @param doc
     * @return List<String>
     * @createTime：2016年10月25日
     * @author: songqinghu
     */
    public static List<String> getIndexWord(String doc){
        //分词 返回位置信息 文档id自定义
        int docId =next();
        Map<String, String> terms = NGram11TokenizerUtil.analyzer(doc);
        Set<String> keys = terms.keySet();
        for (String key : keys) {
            String term = terms.get(key);
            Long start = Long.parseLong(key.split("-")[0]);

            InvertedIndexEntries iie = new InvertedIndexEntries();
            iie.setDocId(docId);
            iie.getStartIndexs().add(start);
            IndexBean indexBean = new IndexBean();
            indexBean.setTerm(term);
            indexBean.getInvertIndexs().add(iie);
            int hashCode = term.hashCode();
            LinkedList<IndexBean> linkedList = TermFind.getTermdic().get(hashCode);
            if(linkedList==null || linkedList.size()==0){
                linkedList = new LinkedList<IndexBean>();
            }
            linkedList.add(indexBean);
            TermFind.getTermdic().put(hashCode, linkedList);
        }
        
        
        
        return null;
    }
    
    
    private final static AtomicInteger counterVal = new AtomicInteger(0);

    public static int next() {
        return counterVal.getAndIncrement();
    }

    
}

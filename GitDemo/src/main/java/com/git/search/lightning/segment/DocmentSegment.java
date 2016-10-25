package com.git.search.lightning.segment;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.jsp.jstl.core.IndexedValueExpression;

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
            if(term.equals("宋")){
                System.out.println("");
            }
            Long start = Long.parseLong(key.split("-")[0]);
            
            //索引查询
            int hash = term.hashCode();
            LinkedList<IndexBean> link = TermFind.getTermdic().get(hash);
            if(link==null || link.size()==0){ //第一次
                link = new LinkedList<IndexBean>();
                InvertedIndexEntries iie = new InvertedIndexEntries();
                iie.setDocId(docId);
                iie.getStartIndexs().add(start);
                IndexBean indexBean = new IndexBean();
                indexBean.setTerm(term);
                indexBean.getInvertIndexs().add(iie);
                
                link.add(indexBean);
                TermFind.getTermdic().put(hash, link);
            }else{
                //已经有了
                boolean flag = false; //不含这个term
                for (IndexBean indexBean : link) {
                    if(indexBean.getTerm().equals(term)){//找到term
                        List<InvertedIndexEntries> invertIndexs = indexBean.getInvertIndexs();
                        boolean iFlag = false;//不同的docid需要不同处理
                        for (InvertedIndexEntries invertedIndexEntries : invertIndexs) {
                            
                            long id = invertedIndexEntries.getDocId();
                            if(docId ==id){
                                invertedIndexEntries.getStartIndexs().add(start);
                                iFlag =true;
                            }
                            
                        }
                        if(!iFlag){//新的docid
                            InvertedIndexEntries entries = new InvertedIndexEntries();
                            entries.setDocId(docId);
                            entries.getStartIndexs().add(start);
                            invertIndexs.add(entries);
                        }
                        flag =true;
                    }
                    
                }
                
                //查找一遍还是不含有 --新建设
                if(!flag){
                    InvertedIndexEntries iie = new InvertedIndexEntries();
                    iie.setDocId(docId);
                    iie.getStartIndexs().add(start);
                    IndexBean indexBean = new IndexBean();
                    indexBean.setTerm(term);
                    indexBean.getInvertIndexs().add(iie);
                    
                    link.add(indexBean);
                }
                
            }
        }
        
        //归并 写入磁盘 ---先放在内存中 测试一下查找
        
        return null;
    }
    /**
     * @描述：合并内存中索引
     * @return void
     * @exception
     * @createTime：2016年10月25日
     * @author: songqinghu
     */
    public static void mergeIndex(){
        
        Map<Integer, LinkedList<IndexBean>> termdic = TermFind.getTermdic();
        
        
        
    }
    
    
    
    
    private final static AtomicInteger counterVal = new AtomicInteger(0);

    public static int next() {
        return counterVal.getAndIncrement();
    }

    
}

package com.git.search.lightning.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 倒排索引项目
 * @Description: TODO
 * @author: songqinghu
 * @date: 2016年10月25日 下午5:30:19
 * Version:1.0
 */
public class InvertedIndexEntries {

    private int docId;//该项目文档id
    
    private long tf;//这个文档中词语出现的频率
    
    private List<Long> startIndexs = new ArrayList<>();//开始的角标
    
    public long getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public long getTf() {
        return tf;
    }

    public void setTf(long tf) {
        this.tf = tf;
    }

    public List<Long> getStartIndexs() {
        return startIndexs;
    }

    public void setStartIndexs(List<Long> startIndexs) {
        this.startIndexs = startIndexs;
    }

}

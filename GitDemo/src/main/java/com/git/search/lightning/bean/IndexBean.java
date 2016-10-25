package com.git.search.lightning.bean;

import java.util.ArrayList;
import java.util.List;
/**
 * 索引结构类
 * @Description: TODO
 * @author: songqinghu
 * @date: 2016年10月25日 下午5:25:06
 * Version:1.0
 */
public class IndexBean {

    private String term;//最小词
    
    private long df;//多少个文档中出现

    private List<InvertedIndexEntries> invertIndexs = new ArrayList<InvertedIndexEntries>();//该词语的倒排列表

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public long getDf() {
        return df;
    }

    public void setDf(long df) {
        this.df = df;
    }

    public List<InvertedIndexEntries> getInvertIndexs() {
        return invertIndexs;
    }

    public void setInvertIndexs(List<InvertedIndexEntries> invertIndexs) {
        this.invertIndexs = invertIndexs;
    }
    
    
}

package com.git.books.a_lucene_java.query;

import java.io.IOException;

import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.spans.SpanNearQuery;
import org.apache.lucene.search.spans.SpanQuery;
import org.apache.lucene.search.spans.SpanTermQuery;
import org.apache.lucene.search.spans.SpanWeight;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.CloudSolrClient;

/**
 * 
 * @Description: spanquery 查询demo
 * @author: songqinghu
 * @date: 2017年2月18日 上午11:11:17
 * Version:1.0
 */
public class SpanQueryDemo {

    
    public static void main(String[] args) {
        
        searchOne();
        
    }
    
    public static void searchOne(){
        //要查询的词语列表   词语要在几个编辑距离内  是否要按照顺序
       SpanNearQuery nearQuery = new SpanNearQuery(new SpanQuery[]{new SpanTermQuery(new Term("name", "户外")),new SpanTermQuery(new Term("name", "音响"))}, 5, true);        

       
       
       
      // client.query(nearQuery);
       
    }
    
    
    
}

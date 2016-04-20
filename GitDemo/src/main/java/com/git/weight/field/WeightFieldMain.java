package com.git.weight.field;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexableField;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.CommonParams;

/**
 * 通过设置字段的方式来进行排序--自定义自己的排序算法
 * @author songqinghu
 *
 */
public class WeightFieldMain {
    /**
     * 索引字段最大值默认
     */
    private static double countMax =10000;
    
    private static double pointMax = 10000;
    
    private static double hotMax = 10000;
    //权重最大值
    private static double scoreMax = 1000;
    
    private static SolrClient client = null;
    
    public static void main(String[] args) throws SolrServerException, IOException {
        initMax();
        addWeight();
    }
    /**
     * 
     * @描述：为文档添加排序字段的值(我的库中只有不到10个数据--只是简单处理)
     * @return void
     * @exception
     * @createTime：2016年4月20日
     * @author: songqinghu
     * @throws IOException 
     * @throws SolrServerException 
     */
    public static void addWeight() throws SolrServerException, IOException{
        SolrQuery query = new SolrQuery();
        query.set(CommonParams.Q, "*:*");
        
        SolrDocumentList docs = getClient().query(query).getResults();
        ArrayList<SolrInputDocument> list = new ArrayList<SolrInputDocument>(docs.size());
        for (SolrDocument doc : docs) {
            String id = doc.getFieldValue(FieldName.id).toString();
            double count = Double.parseDouble(doc.getFieldValue(FieldName.count).toString());
            double point = Double.parseDouble(doc.getFieldValue(FieldName.point).toString());
            double hot   = Double.parseDouble(doc.getFieldValue(FieldName.hot).toString());
            //计算该文档的权重字段值--最小最大算法
            Double countScore = MinMaxAlgorithm.getValue(count, 0, countMax, 0, scoreMax*0.1);
            Double pointScore = MinMaxAlgorithm.getValue(point, 0, pointMax, 0, scoreMax*0.45);
            Double hotScore = MinMaxAlgorithm.getValue(hot, 0, hotMax, 0, scoreMax*0.45);
            double weight =  countScore+pointScore+hotScore;
            //重新修改文档信息提交了
            SolrInputDocument input = new SolrInputDocument();
            input.addField(FieldName.id, id);
            HashMap<String, Double> map = new HashMap<String,Double>();
            map.put("set", weight);
            input.addField(FieldName.weightOne, map);
            list.add(input);
            System.out.println("id: "+id+"   weightOne:"+weight);
        }
        getClient().add(list);
        getClient().commit();
        System.out.println("OVER");
        
    }
    /**
     * 
     * @描述：查询库中数据的最大值
     * @return void
     * @exception
     * @createTime：2016年4月20日
     * @author: songqinghu
     * @throws IOException 
     * @throws SolrServerException 
     */
    private static long findMax(String fieldName) throws SolrServerException, IOException{
       SolrQuery query = new SolrQuery();
       query.set(CommonParams.Q, "*:*");
       query.setSort(fieldName, ORDER.desc);
       query.setRows(1);
       SolrDocumentList docs = getClient().query(query).getResults();
       String result = docs.get(0).getFieldValue(fieldName).toString();
       return Long.parseLong(result);
    }
    
    private static void initMax() throws SolrServerException, IOException{
       countMax =  findMax("count");
       pointMax =  findMax("point");
       hotMax =  findMax("hot");
    }
    /**
     * 
     * @描述：获取solr的连接
     * @return
     * @return SolrClient
     * @exception
     * @createTime：2016年4月20日
     * @author: songqinghu
     */
    private static SolrClient getClient(){
        if(client ==null){
            client = new HttpSolrClient("http://localhost:8983/solr/dismax");
        }
        return client;
    }
}

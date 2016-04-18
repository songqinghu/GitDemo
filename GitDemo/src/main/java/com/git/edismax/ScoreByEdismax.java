package com.git.edismax;
import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.CommonParams;

/**
 * 测试edismax的代码实现自定义权重排序股则
 * @author songqinghu
 *
 */
public class ScoreByEdismax {

    private final static String baseURL = "http://localhost:8983/solr/dismax";
    
    
    public static void main(String[] args) throws Exception{
        
        scoreBySum() ;
        
        System.out.println("=====分割线==========");
        
        scoreByProportion();
        
    }
    
    /**
     * 
     * @描述：按照各个数值的比重来进行权重计算  count 10% point 45% hot 45%  --假设总分为100分 那么 分别最大分为 10 45 45
     * @return void
     * @exception
     * @createTime：2016年4月18日
     * @author: songqinghu
     * @throws IOException 
     * @throws SolrServerException 
     */
    public static void scoreByProportion() throws SolrServerException, IOException{
        //先查询出来三个字段中每个字段的最大值--编写好计算权重的公式---实际项目中应该还要加入是否存在的判断
        
        long countMax = getMaxForField("count");
        long pointMax = getMaxForField("point");
        long hotMax = getMaxForField("hot");
        
        String scoreMethod = "sum(product(div(count,"+countMax+"),10),product(div(point,"+pointMax+"),45),product(div(hot,"+hotMax+"),45))^1000000000";
        
        SolrQuery query = new SolrQuery();
        query.set(CommonParams.Q, "国美*");
        query.set(CommonParams.FL,"id","name","count","point","hot","score");
        
        query.set("defType","edismax");
        
        query.set("bf", scoreMethod);
        
        
        QueryResponse response = getClient().query(query);
        
        resultShow(response);
        
    }
    /**
     * @描述：XXXXXXX
     * @return
     * @return long
     * @exception
     * @createTime：2016年4月18日
     * @author: songqinghu
     * @throws IOException 
     * @throws SolrServerException 
     */
    private static long getMaxForField(String fieldName) throws SolrServerException, IOException{
        
        SolrQuery query = new  SolrQuery();
        
        query.set(CommonParams.Q, "*:*");
        query.set(CommonParams.FL, fieldName);
        query.setSort(fieldName, ORDER.desc);
        query.setRows(1);
        
        QueryResponse countResponse = getClient().query(query);
        
        SolrDocument maxCount = countResponse.getResults().get(0);
        
        long result = (long) maxCount.getFieldValue(fieldName);
        System.out.println(fieldName + ":" + result);
        return result;
    }
    
    
    /**
     * 
     * @描述:按照 count point 和 hot 的 和的数量来进行权重计算
     * @return void
     * @exception
     * @createTime：2016年4月18日
     * @author: songqinghu
     * @throws IOException 
     * @throws SolrServerException 
     */
    public static  void  scoreBySum() throws SolrServerException, IOException{
        
        SolrQuery query  = new SolrQuery();
        
        query.set(CommonParams.Q, "国美*");
        
        query.set(CommonParams.FL,"id","name","count","point","hot","score");
        
        //开启edismax方式来进行自定义权重算法
        query.set("defType", "edismax");
        
        query.set("bf","sum(count,point,hot)^1000000000");
        
        
        QueryResponse response = getClient().query(query);
        
        resultShow(response);

    }
    
    /**
     * 
     * @描述：查询结果显示类
     * @param response
     * @return void
     * @exception
     * @createTime：2016年4月18日
     * @author: songqinghu
     */
    private static void resultShow(QueryResponse response){
        
        int time = response.getQTime();
        System.out.println("响应时间:"+ time+"ms");
        
        SolrDocumentList results = response.getResults();
        long numFound = results.getNumFound();
        System.out.println("总数量:"+numFound);
        
        for (SolrDocument doc : results) {
           
           System.out.println("id:"+ doc.getFieldValue("id").toString());
           System.out.println("name:"+ doc.getFieldValue("name").toString());
           System.out.println("count:"+ doc.getFieldValue("count").toString());
           System.out.println("point:"+ doc.getFieldValue("point").toString());
           System.out.println("hot:"+ doc.getFieldValue("hot").toString());
           System.out.println("score:"+ doc.getFieldValue("score").toString());
           System.out.println();
        }
    }
    
    
    /**
     * 
     * @描述：获取单机版本的连接信息
     * @return
     * @return SolrClient
     * @exception
     * @createTime：2016年4月18日
     * @author: songqinghu
     */
    public static SolrClient getClient(){
        
        SolrClient solrClient = new HttpSolrClient(baseURL);
        
        return solrClient;
    }
    
    
}

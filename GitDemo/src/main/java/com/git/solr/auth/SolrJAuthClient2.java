package com.git.solr.auth;

import java.io.IOException;
import java.util.Map;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.SolrResponse;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.impl.HttpClientConfigurer;
import org.apache.solr.client.solrj.request.QueryRequest;
import org.apache.solr.common.params.DefaultSolrParams;
import org.apache.solr.common.params.MultiMapSolrParams;
import org.apache.solr.common.params.SolrParams;

/**
 * solr安全设置后连接尝试API
 * @author songqinghu
 *
 */
public class SolrJAuthClient2 {

    public static void main(String[] args) {
        
        
    }
    /**
     * 
     * @描述：solrj认证连接方法
     * @throws SolrServerException
     * @throws IOException
     * @return void
     * @exception
     * @createTime：2016年4月25日
     * @author: songqinghu
     */
    private static void client() throws SolrServerException, IOException{
        CloudSolrClient solrClient = new CloudSolrClient("");
        SolrParams q  = new SolrQuery();
        QueryRequest request = new QueryRequest(q  );
        request.setBasicAuthCredentials("", "");
        solrClient.request(request);
        
    }
    
}

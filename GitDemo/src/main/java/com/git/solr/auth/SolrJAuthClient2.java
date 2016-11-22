package com.git.solr.auth;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

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
        Properties p  = new Properties();
        p.setProperty("zkDigestUsername",  "admin");
        p.setProperty("zkDigestPassword", "admin");
        p.setProperty("zkCredentialsProvider", "org.apache.solr.common.cloud.VMParamsSingleSetCredentialsDigestZkCredentialsProvider");
        p.setProperty("zkACLProvider", "org.apache.solr.common.cloud.VMParamsAllAndReadonlyDigestZkACLProvider");
          System.setProperties(p);
        CloudSolrClient solrClient = new CloudSolrClient("10.125.137.111:2181,10.125.137.112:2181,10.125.137.113:2181");
        
        solrClient.connect();
        System.out.println("ss");
//        SolrParams q  = new SolrQuery();
//        QueryRequest request = new QueryRequest(q  );
//        request.setBasicAuthCredentials("", "");
//        solrClient.request(request);
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

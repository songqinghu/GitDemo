package com.git.solr.auth;

import java.io.IOException;
import java.util.Properties;

import org.apache.http.client.HttpClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.request.QueryRequest;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.cloud.SolrZkClient;

/**
 * solr安全设置后连接尝试API
 * @author songqinghu
 *
 */
public class SolrJAuthClient {

    public static void main(String[] args) throws SolrServerException, IOException {
        
        client();
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
       Properties p  = new Properties();
       p.setProperty("zkDigestUsername",  "admin");
       p.setProperty("zkDigestPassword", "admin");
       //p.setProperty("zkCredentialsProvider", "org.apache.solr.common.cloud.VMParamsSingleSetCredentialsDigestZkCredentialsProvider");
       //p.setProperty("zkACLProvider", "org.apache.solr.common.cloud.VMParamsAllAndReadonlyDigestZkACLProvider");
         System.setProperties(p);
      // System.out.println(System.getProperty("zkDigestUsername"));
        String zkUrl = "192.168.119.20:2181,192.168.119.21:2181";
        
        //ESystemDefaultHttpClient httpClient = new ESystemDefaultHttpClient(200, 2000);
        CloudSolrClient cloudSolrClient = new  CloudSolrClient(zkUrl);
        cloudSolrClient.setDefaultCollection("meixin_suggest");
        cloudSolrClient.connect();
        SolrQuery q  = new SolrQuery();
        q.set("q", "*:*");
        QueryRequest req = new QueryRequest(q);
        req.setBasicAuthCredentials("root", "songqinghu");
        QueryResponse response = req.process(cloudSolrClient);
        long numFound = response.getResults().getNumFound();
        System.out.println("the query numfound is :"+ numFound);
        cloudSolrClient.close();
    }
    
}

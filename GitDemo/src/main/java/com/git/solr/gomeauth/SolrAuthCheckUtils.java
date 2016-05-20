package com.git.solr.gomeauth;
import java.io.IOException;
import java.util.Collection;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.request.QueryRequest;
import org.apache.solr.client.solrj.request.UpdateRequest;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.SolrParams;
/**
 * 操作时的安全校验工具类
 * @author songqinghu
 *
 */
public class SolrAuthCheckUtils {

    
    /**
     * 查询
     * @throws IOException 
     * @throws SolrServerException 
     */
    public static QueryResponse query(SolrParams query,SolrClient client) throws SolrServerException, IOException{
        QueryRequest request = new QueryRequest(query);
        AuthInputProcessUtils.setBasicAuthCredentials(request);
        QueryResponse response = request.process(client);
        return response;
        
    }
    /**
     * 添加
     * @throws IOException 
     * @throws SolrServerException 
     */
    public static UpdateResponse add(Collection<SolrInputDocument> docs,SolrClient client) throws SolrServerException, IOException{
        UpdateRequest request = new UpdateRequest();
        AuthInputProcessUtils.setBasicAuthCredentials(request);
        request.add(docs);
        UpdateResponse response = request.process(client);
        return response;
    }
    
    
    /**
     * 删除
     */
    public static void deleteByQuery(){
        
        
        
        
    }
    
    
    
    
    
    
}

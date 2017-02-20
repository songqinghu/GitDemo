package com.git.books.a_lucene_java.analyzer.my;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.cloud.ClusterState;
import org.apache.solr.common.cloud.Replica;
import org.apache.solr.common.cloud.Slice;
import org.apache.solr.common.cloud.ZkStateReader;
import org.apache.solr.common.cloud.Replica.State;
import org.apache.solr.common.params.SolrParams;

import com.opera.core.systems.scope.protos.UmsProtos.Response;
/**
 * @Description: 字典加载类  使用hashmap加载
 * @author: songqinghu
 * @date: 2017年2月15日 上午11:12:50
 * Version:1.0
 */
public class DicLoad {

    private Map<String, String> words  = new HashMap<String, String>();
    
    private String dicPath = "/data/lex-main.lex";
    
    public DicLoad() {
        reloadDic(dicPath);
    }
    
    public DicLoad(String dicPath){
        this.dicPath = dicPath;
        reloadDic(dicPath);
    }
    /**
     * @描述：将字典加载到map中
     * @param dicPath
     * @return void
     * @exception
     * @createTime：2017年2月15日
     * @author: songqinghu
     * @throws IOException 
     */
    public void reloadDic(String dicPath) {
        
        InputStream is = DicLoad.class.getResourceAsStream(dicPath);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        
        String line =null;
        try {
            while((line = br.readLine()) != null) {
                
                int indexOf = line.indexOf("/");
                if(indexOf !=-1){
                    String key = line.substring(0, indexOf);
                    words.put(key, line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        
        
    }
    
    public String getValue(String key){
       return  words.get(key);
    }
    
    public boolean isContainKey(String key){
        return words.containsKey(key);
    }
    
    public static void main(String[] args) throws SolrServerException, IOException {
        
        
        CloudSolrClient clients = new CloudSolrClient.Builder().withZkHost("10.58.69.125:2181/solr").build();
       
        //clients.setDefaultCollection("meixin_user");
        clients.connect();
       // SolrQuery params =new SolrQuery();
       // params.set("q", "*:*");
       // QueryResponse reponse = clients.query(params);
        
       // long numFound = reponse.getResults().getNumFound();
      //  System.out.println(numFound);
        
        ZkStateReader zkStateReader = clients.getZkStateReader();
        
        ClusterState clusterState = clients.getZkStateReader().getClusterState();
        
        Set<String> collections = clusterState.getCollections();
        
        for (String collectionName : collections) {
            Collection<Slice> slices = clusterState.getSlices(collectionName);
            boolean flag = false;// 是否有节点挂了
            for (Slice slice : slices) {
                Collection<Replica> replicas = slice.getReplicas();
                for (Replica replica : replicas) {
                    
                    System.out.println(replica.getCoreUrl() + " : " + replica.getState());

                }
            }
        }
        
        //Set<String> collections = clusterState.getCollections();
        
    }
    
}

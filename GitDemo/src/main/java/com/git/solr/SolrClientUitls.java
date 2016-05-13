package com.git.solr;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.CloudSolrClient;

public class SolrClientUitls {

    private static SolrClient client = null;
    public static SolrClient getClient(){
        if(client ==null){
            String zkUrl = "192.168.119.20:2181,192.168.119.21:2181";
            CloudSolrClient cloudSolrClient = new  CloudSolrClient(zkUrl);
            cloudSolrClient.setDefaultCollection("meixin_suggest");
            cloudSolrClient.connect();
            client = cloudSolrClient;
        }
        return client;
    }
}

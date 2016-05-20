package com.git.solr.gomeauth;

import org.apache.solr.client.solrj.SolrRequest;

//将账户密码校验过程单独切分出来
public class AuthInputProcessUtils {

    public static void setBasicAuthCredentials(SolrRequest request){
        request.setBasicAuthCredentials(UsernameAndPasswordUtils.getUsername(), UsernameAndPasswordUtils.getPassword());
    }
}

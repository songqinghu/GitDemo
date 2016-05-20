package com.git.solr.gomeauth;

import org.apache.solr.client.solrj.SolrClient;
/**
 * 密码获取工具类
 * 先写死 后期改为从某个存储中动态的获取更新账户密码
 * @author songqinghu
 *
 */
public class UsernameAndPasswordUtils {

    private static String USERNAME = "root";
    
    private static String PASSWORD = "songqinghu";
    
    static{
        init();
    }
    
    private static void init(){
        String gomeuser = System.getProperty("gome-user");
        String gomepassword = System.getProperty("gome-password");
        if(gomeuser !=null && gomeuser.trim().length()>0 &&
            gomepassword !=null && gomepassword.trim().length()>0){
            USERNAME = gomeuser;
            PASSWORD = gomepassword;
        }
    }
    
    public static String getUsername(){
        return USERNAME;
    }
    
    public static String getPassword(){
        return PASSWORD;
    }
    
}

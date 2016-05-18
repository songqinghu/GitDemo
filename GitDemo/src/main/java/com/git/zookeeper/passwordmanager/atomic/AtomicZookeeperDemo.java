package com.git.zookeeper.passwordmanager.atomic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.ACLProvider;
import org.apache.curator.framework.api.transaction.CuratorTransactionResult;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.ZooDefs.Perms;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;

/**
 * 原子性操作的演示
 * @author songqinghu
 *
 */
public class AtomicZookeeperDemo {

    public static void main(String[] args) throws Exception {
        
        CuratorFramework client = getClient();
        atomicCURD(client);
    }
    
    /**
     * 
     * @描述：原子性操作完成curd  
     * 测试失败的尝试
     * @param client
     * @return void
     * @exception
     * @createTime：2016年5月18日
     * @author: songqinghu
     * @throws Exception 
     */
    private static void atomicCURD(CuratorFramework client) throws Exception{
        Collection<CuratorTransactionResult> resultone =null;
        Collection<CuratorTransactionResult> resulttwo =null;
        try {
           //成功! 
           resultone = client.inTransaction().create().forPath("/one", "one".getBytes()).and().check()
                   .forPath("/one").and().create().forPath("/two").and().setData().forPath("/two", "two".getBytes())
                   .and().delete().forPath("/one").and().commit();
           //失败!
           resulttwo = client.inTransaction().create().forPath("/test", "test".getBytes()).and().check()
                   .forPath("/test").and().create().forPath("/two").and().setData().forPath("/two", "two".getBytes())
                   .and().delete().forPath("/llll").and().commit();
      } catch (Exception e) {
        
       }
        
        for (CuratorTransactionResult result : resultone) {
            System.out.println("getForPath  "+result.getForPath());
            System.out.println("getResultPath  "+result.getResultPath());
            System.out.println("getResultStat  "+result.getResultStat());
            System.out.println("getType  "+result.getType());
        }
        
        System.out.println("===============================");
        for (CuratorTransactionResult result : resulttwo) {
            System.out.println("getForPath  "+result.getForPath());
            System.out.println("getResultPath  "+result.getResultPath());
            System.out.println("getResultStat  "+result.getResultStat());
            System.out.println("getType  "+result.getType());
        }
    }
    
    
    
    
    /**
     * @描述：获取连接
     * @return
     * @return CuratorFramework
     * @exception
     * @createTime：2016年5月18日
     * @author: songqinghu
     */
    private static CuratorFramework getClient(){
        
        ACLProvider aclProvider  = new ACLProvider() {
            List<ACL> acl ;
            @Override
            public List<ACL> getDefaultAcl() {
                if(acl ==null){
                    acl =  new ArrayList<ACL>();
                    //管理员
                    acl.add(new ACL(Perms.ALL, new Id("auth","admin:amdin")));
                    //只读用户
                   // acl.add(new ACL(Perms.READ, new Id("auth","user:user")));
                }
                return acl;
            }
            
            @Override
            public List<ACL> getAclForPath(String arg0) {
                return acl;
            }
        };
        
        String scheme = "digest";
        byte[] auth = "admin:admin".getBytes();
        int connectionTimeoutMs = 5000;
        String connectString = "10.125.2.44:2181";
        byte[] defaultData = "测试连接".getBytes();
        String namespace = "atomic";
        RetryPolicy retryPolicy = new RetryNTimes(Integer.MAX_VALUE, 1000);
        CuratorFramework client = CuratorFrameworkFactory.builder().aclProvider(aclProvider).
        authorization(scheme, auth).
        connectionTimeoutMs(connectionTimeoutMs).
        connectString(connectString).
        defaultData(defaultData).
        namespace(namespace).
        retryPolicy(retryPolicy).build();
        client.start();
        return client;
    }
    
}

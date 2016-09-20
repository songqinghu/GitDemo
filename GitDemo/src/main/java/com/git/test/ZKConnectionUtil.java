package com.git.test;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.data.Stat;

/**
 * 获取zookeeper位置连接工具类---设置成自动加载模式
 * @Description: TODO
 * @author: songqinghu
 * @date: 2016年8月23日 下午2:48:59
 * Version:1.0
 */
public class ZKConnectionUtil {

    private  static CuratorFramework client ;
    
    private static Object lock = new Object();
    
    public static void main(String[] args) throws InterruptedException {
        
        addNode(getZKConnection(), "/flag");
        
        listenterFlagNode(getZKConnection());
        for (int i = 0; i <5; i++) {
            
            Thread thread = new Thread(new Runnable() {
                
                @Override
                public void run() {

                    //修改节点
                    updateFlagNode(client, true);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    updateFlagNode(client, false);
                    
                }
            });
            thread.start();
            Thread.sleep(2000);
        }
        
        Thread.sleep(Integer.MAX_VALUE);
    }
    
    public static void updateFlagNode(CuratorFramework client,boolean flag){
        try {
            String path="/flag";
            byte[] data = (flag+"").getBytes();
            Stat stat = client.setData().forPath(path, data);
            System.out.println(stat.getAversion());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
    }
    
    /**
     * @描述：对标识节点进行无限监听
     * @param client
     * @return void
     * @exception
     * @createTime：2016年8月24日
     * @author: songqinghu
     */
    public static void  listenterFlagNode(CuratorFramework client){
        try {
            final NodeCache flagNode = new NodeCache(client, "/flag",false);
            
            flagNode.getListenable().addListener(new NodeCacheListener() {
                
                @Override
                public void nodeChanged() throws Exception {
                    
                    System.out.println("目录 : "+flagNode.getCurrentData().getPath());
                    System.out.println("状态 : "+flagNode.getCurrentData().getStat());
                    System.out.println("数据: "+ new String(flagNode.getCurrentData().getData()));
                    
                }
            });
          
            flagNode.start();
            System.out.println("节点监听开始 !");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    /**
     * @描述：添加节点
     * @return void
     * @exception
     * @createTime：2016年8月24日
     * @author: songqinghu
     */
    public static boolean addNode(CuratorFramework client,String nodeName){
        
        try {
            Stat stat = client.checkExists().forPath(nodeName);
            System.out.println(stat);
            if(stat ==null){
                String path = client.create().creatingParentsIfNeeded().forPath(nodeName);
                System.out.println(path);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
    
    
    
    
    /**
     * 
     * @描述：获取单例的zookeeper连接
     * @return void
     * @exception
     * @createTime：2016年8月24日
     * @author: songqinghu
     */
    public static CuratorFramework getZKConnection(){
        
        if(client ==null){
            synchronized (lock) {
                if(client ==null){
                    int connectionTimeoutMs=5000;
                    //String connectString=PropUtil.getInstance().get("solr.zk.url");
                    // String namespace=PropUtil.getInstance().get("solr.zk.check.namespace");
                    String connectString="10.125.2.48:3181";
                    String namespace="contentcheck";
                    //byte[] defaultData=IpUtil.getInNetworkIp().getBytes();
                    RetryPolicy retryPolicy= new RetryNTimes(Integer.MAX_VALUE, 1000);
                    
                    client = CuratorFrameworkFactory.
                            builder().
//        aclProvider(aclProvider).
//        authorization(scheme, auth).
                            connectionTimeoutMs(connectionTimeoutMs).
                            connectString(connectString).
                          //  defaultData(defaultData).
                            namespace(namespace).
                            retryPolicy(retryPolicy).
                            build();
                    
                    client.start();
                }
            }
        }
        return client;
    }
    
    
}

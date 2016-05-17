package com.git.zookeeper.passwordmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.ACLProvider;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCache.StartMode;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooDefs.Perms;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.data.Stat;

/**
 * curator管理zookeeper的相关方法工具类
 * @author songqinghu
 * 要点:
 * 1.连接的建立  (两种 OK--使用权限方式)
 * 2.节点的管理操作,增删改查--层叠节点的操作(OK --设立命名空间)
 * 3.节点的监听操作,和无限监听事件触发
 * 4.节点的访问控制ACL操作,密码的添加,修改
 * 5.节点原子性操作
 * 6.节点的分布式锁操作
 */
public class ZookeeperCuratorUtils {

    /**
     * 先测试玩玩  
     * @描述：XXXXXXX
     * @param args
     * @return void
     * @exception
     * @createTime：2016年5月17日
     * @author: songqinghu
     * @throws Exception 
     */ 
    public static void main(String[] args) throws Exception {
       // nodesList(clientOne(), "/");
        CuratorFramework client = clientTwo();
        //nodesList(client, "/");
        //使用clientTwo来创建一个节点空间 查看是加密
       // createNode(client, "/usermanager");
        //setDataNode(client, "/usermanager", "test writer 测试写入效果!");
      //  getDataNode(client, "/usermanager");
       // createNode(client, "/three/two/testone");
      //  deleteDataNode(client, "/three");;
    }

    /**
     * 
     * @描述：创建一个zookeeper连接---连接方式一: 最简单的连接
     * @return void
     * @exception
     * @createTime：2016年5月17日
     * @author: songqinghu
     */
    private static CuratorFramework clientOne(){
        //zk 地址
        String connectString = "10.125.2.44:2181";
        // 连接时间 和重试次数
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient(connectString, retryPolicy);
        client.start();
        return client;
    }
    
    /**
     * 
     * @描述：创建一个zookeeper连接---连接方式二:优选这个
     * @return void
     * @exception
     * @createTime：2016年5月17日
     * @author: songqinghu
     */
    private static CuratorFramework clientTwo(){

        //默认创建的根节点是没有做权限控制的--需要自己手动加权限???----
        ACLProvider aclProvider = new ACLProvider() {
            private List<ACL> acl ;
            @Override
            public List<ACL> getDefaultAcl() {
                if(acl ==null){
                    ArrayList<ACL> acl = ZooDefs.Ids.CREATOR_ALL_ACL;
                    acl.clear();
                    acl.add(new ACL(Perms.ALL, new Id("auth", "admin:admin") ));
                    this.acl = acl;
                }
                return acl;
            }
            @Override
            public List<ACL> getAclForPath(String path) {
                return acl;
            }
        };
        String scheme = "digest";
        byte[] auth = "admin:admin".getBytes();
        int connectionTimeoutMs = 5000;
        String connectString = "10.125.2.44:2181";
        String namespace = "testnamespace";
        CuratorFramework client = CuratorFrameworkFactory.builder().aclProvider(aclProvider).
        authorization(scheme, auth).
        connectionTimeoutMs(connectionTimeoutMs).
        connectString(connectString).
         namespace(namespace).
        retryPolicy(new RetryNTimes(Integer.MAX_VALUE, 1000)).build();
        client.start();
        return client;
    }
    
    /**
     * 
     * @描述：获取子节点列表 打印
     * @return void
     * @exception
     * @createTime：2016年5月17日
     * @author: songqinghu
     * @throws Exception 
     */
    private static void nodesList(CuratorFramework client,String parentPath) throws Exception{
        List<String> paths = client.getChildren().forPath(parentPath);
        for (String path : paths) {
            System.out.println(path);
        }
    }
    /**
     * 
     * @描述：创建一个节点 
     * @param path
     * @return void
     * @exception
     * @createTime：2016年5月17日
     * @author: songqinghu
     * @throws Exception 
     */
    private static void createNode(CuratorFramework client,String path) throws Exception{
        
        Stat stat = client.checkExists().forPath(path);
        System.out.println(stat);
        String forPath = client.create().creatingParentsIfNeeded().forPath(path, "create init !".getBytes());
       // String forPath = client.create().forPath(path);
        System.out.println(forPath);
    }
    
    /**
     * 获取指定节点中信息
     * @throws Exception 
     */
    private static void getDataNode(CuratorFramework client,String path) throws Exception{
        Stat stat = client.checkExists().forPath(path);
        System.out.println(stat);
        byte[] datas = client.getData().forPath(path);
        System.out.println(new String(datas));
    }
    /**
     * 
     * @描述：设置节点中的信息
     * @param client
     * @param path
     * @param message
     * @return void
     * @exception
     * @createTime：2016年5月17日
     * @author: songqinghu
     * @throws Exception 
     */
    private static void setDataNode(CuratorFramework client,String path,String message) throws Exception{
        
        Stat stat = client.checkExists().forPath(path);
        System.out.println(stat);
        client.setData().forPath(path, message.getBytes());
    }
    
    private static void deleteDataNode(CuratorFramework client,String path) throws Exception{
        
        Stat stat = client.checkExists().forPath(path);
        System.out.println("deleteNode : "+stat);
        
        Void forPath = client.delete().deletingChildrenIfNeeded().forPath(path);
        
        System.out.println(forPath);
    }
    
    
    private static void setListenterDateNode(CuratorFramework client,String path) throws Exception{
        //第一种方式:
        // 注册观察者，当节点变动时触发  
        client.getData().usingWatcher(new Watcher() {  
            @Override  
            public void process(WatchedEvent event) {  
                System.out.println("node is changed");  
            }  
        }).inBackground().forPath("/test");  
     
        // 结束使用  
        client.close();  
      //第二种方式:
              client.create()
                .creatingParentsIfNeeded()
                .forPath("/zk-huey/cnode", "hello".getBytes());
              /**
               * 在注册监听器的时候，如果传入此参数，当事件触发时，逻辑由线程池处理
               */
              ExecutorService pool = Executors.newFixedThreadPool(2);
              /**
               * 监听数据节点的变化情况
               */
              final NodeCache nodeCache = new NodeCache(client, "/zk-huey/cnode", false);
              nodeCache.start(true);
              nodeCache.getListenable().addListener(
                new NodeCacheListener() {
                  @Override
                  public void nodeChanged() throws Exception {
                    System.out.println("Node data is changed, new data: " + 
                      new String(nodeCache.getCurrentData().getData()));
                  }
                }, 
                pool
              );
              /**
               * 监听子节点的变化情况
               */
              final PathChildrenCache childrenCache = new PathChildrenCache(client, "/zk-huey", true);
              childrenCache.start(StartMode.POST_INITIALIZED_EVENT);
              childrenCache.getListenable().addListener(
                new PathChildrenCacheListener() {
                  @Override
                  public void childEvent(CuratorFramework client, PathChildrenCacheEvent event)
                      throws Exception {
                      switch (event.getType()) {
                      case CHILD_ADDED:
                        System.out.println("CHILD_ADDED: " + event.getData().getPath());
                        break;
                      case CHILD_REMOVED:
                        System.out.println("CHILD_REMOVED: " + event.getData().getPath());
                        break;
                      case CHILD_UPDATED:
                        System.out.println("CHILD_UPDATED: " + event.getData().getPath());
                        break;
                      default:
                        break;
                    }
                  }
                },
                pool
              );
              client.setData().forPath("/zk-huey/cnode", "world".getBytes());
              Thread.sleep(10 * 1000);
              pool.shutdown();
              client.close();
        
    }
    //3
    /**
     
         public static void create(CuratorFramework client, String path, byte[] payload) throws Exception {
        // this will create the given ZNode with the given data
        client.create().forPath(path, payload);
    }

    public static void createEphemeral(CuratorFramework client, String path, byte[] payload) throws Exception {
        // this will create the given EPHEMERAL ZNode with the given data
        client.create().withMode(CreateMode.EPHEMERAL).forPath(path, payload);
    }

    public static String createEphemeralSequential(CuratorFramework client, String path, byte[] payload) throws Exception {
        // this will create the given EPHEMERAL-SEQUENTIAL ZNode with the given
        // data using Curator protection.
        return client.create().withProtection().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath(path, payload);
    }

    public static void setData(CuratorFramework client, String path, byte[] payload) throws Exception {
        // set data for the given node
        client.setData().forPath(path, payload);
    }

    public static void setDataAsync(CuratorFramework client, String path, byte[] payload) throws Exception {
        // this is one method of getting event/async notifications
        CuratorListener listener = new CuratorListener() {
            @Override
            public void eventReceived(CuratorFramework client, CuratorEvent event) throws Exception {
                // examine event for details
            }
        };
        client.getCuratorListenable().addListener(listener);
        // set data for the given node asynchronously. The completion
        // notification
        // is done via the CuratorListener.
        client.setData().inBackground().forPath(path, payload);
    }

    public static void setDataAsyncWithCallback(CuratorFramework client, BackgroundCallback callback, String path, byte[] payload) throws Exception {
        // this is another method of getting notification of an async completion
        client.setData().inBackground(callback).forPath(path, payload);
    }

    public static void delete(CuratorFramework client, String path) throws Exception {
        // delete the given node
        client.delete().forPath(path);
    }

    public static void guaranteedDelete(CuratorFramework client, String path) throws Exception {
        // delete the given node and guarantee that it completes
        client.delete().guaranteed().forPath(path);
    }

    public static List<String> watchedGetChildren(CuratorFramework client, String path) throws Exception {
        
          //Get children and set a watcher on the node. The watcher notification
         // will come through the CuratorListener (see setDataAsync() above).
         
        return client.getChildren().watched().forPath(path);
    }

    public static List<String> watchedGetChildren(CuratorFramework client, String path, Watcher watcher) throws Exception {
        
        // Get children and set the given watcher on the node.
         
        return client.getChildren().usingWatcher(watcher).forPath(path);
    }
     */
}

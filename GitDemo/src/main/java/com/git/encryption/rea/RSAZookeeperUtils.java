package com.git.encryption.rea;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.ACLProvider;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooDefs.Perms;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;

/**
 * 将rsa 序列化存放在 zookeeper中节点上 
 * 看能否取出来
 * @author songqinghu
 *
 */
public class RSAZookeeperUtils {

    private static CuratorFramework client =null;
    public static void main(String[] args) throws Exception {
        
        addNode(getClient());
        getNode(getClient());
    }
    
    private static void addNode(CuratorFramework client) throws Exception{
        //KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象  
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");  
        //初始化密钥对生成器，密钥大小为1024位  
        keyPairGen.initialize(1024);  
        //生成一个密钥对，保存在keyPair中  
        KeyPair keyPair = keyPairGen.generateKeyPair();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(keyPair);
        byte[] bat = bos.toByteArray();
        System.out.println(bat);
        String test = "测试!";
        RSAPublicKey public1 = (RSAPublicKey)keyPair.getPublic();
        byte[] encrypt = encrypt(public1, test.getBytes());
        client.create().creatingParentsIfNeeded().forPath("/rsa3",bat);
        client.create().creatingParentsIfNeeded().forPath("/rsa3/meg",encrypt);
        System.out.println(keyPair);
    }
    
    private static void getNode(CuratorFramework client) throws Exception{
        byte[] forPath = client.getData().forPath("/rsa3");
        System.out.println(forPath);
        ByteArrayInputStream bis = new ByteArrayInputStream(forPath);
        ObjectInputStream ois = new ObjectInputStream(bis);
        KeyPair keyPair = (KeyPair)ois.readObject();
        System.out.println(keyPair);
        
        byte[] meg = client.getData().forPath("/rsa3/meg");
        
        RSAPrivateKey private1 = (RSAPrivateKey) keyPair.getPrivate();
        
        byte[] decrypt = decrypt(private1, meg);
        System.out.println(new String(decrypt));
        
    }
    
    /** 
     * 加密 
     * @param publicKey 
     * @param srcBytes 
     * @return 
     * @throws NoSuchAlgorithmException 
     * @throws NoSuchPaddingException 
     * @throws InvalidKeyException 
     * @throws IllegalBlockSizeException 
     * @throws BadPaddingException 
     */  
    protected static byte[] encrypt(RSAPublicKey publicKey,byte[] srcBytes) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{  
        if(publicKey!=null){  
            //Cipher负责完成加密或解密工作，基于RSA  
            Cipher cipher = Cipher.getInstance("RSA");  
            //根据公钥，对Cipher对象进行初始化  
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);  
            byte[] resultBytes = cipher.doFinal(srcBytes);  
            return resultBytes;  
        }  
        return null;  
    } 
    /** 
     * 解密  
     * @param privateKey 
     * @param srcBytes 
     * @return 
     * @throws NoSuchAlgorithmException 
     * @throws NoSuchPaddingException 
     * @throws InvalidKeyException 
     * @throws IllegalBlockSizeException 
     * @throws BadPaddingException 
     */  
    protected static  byte[] decrypt(RSAPrivateKey privateKey,byte[] srcBytes) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{  
        if(privateKey!=null){  
            //Cipher负责完成加密或解密工作，基于RSA  
            Cipher cipher = Cipher.getInstance("RSA");  
            //根据公钥，对Cipher对象进行初始化  
            cipher.init(Cipher.DECRYPT_MODE, privateKey);  
            byte[] resultBytes = cipher.doFinal(srcBytes);  
            return resultBytes;  
        }  
        return null;  
    }  
    private static CuratorFramework getClient(){

        if(client ==null){
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
        String namespace = "testrsa";
        CuratorFramework client2 = CuratorFrameworkFactory.builder().aclProvider(aclProvider).
        authorization(scheme, auth).
        connectionTimeoutMs(connectionTimeoutMs).
        connectString(connectString).
         namespace(namespace).
        retryPolicy(new RetryNTimes(Integer.MAX_VALUE, 1000)).build();
        client2.start();
        client = client2;
        }
        
        return client;
    }
    
}

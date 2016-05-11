package com.git.zookeeper.solrjclient;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * zookeeper生成 用户的密码
 * @author songqinghu
 *
 */
public class ZookeeperAuth {

    private static String p1 = "admin-user:admin-password";
    private static String p2 = "readonly-user:readonly-password";
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = generateDigest(p1);
        
        System.out.println(password);
        
        String password2 = generateDigest(p2);
        
        System.out.println(password2);
    }
    
    
    public  static String generateDigest(String idPassword) throws NoSuchAlgorithmException
             {
        String parts[] = idPassword.split(":", 2);
        byte digest[] = MessageDigest.getInstance("SHA1").digest(
                idPassword.getBytes());
        return parts[0] + ":" + base64Encode(digest);
    }

    public static String base64Encode(byte[] bstr) {  
    return new sun.misc.BASE64Encoder().encode(bstr);  
    }  
}

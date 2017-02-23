package com.git.solr.auth;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

public class TestX {
    public static void main(String[] args) {
        String sha256 = sha256("songqinghu", "");
        System.out.println(sha256);
    }
    
    public boolean authenticate(String username, String password) {
        String cred = "";
        if (cred == null || cred.isEmpty()) return false;
        cred = cred.trim();
        String salt = null;
        if (cred.contains(" ")) {
          String[] ss = cred.split(" ");
          if (ss.length > 1 && !ss[1].isEmpty()) {
            salt = ss[1];
            cred = ss[0];
          }
        }
        return cred.equals(sha256(password, salt));
      }
    
    public static String sha256(String password, String saltKey) {
        MessageDigest digest;
        try {
          digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
          //log.error(e.getMessage(), e);
          return null;//should not happen
        }
        if (saltKey != null) {
          digest.reset();
          digest.update(Base64.decodeBase64(saltKey));
        }

        byte[] btPass = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        digest.reset();
        btPass = digest.digest(btPass);
        return Base64.encodeBase64String(btPass);
      }

    //v1kx29vsv2JHda4iY+rqpNpHscwW29rH1z6rzI/6LVI= tL5DTOVBr1eRaW8u1Hyo5JluY8bMqkeQJ573pgLynDw= 
    
}

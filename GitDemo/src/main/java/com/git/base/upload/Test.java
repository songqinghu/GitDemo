package com.git.base.upload;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;  
  
public class Test {  
    public static void main(String args[]) throws Exception {  
          
        MultipartEntity multipartEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE,"----------ThIs_Is_tHe_bouNdaRY_$", Charset.defaultCharset());  
        multipartEntity.addPart("phone",new StringBody("136********", Charset.forName("UTF-8")));    
        multipartEntity.addPart("receiver",new StringBody("138***********",Charset.forName("UTF-8")));    
        multipartEntity.addPart("image",new FileBody(new File("C:\\Users\\songqinghu\\Desktop\\1.jpg"),"text/plain"));    
            
        HttpPost request = new HttpPost("http://yotuku.cn/cgi-bin/upload/auto?name=&type=image/jpeg");     
        request.setEntity(multipartEntity);  
        request.addHeader("Content-Type","multipart/form-data; boundary=----------ThIs_Is_tHe_bouNdaRY_$");  
          
        DefaultHttpClient httpClient = new DefaultHttpClient();  
        HttpResponse response =httpClient.execute(request);  
          
        InputStream is = response.getEntity().getContent();  
        BufferedReader in = new BufferedReader(new InputStreamReader(is));  
        StringBuffer buffer = new StringBuffer();  
        String line = "";  
        while ((line = in.readLine()) != null) {  
            buffer.append(line);  
        }  
          
        System.out.println("发送消息收到的返回："+buffer.toString());  
    }  
}  
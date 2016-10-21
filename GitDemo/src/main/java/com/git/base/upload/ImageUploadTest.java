package com.git.base.upload;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * 测试图片上传
 * @Description: TODO
 * @author: songqinghu
 * @date: 2016年10月18日 下午4:54:18
 * Version:1.0
 */
public class ImageUploadTest {

    
    public static void main(String[] args)throws IOException {
        
        //http://yotuku.cn/cgi-bin/upload/auto?name=&type=image/jpeg
        CloseableHttpClient httpClient = HttpClients.createDefault();  
        try{  
            //要上传的文件的路径  
            String filePath = "C:\\Users\\songqinghu\\Desktop\\1.jpg";  
            //把一个普通参数和文件上传给下面这个地址    是一个servlet  
            HttpPost httpPost = new HttpPost("http://yotuku.cn/cgi-bin/upload/auto");  
            //把文件转换成流对象FileBody  
            FileBody bin = new FileBody(new File(filePath));  
            //普通字段  重新设置了编码方式  
              
            HttpEntity reqEntity = MultipartEntityBuilder.create()  
            .addPart("files", bin)//相当于<input type="file" name="media"/>  
            .build();  
              
            httpPost.setEntity(reqEntity);  
              
            System.out.println("发起请求的页面地址 " + httpPost.getRequestLine());  
            //发起请求   并返回请求的响应  
            CloseableHttpResponse response = httpClient.execute(httpPost);  
            try {  
                System.out.println("----------------------------------------");  
                //打印响应状态  
                System.out.println(response.getStatusLine());  
                //获取响应对象  
                HttpEntity resEntity = response.getEntity();  
                if (resEntity != null) {  
                    //打印响应长度  
                    System.out.println("Response content length: " + resEntity.getContentLength());  
                    //打印响应内容  
                    System.out.println(EntityUtils.toString(resEntity,Charset.forName("UTF-8")));  
                }  
                //销毁  
                EntityUtils.consume(resEntity);  
            } finally {  
                response.close();  
            }  
        }finally{  
            httpClient.close();  
        }  
        
    }
    
    
}

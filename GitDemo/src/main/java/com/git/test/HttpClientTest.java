package com.git.test;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.utils.URLEncodedUtils;

import com.alibaba.fastjson.serializer.URLCodec;
import com.git.utils.HttpClientUtil;

/**
 * 请求模拟
 * @author songqinghu
 *
 */
public class HttpClientTest {

    
    public static void main(String[] args) {
        
        Map<String, String> param  = new HashMap<String,String>();
        param.put("q","安");
        String result = HttpClientUtil.doGet("http://localhost:8080/suggest/query/auto.json", param);
        System.out.println(result);
    }
    
}

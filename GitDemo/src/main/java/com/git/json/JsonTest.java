package com.git.json;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

public class JsonTest {


    public static void main(String[] args) {
        
        two();
    }
    
    private static  void two(){
        //将此json转换为实体操作类list中
       String json = "[{\"type\":\"text\",\"text\":\"ssseeddd\"},{\"type\":\"image\",\"text\":\"美图\",\"url\":\"https://...\"},{\"id\":\"5052\",\"text\":\"视频描述信息\",\"length\":\"300000\",\"type\":\"video\",\"url\":\"http://api.v.dev.gomeplus.com/video/nJYz0HnjEfP8-c6D6XSINKm_G76cxU5nQ3FdeFwTkQg.m3u8\",\"coverImage\":\"http://10.125.201.32:7500/v1/tfs/T1DyJTBgbT1RXrhCrK.jpg\"},{\"type\":\"item\",\"text\":\"sg\",\"id\":\"898989\",\"shopId\":0,\"kid\":\"11111s\"},{\"type\":\"shop\",\"text\":\"sg\",\"id\":\"898989\"}]";
       
       List<BasicTypeContent> result = JSON.parseArray(json, BasicTypeContent.class);
       JSONArray parseArray = JSONObject.parseArray(json);
       System.out.println(parseArray);
       
       for (BasicTypeContent content : result) {
           System.out.println(content);
            if("text".equals(content.getType())){
                System.out.println(content.getText());
            }
            if("image".equals(content.getType())){
                System.out.println(content.getUrl());
            }
       }
       
    }
    
    private static void one(){
        
        SocialUserResult socialUserResult = new SocialUserResult();
        List<SimpleUser> users = socialUserResult.getUsers();
        SimpleUser simpleUser = new SimpleUser();
        users.add(simpleUser);
        simpleUser.setOne("one");
        simpleUser.setUserId(1l);
        
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(SimpleUser.class);  
        String jsonString = JSON.toJSONString(socialUserResult, filter);
        System.out.println(jsonString);
        
        String jsonstr = "{\"totalCount\":258,\"message\":\"\",\"data\":{\"users\":[{\"userId\":625},{\"userId\":200},{\"userId\":171},{\"userId\":247},{\"userId\":237},{\"userId\":227},{\"userId\":201},{\"userId\":181},{\"userId\":6},{\"userId\":135}]}}";
        
        Object parse = JSON.parse(jsonstr);
        System.out.println(parse);
    }
}

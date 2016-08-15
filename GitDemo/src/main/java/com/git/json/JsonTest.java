package com.git.json;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

public class JsonTest {


    public static void main(String[] args) {
        
        four();
    }
    
    private static void four(){
        
        String b = "{\"meixin_shop\":{\"shards\":{\"shard1\":{\"range\":\"80000000-7fffffff\",\"state\":\"active\",\"replicas\":{\"core_node1\":{\"state\":\"active\",\"core\":\"meixin_shop\",\"node_name\":\"10.125.2.44:8001_solr\",\"base_url\":\"http://10.125.2.44:8001/solr\",\"leader\":\"true\"},\"core_node2\":{\"state\":\"down\",\"core\":\"meixin_shop\",\"node_name\":\"10.125.2.45:8001_solr\",\"base_url\":\"http://10.125.2.45:8001/solr\"}}}},\"maxShardsPerNode\":\"1\",\"router\":{\"name\":\"compositeId\"},\"replicationFactor\":\"1\",\"autoAddReplicas\":\"false\",\"autoCreated\":\"true\"},\"meixin_suggest\":{\"shards\":{\"shard1\":{\"range\":\"80000000-7fffffff\",\"state\":\"active\",\"replicas\":{\"core_node1\":{\"state\":\"down\",\"core\":\"meixin_suggest_shard1_replica1\",\"node_name\":\"10.125.2.45:8001_solr\",\"base_url\":\"http://10.125.2.45:8001/solr\"},\"core_node2\":{\"state\":\"active\",\"core\":\"meixin_suggest_shard1_replica2\",\"node_name\":\"10.125.2.44:8001_solr\",\"base_url\":\"http://10.125.2.44:8001/solr\",\"leader\":\"true\"}}}},\"maxShardsPerNode\":\"1\",\"router\":{\"name\":\"compositeId\"},\"replicationFactor\":\"1\",\"autoAddReplicas\":\"false\",\"autoCreated\":\"true\"},\"meixin_topic\":{\"shards\":{\"shard1\":{\"range\":\"80000000-7fffffff\",\"state\":\"active\",\"replicas\":{\"core_node1\":{\"state\":\"down\",\"core\":\"meixin_topic_shard1_replica1\",\"node_name\":\"10.125.2.45:8001_solr\",\"base_url\":\"http://10.125.2.45:8001/solr\"},\"core_node2\":{\"state\":\"active\",\"core\":\"meixin_topic_shard1_replica2\",\"node_name\":\"10.125.2.44:8001_solr\",\"base_url\":\"http://10.125.2.44:8001/solr\",\"leader\":\"true\"}}}},\"maxShardsPerNode\":\"1\",\"router\":{\"name\":\"compositeId\"},\"replicationFactor\":\"1\",\"autoAddReplicas\":\"false\",\"autoCreated\":\"true\"},\"meixin_product\":{\"shards\":{\"shard1\":{\"range\":\"80000000-7fffffff\",\"state\":\"active\",\"replicas\":{\"core_node1\":{\"state\":\"active\",\"core\":\"meixin_product\",\"node_name\":\"10.125.2.44:8001_solr\",\"base_url\":\"http://10.125.2.44:8001/solr\",\"leader\":\"true\"},\"core_node2\":{\"state\":\"down\",\"core\":\"meixin_product\",\"node_name\":\"10.125.2.45:8001_solr\",\"base_url\":\"http://10.125.2.45:8001/solr\"}}}},\"maxShardsPerNode\":\"1\",\"router\":{\"name\":\"compositeId\"},\"replicationFactor\":\"1\",\"autoAddReplicas\":\"false\",\"autoCreated\":\"true\"},\"meixin_vshop_product\":{\"shards\":{\"shard1\":{\"range\":\"80000000-7fffffff\",\"state\":\"active\",\"replicas\":{\"core_node1\":{\"state\":\"down\",\"core\":\"meixin_vshop_product\",\"node_name\":\"10.125.2.44:8001_solr\",\"base_url\":\"http://10.125.2.44:8001/solr\"},\"core_node2\":{\"state\":\"down\",\"core\":\"meixin_vshop_product\",\"node_name\":\"10.125.2.45:8001_solr\",\"base_url\":\"http://10.125.2.45:8001/solr\"}}}},\"maxShardsPerNode\":\"1\",\"router\":{\"name\":\"compositeId\"},\"replicationFactor\":\"1\",\"autoAddReplicas\":\"false\",\"autoCreated\":\"true\"},\"meixin_user\":{\"shards\":{\"shard1\":{\"range\":\"80000000-7fffffff\",\"state\":\"active\",\"replicas\":{\"core_node1\":{\"state\":\"active\",\"core\":\"meixin_user_shard1_replica2\",\"node_name\":\"10.125.2.44:8001_solr\",\"base_url\":\"http://10.125.2.44:8001/solr\",\"leader\":\"true\"},\"core_node2\":{\"state\":\"down\",\"core\":\"meixin_user_shard1_replica1\",\"node_name\":\"10.125.2.45:8001_solr\",\"base_url\":\"http://10.125.2.45:8001/solr\"}}}},\"maxShardsPerNode\":\"1\",\"router\":{\"name\":\"compositeId\"},\"replicationFactor\":\"1\",\"autoAddReplicas\":\"false\",\"autoCreated\":\"true\"},\"meixin_group\":{\"shards\":{\"shard1\":{\"range\":\"80000000-7fffffff\",\"state\":\"active\",\"replicas\":{\"core_node1\":{\"state\":\"down\",\"core\":\"meixin_group_shard1_replica1\",\"node_name\":\"10.125.2.45:8001_solr\",\"base_url\":\"http://10.125.2.45:8001/solr\"},\"core_node2\":{\"state\":\"active\",\"core\":\"meixin_group_shard1_replica2\",\"node_name\":\"10.125.2.44:8001_solr\",\"base_url\":\"http://10.125.2.44:8001/solr\",\"leader\":\"true\"}}}},\"maxShardsPerNode\":\"1\",\"router\":{\"name\":\"compositeId\"},\"replicationFactor\":\"1\",\"autoAddReplicas\":\"false\",\"autoCreated\":\"true\"}}";
        
        String setting = new String(b).replace("\n", "").replace("\r", "");
        Pattern p = Pattern.compile("\"state\":\"(.+?)\".+?\"core\":\"(.+?)\".+?\"node_name\":\"(.+?)\"");
        Matcher matcher = p.matcher(setting);
    
    }
    
    private static void three(){
        String json = "{\"id\":\"57abd3774b70a411766eef6c\",\"send_time\":1470878619441,\"data\":{\"id\":\"57abd3774b70a411766eef6c\",\"updateOperator\":\"1419\",\"imId\":\"b_1465\",\"groupId\":\"mx14191467084714511\",\"createTime\":1470878583893,\"createOperator\":\"1465\",\"groupPersonId\":1465,\"updateTime\":1470878619000,\"states\":2,\"role\":1,\"isTrue\":0,\"isRemind\":1},\"action\":\"CREATE\",\"type\":\"social.groupPersons\"}";
        
        String string = net.sf.json.JSONObject.fromObject(json).getJSONObject("data").getString("groupId");
        System.out.println(string);
        
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

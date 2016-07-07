package com.git.mq.rocket;

import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;

public class RocketProducter {
   

    public static void main(String[] args) {
                DefaultMQProducer producer = new DefaultMQProducer("group"); 
                
                producer.setNamesrvAddr("");   
                try {  
                    producer.start();  
                      
                    Message msg = new Message("meixin_group",   
                            "push",   
                            "1",   
                            "Just for test.".getBytes());  
                      
                    SendResult result = producer.send(msg);  
                    System.out.println("id:" + result.getMsgId() +  
                            " result:" + result.getSendStatus());  

                } catch (Exception e) {  
                    e.printStackTrace();  
                }finally{  
                    producer.shutdown();  
                }  
            }

}

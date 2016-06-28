package com.git.mq.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;



public class UserProducer {
   
    private static final String EXCHANGE_NAME = "topic_test";  
    
    public static void main(String[] argv) throws Exception  
    {  
        // 创建连接和频道  
        ConnectionFactory factory = new ConnectionFactory();  
        factory.setHost("10.69.213.66");
        factory.setPort(5672);
        factory.setUsername("data_ic_user");
        factory.setPassword("data_ic_user");
        factory.setVirtualHost("/ic_data");
        Connection connection = factory.newConnection();  
        Channel channel = connection.createChannel();  
  
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");  
        
        String routing_key = new String("user.info.group");
 
        for (int i = 0; i <50; i++) {
            String msg = ("user.info"+i);
            channel.basicPublish(EXCHANGE_NAME, routing_key, null, msg 
                    .getBytes());  
            System.out.println(" [x] Sent routingKey = "+routing_key+" ,msg = " + msg + ".");  
        }
 
  
        channel.close();  
        connection.close();  
    }  
}

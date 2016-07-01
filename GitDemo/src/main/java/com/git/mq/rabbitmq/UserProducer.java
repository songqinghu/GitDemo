package com.git.mq.rabbitmq;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;



public class UserProducer {
   
    private static final String EXCHANGE_NAME = "song_exchange_topic_one";  
    
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
  
        channel.exchangeDeclare(EXCHANGE_NAME, "topic",true); 
        
        String routing_key = new String("user.info.group");
        BasicProperties prop = new BasicProperties();
        //prop.builder() 属性设置 持久化消息
        for (int i = 0; i <100; i++) {
            String msg = ("user.info"+i);
            channel.basicPublish(EXCHANGE_NAME, routing_key, MessageProperties.PERSISTENT_TEXT_PLAIN, msg 
                    .getBytes());  
            System.out.println(" [x] Sent routingKey = "+routing_key+" ,msg = " + msg + ".");  
        }
 
        Thread.sleep(20000);
        channel.close();  
        connection.close();  
    }  
}

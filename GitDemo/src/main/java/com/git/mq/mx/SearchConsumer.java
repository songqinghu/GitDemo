package com.git.mq.mx;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class SearchConsumer {

    private static final String EXCHANGE_NAME = "topic_direct";  
    
    public static void main(String[] argv) throws Exception  
    {  
        // 创建连接和频道  
        ConnectionFactory factory = new ConnectionFactory();  
        factory.setHost("10.69.112.76");
        factory.setPort(5672);
        factory.setUsername("bsarch");
        factory.setPassword("bsarch");
        factory.setVirtualHost("/bs-arch");
        Connection connection = factory.newConnection();  
        Channel channel = connection.createChannel();   
        // 声明转发器  
       // channel.exchangeDeclare(EXCHANGE_NAME, "direct");  
        // 随机生成一个队列  
        //String queueName = channel.queueDeclare().getQueue();  
        String queueName = "searchQueue";
          
        //接收所有与kernel相关的消息  
       // channel.queueBind(queueName, EXCHANGE_NAME, "user.info.group");  
  
        System.out.println(" [*] Waiting for messages about search. To exit press CTRL+C");  
  
        QueueingConsumer consumer = new QueueingConsumer(channel);  
        channel.basicConsume(queueName, true, consumer);  
  
        while (true)  
        {  
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();  
            String message = new String(delivery.getBody());  
            String routingKey = delivery.getEnvelope().getRoutingKey();  
  
            System.out.println(" [x] Received routingKey = " + routingKey  
                    + ",msg = " + message + ".");  
        }  
    }  
}

package com.git.mq.rabbitmq;

import java.util.Map;
import java.util.Random;

import org.apache.commons.lang.math.RandomUtils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class DataConsumer {
    
    private static final String EXCHANGE_NAME = "song_exchange_topic_one";  
    private static final String QUEUE_NAME = "song_queue_topic_one";  
    
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
        // 声明转发器  
        channel.exchangeDeclare(EXCHANGE_NAME, "topic",true); 
        channel.basicQos(100);
        // 随机生成一个队列  
        //String queueName = channel.queueDeclare().getQueue();  
        //生成持久化的队列 或者使用设置好的持久化的队列
        Map<String, Object> arguments =null;//属性
        channel.queueDeclare(QUEUE_NAME, true, false, false, arguments );
        //接收所有
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "user.info.#");  
  
        System.out.println(" [*] Waiting for messages about data. To exit press CTRL+C");  
  
        QueueingConsumer consumer = new QueueingConsumer(channel);  
        channel.basicConsume(QUEUE_NAME, false, consumer);  //消息自动确认关闭
        int x = 0;
        Random random = new Random();
        while (true)  
        {  
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();  
            String message = new String(delivery.getBody());  
            String routingKey = delivery.getEnvelope().getRoutingKey();  
            
            System.out.println(" [x] Received routingKey = " + routingKey  
                    + ",msg = " + message + "." + "当前消息数目: "+(++x)); 
            
            Thread.sleep(random.nextInt(1000));
            //执行结束,确认删除
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            x--;
        }  
    }  
}

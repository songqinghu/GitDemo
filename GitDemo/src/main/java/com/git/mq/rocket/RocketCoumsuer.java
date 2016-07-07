package com.git.mq.rocket;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerOrderly;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.message.MessageExt;

public class RocketCoumsuer {
    
    
    public static void main(String[] args) throws MQClientException {

        String mqGroup = "group";
        String namesrvAddr = "";
        String topic = "meixin_group";

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(mqGroup);
        consumer.setNamesrvAddr(namesrvAddr);
        consumer.subscribe(topic, "*");
        consumer.setPullBatchSize(1000);// 每次拉取 ${}条
        consumer.setPullInterval(3000); // 轮询间隔
        consumer.setConsumeMessageBatchMaxSize(500);// 每次消费

        consumer.registerMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {

                for (MessageExt msg : msgs) {
                    String message = new String(msg.getBody());
                    System.out.println(message);
                }
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });
        consumer.start();
        
    }
}

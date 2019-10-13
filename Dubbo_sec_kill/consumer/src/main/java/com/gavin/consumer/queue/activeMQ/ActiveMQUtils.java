package com.gavin.consumer.queue.activeMQ;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

/***
 * ActiveMQ 工具类
 */

@Component
public class ActiveMQUtils {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    /***
     * 发送队列消息  destination是发送到的队列，message是待发送的消息
     * @param name
     * @param message
     */
    public void sendQueueMesage(String name,Object message){
        Destination destination=new ActiveMQQueue(name);
        jmsMessagingTemplate.convertAndSend(destination,message);
    }

}

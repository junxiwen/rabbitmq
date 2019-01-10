package com.hyanzz.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2019/1/10.
 */
@Component
@RabbitListener(queues = "topic.mess")
public class TopicMessReceiver {
    @RabbitHandler
    public void process(String msg) {
        System.out.println("topicMessReceiver  : " +msg);
    }
}

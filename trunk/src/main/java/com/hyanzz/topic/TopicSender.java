package com.hyanzz.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2019/1/10.
 */

/***
 topic 是RabbitMQ中最灵活的一种方式，可以根据binding_key自由的绑定不同的队列
 首先对topic规则配置，这里使用两个队列来测试（也就是在Application类中创建和绑定的topic.message和topic.messages两个队列），其中topic.message的bindting_key为
 “topic.message”，topic.messages的binding_key为“topic.#”；
 */
@Component
public class TopicSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    /***
     * BeanConfig中
     * topic.message的bindting_key为“topic.message”，
     * topic.messages的binding_key为“topic.#”；
     * topic.mess的binding_key为“topic.*”；
     */
    public void send() {
        String msg1 = "I am topic.message msg======";
        rabbitTemplate.convertAndSend("exchange", "topic.message", msg1);
        String msg2 = "I am topic.messages msg########";
        rabbitTemplate.convertAndSend("exchange", "topic.messages.11", msg2);

        String msg3 = "I am topic.mess msg***";
        rabbitTemplate.convertAndSend("exchange", "topic.mess", msg3);
    }
    /***
     * 根据运行结果：
     * sender1发送的消息,routing_key是“topic.message”，
     * 所以exchange里面的绑定的binding_key是“topic.message”，topic.＃,topic.* 都符合路由规则;所以sender1 发送的消息，3个队列都能接收到
     * sender2发送的消息，routing_key是“topic.messages”，
     * 所以exchange里面的绑定的binding_key只有topic.＃都符合路由规则;所以sender2发送的消息只有队列topic.messages能收到。
     * sender3发送的消息，routing_key是“topic.mess”，
     * 所以exchange里面的绑定的binding_key有topic.* 和 topic.# 符合路由规则;所以sender2发送的消息只有队列topic.messages和topic.mess能收到。
     */
}

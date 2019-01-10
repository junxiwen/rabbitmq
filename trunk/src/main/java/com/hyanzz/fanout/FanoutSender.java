package com.hyanzz.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2019/1/10.
 */
@Component
public class FanoutSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    /***
     * Fanout 就是我们熟悉的广播模式或者订阅模式，给Fanout转发器发送消息，绑定了这个转发器的所有队列都收到这个消息。
     */
    public void send() {
        String msgString="fanoutSender :hello i am hyanzz";
        System.out.println(msgString);
        rabbitTemplate.convertAndSend("fanoutExchange","111.ee", msgString);
    }
    /***
     * 根据运行结果：
     * 就算fanoutSender发送消息的时候，指定了routing_key为"111.ee"，但是所有接收者都接受到了消息
     */
}

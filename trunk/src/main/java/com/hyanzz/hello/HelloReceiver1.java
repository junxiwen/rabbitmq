package com.hyanzz.hello;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2019/1/10.
 */
@Component
@RabbitListener(queues = "helloQueue")
public class HelloReceiver1 {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver1接收: " + hello);
    }
}

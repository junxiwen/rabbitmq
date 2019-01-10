package com.hyanzz.hello;

import com.hyanzz.utils.MyDateUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Administrator on 2019/1/10.
 */
@Component
public class HelloSender1 {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String mess) {
        String sendMsg = mess+"==========="+MyDateUtils.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss");
        rabbitTemplate.convertAndSend("helloQueue", sendMsg);
    }

}

package com.hyanzz.callback;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by Administrator on 2019/1/14.
 */
@Component
public class CallBackSender implements RabbitTemplate.ConfirmCallback {

    @Autowired
    private RabbitTemplate rabbitTemplateNew;
    public void send() {
        rabbitTemplateNew.setConfirmCallback(this);
        String msg="callbackSender : i am callback sender";
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        System.out.println("callbackSender UUID: " + correlationData.getId());
        rabbitTemplateNew.convertAndSend("exchange", "topic.message", msg, correlationData);
    }

    @Override
    public void confirm(@Nullable CorrelationData correlationData, boolean b, @Nullable String s) {
        System.out.println("callback confirm: " + correlationData.getId());
    }
}

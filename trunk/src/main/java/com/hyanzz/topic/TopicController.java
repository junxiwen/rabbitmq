package com.hyanzz.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/1/10.
 */
@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicSender topicSender;

    @PostMapping
    public void topicTest() {
        topicSender.send();
    }
}

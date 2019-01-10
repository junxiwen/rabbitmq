package com.hyanzz.fanout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/1/10.
 */
@RestController
@RequestMapping("/fanout")
public class FanoutController {

    @Autowired
    private FanoutSender fanoutSender;

    @PostMapping
    public void fanoutTest() {
        fanoutSender.send();
    }
}

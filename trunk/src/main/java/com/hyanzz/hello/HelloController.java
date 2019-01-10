package com.hyanzz.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/1/10.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private HelloSender1 helloSender1;
    @Autowired
    private HelloSender2 helloSender2;

    @PostMapping
    public void hello() {
        for(int i = 0 ; i <= 10 ; i ++){
            helloSender1.send("sender1发送");
            helloSender2.send("sender2发送");
        }
    }

    @PostMapping("/toMany")
    public void helloToMany() {
        for(int i = 0 ; i <= 10 ; i ++){
            helloSender1.send("toMany_sender1");
            helloSender2.send("toMany_sender2");
            try {
                Thread.sleep(100);
            }catch (Exception e){

            }
        }
    }
}

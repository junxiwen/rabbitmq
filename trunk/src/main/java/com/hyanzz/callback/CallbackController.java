package com.hyanzz.callback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/1/14.
 */
@RestController
@RequestMapping("/callback")
public class CallbackController {

    @Autowired
    private CallBackSender callBackSender;
    @PostMapping
    public void callback() {
        callBackSender.send();
    }
}

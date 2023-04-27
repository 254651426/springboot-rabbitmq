package com.yangjie.rabbitmq.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class TestController {

    @Autowired
    AmqpTemplate amqpTemplate;

    @RequestMapping("/hello")
    public String show(HttpServletResponse resp, HttpServletRequest req) {
        amqpTemplate.convertAndSend("FANOUT_EXCHANGE",null,"-------- a topic msg : shanghai.gupao.teacher");
        return "hello world";
    }
}

package com.hiram.dubbo.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.hiram.dubbo.api.service.DemoService;
import com.hiram.dubbo.provider.rabbitmq.MsgProducer;
import com.hiran.dubbo.entity.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "${demo.service.version}")
public class DemoServiceImpl implements DemoService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public String sayHello(String name) {

        MsgProducer msgProducer = new MsgProducer(rabbitTemplate);
        msgProducer.sendMsg("我是贾柏林");

        return "Hello " + name + ", I'm provider!111";
    }

    @Override
    public String sayHello(User user) {
        return user.getName();
    }
}

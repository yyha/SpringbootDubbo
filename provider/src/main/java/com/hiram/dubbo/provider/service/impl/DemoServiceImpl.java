package com.hiram.dubbo.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.hiram.dubbo.api.service.DemoService;
import com.hiram.dubbo.provider.config.RabbitConfig;
import com.hiran.dubbo.entity.User;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.UUID;

/**
 * @author Administrator
 */
@Service(version = "${demo.service.version}")
public class DemoServiceImpl implements DemoService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public String sayHello(String str) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","zhangsan");
        jsonObject.put("age",23);
//        Message message = MessageBuilder
//                .withBody(jsonObject.toJSONString().getBytes())
//                .setContentType(MessageProperties.CONTENT_TYPE_JSON)
//                .build();
//        // 发送消息到默认的交换器，默认的路由键
//        rabbitTemplate.send(RabbitConfig.QUEUE_A,message);

        return "Hello " + str + ", I'm provider!222";
    }

    @Override
    public String sayHello(User user) {
        return user.getName();
    }
}

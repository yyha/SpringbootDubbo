package com.hiram.dubbo.provider.rabbitmq;

import com.alibaba.fastjson.JSON;
import com.hiram.dubbo.provider.config.RabbitConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Administrator
 */
@Component
public class MsgReceiverC_one  {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RabbitListener(queues = RabbitConfig.QUEUE_A)
    public void process(Map msg) {
        System.out.println("接收处理队列A当中的消息：--ONE " + JSON.toJSONString(msg));
        logger.info("接收处理队列A当中的消息： " + msg);
    }

}
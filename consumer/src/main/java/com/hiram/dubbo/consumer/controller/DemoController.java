package com.hiram.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hiram.dubbo.api.service.DemoService;
import com.hiran.dubbo.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@RestController
public class DemoController {

    @Reference(version = "${demo.service.version}")
    private DemoService demoService;

    @GetMapping("/say/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return demoService.sayHello(name);
    }
    @GetMapping("/say2/{name}")
    public String sayHello2(@PathVariable("name") String name) {
        User user = new User();
        user.setName(name);
        return demoService.sayHello(user);
    }
}

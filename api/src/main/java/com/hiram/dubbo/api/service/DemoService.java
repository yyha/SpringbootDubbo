package com.hiram.dubbo.api.service;


import com.hiran.dubbo.entity.User;

public interface DemoService {
    public String sayHello(String name);
    public String sayHello(User user);
}

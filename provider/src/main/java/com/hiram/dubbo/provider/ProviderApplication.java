package com.hiram.dubbo.provider;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableDubbo

/**
 * session 过期时间300s
 */
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 300)
@SpringBootApplication
public class ProviderApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ProviderApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

}


package com.skr.im.access;

import com.skr.im.access.utils.SpringContextHolder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class AccessApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AccessApplication.class, args);
        SpringContextHolder bean = context.getBean(SpringContextHolder.class);
        System.out.println(bean);
    }

}

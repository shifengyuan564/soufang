package com.imooc.soufang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication(exclude = {
        // TODO: 暂时代替 security.basic.enabled=false (HTTP基本验证关闭)
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
@RestController
public class SoufangApplication {
    public static void main(String[] args) {
        SpringApplication.run(SoufangApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, es";
    }
}


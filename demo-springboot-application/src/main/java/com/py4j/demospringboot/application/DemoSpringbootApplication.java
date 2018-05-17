package com.py4j.demospringboot.application;

import com.py4j.demospringboot.service.MyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(scanBasePackages = "com.py4j")
public class DemoSpringbootApplication {

    private final MyService mMyService;

    public DemoSpringbootApplication(MyService pMyService) {
        mMyService = pMyService;
    }

    @GetMapping("/")
    public String home() {
        return mMyService.getMesssage();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringbootApplication.class, args);
    }
}

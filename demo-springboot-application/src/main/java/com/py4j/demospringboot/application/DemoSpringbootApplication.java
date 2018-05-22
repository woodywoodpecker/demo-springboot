package com.py4j.demospringboot.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;

@EnableCaching
@EnableScheduling
@RestController
@SpringBootApplication(scanBasePackages = "com.py4j")
public class DemoSpringbootApplication {

//    private final MyService mMyService;

//    public DemoSpringbootApplication(MyService pMyService) {
//        mMyService = pMyService;
//    }

//    @GetMapping("/")
//    public String home() {
//        return mMyService.getMesssage();
//    }

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringbootApplication.class, args);
    }
}

package com.py4j.demospringboot.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest("service.message=Hello")
public class DemoSpringbootServiceApplicationTests {

    @Autowired
    private MyService myService;

    @Test
    public void contextLoads() {
        assertThat(myService.getMesssage()).isNotNull();
    }

    @SpringBootApplication
    static class TestConfiguration {

    }

}

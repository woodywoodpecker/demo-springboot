package com.py4j.demospringboot.service;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author Warren
 * @CreateTime 17.May.2018
 * @Version V1.0
 */
@ConfigurationProperties("service")
public class ServiceProperties {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String pMessage) {
        message = pMessage;
    }
}

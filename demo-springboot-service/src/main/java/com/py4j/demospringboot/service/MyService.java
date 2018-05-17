package com.py4j.demospringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

/**
 * @Author Warren
 * @CreateTime 17.May.2018
 * @Version V1.0
 */
@Service
@EnableConfigurationProperties(ServiceProperties.class)
public class MyService {

    @Autowired
    private ServiceProperties mServiceProperties;

    public String getMesssage () {
        return this.mServiceProperties.getMessage();
    }
}

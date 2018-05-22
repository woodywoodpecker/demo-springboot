package com.py4j.demospringboot.application.service;

import com.py4j.demospringboot.application.po.GithubUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

/**
 * @Author Warren
 * @CreateTime 22.May.2018
 * @Version V1.0
 */
@Service
public class GitHubLookupService {

    private final Logger mLogger = LoggerFactory.getLogger(this.getClass());

    private final RestTemplate restTemplate;

    public GitHubLookupService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public CompletableFuture<GithubUser> findUser(String user) throws InterruptedException {
        mLogger.info("[GitHubLookupService] [findUser] :: Looking up {}" , user);
        String url = String.format("https://api.github.com/users/%s", user);
        GithubUser results = restTemplate.getForObject(url, GithubUser.class);
        Thread.sleep(5000);
        return CompletableFuture.completedFuture(results);
    }

}

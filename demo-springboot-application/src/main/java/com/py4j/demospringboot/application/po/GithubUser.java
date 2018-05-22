package com.py4j.demospringboot.application.po;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @Author Warren
 * @CreateTime 22.May.2018
 * @Version V1.0
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class GithubUser {

    private String name;

    private String blog;

    public String getName() {
        return name;
    }

    public void setName(String pName) {
        name = pName;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String pBlog) {
        blog = pBlog;
    }

    @Override
    public String toString() {
        return "GithubUser{" +
                "name='" + name + '\'' +
                ", blog='" + blog + '\'' +
                '}';
    }
}

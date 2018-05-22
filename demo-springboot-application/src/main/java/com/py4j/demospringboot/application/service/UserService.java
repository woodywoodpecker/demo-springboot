package com.py4j.demospringboot.application.service;

import com.py4j.demospringboot.application.po.Customer;
import com.py4j.demospringboot.application.po.GithubUser;

import java.util.List;

public interface UserService {

    Iterable<Customer> findAll();

    Customer findById(long id);

    boolean save (String name, String email);

    boolean save (long id,String name,String email);

    boolean deleteById(long id);

    List<GithubUser> getGithubUsers (int number);
}

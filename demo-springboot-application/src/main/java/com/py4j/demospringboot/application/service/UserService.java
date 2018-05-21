package com.py4j.demospringboot.application.service;

import com.py4j.demospringboot.application.po.Customer;

public interface UserService {

    Iterable<Customer> findAll();

    Customer findById(long id);

    boolean save (String name, String email);

    boolean save (long id,String name,String email);

    boolean deleteById(long id);
}

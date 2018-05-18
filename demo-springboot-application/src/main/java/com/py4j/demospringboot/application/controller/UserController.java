package com.py4j.demospringboot.application.controller;

import com.py4j.demospringboot.application.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/all")
    public Object getAllCustomers () {
        return customerRepository.findAll();
    }

}

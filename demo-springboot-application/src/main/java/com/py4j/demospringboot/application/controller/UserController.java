package com.py4j.demospringboot.application.controller;

import com.py4j.demospringboot.application.CustomerRepository;
import com.py4j.demospringboot.application.po.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger mLogger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/all")
    public Object getAllCustomers () {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Object getCustomerById (@PathVariable String id) {
        return customerRepository.findById(Long.valueOf(id));
    }

    @PostMapping("/{name}/{email}")
    public Object addCustomer (@PathVariable String name,@PathVariable String email) {
        Customer c = new Customer();
        c.setName(name);
        c.setEmail(email);
        try {
            customerRepository.save(c);
        } catch (Exception e) {
            mLogger.error("",e);
            return false;
        }
        return true;
    }

    @DeleteMapping("/{id}")
    public Object delCustomer (@PathVariable String id) {
        try {
            customerRepository.deleteById(Long.valueOf(id));
        } catch (Exception e) {
            mLogger.error("",e);
            return false;
        }
        return true;
    }

    @PutMapping("/{id}/{name}/{email}")
    public Object updateCustomer (@PathVariable String id,@PathVariable String name,@PathVariable String email) {
        Optional<Customer> optional = customerRepository.findById(Long.valueOf(id));
        if (!optional.isPresent()) {
            mLogger.warn("[UserController] [updateCustomer] => no customer found by id {}",id);
            return false;
        }
        Customer customer = optional.get();
        customer.setName(name);
        customer.setEmail(email);
        customerRepository.save(customer);
        try {
            customerRepository.save(customer);
        } catch (Exception e) {
            mLogger.error("",e);
            return false;
        }
        return true;
    }
}

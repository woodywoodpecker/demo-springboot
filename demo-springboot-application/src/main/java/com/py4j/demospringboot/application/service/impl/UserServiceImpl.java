package com.py4j.demospringboot.application.service.impl;

import com.py4j.demospringboot.application.po.Customer;
import com.py4j.demospringboot.application.repository.CustomerRepository;
import com.py4j.demospringboot.application.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author Warren
 * @CreateTime 21.May.2018
 * @Version V1.0
 */
@Service
public class UserServiceImpl implements UserService {

    private final Logger mLogger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(long id) {
        Optional<Customer> option = customerRepository.findById(id);
        if (option.isPresent()) {
            if (mLogger.isDebugEnabled()) {
                mLogger.debug("[UserServiceImpl] [findById] :: no customer found by {}",id);
            }
            return null;
        }
        return option.get();
    }

    @Override
    public boolean save(String name, String email) {
        try {
            Customer customer = new Customer();
            customer.setName(name);
            customer.setEmail(email);
            customerRepository.save(customer);
        } catch (Exception e) {
            if (mLogger.isErrorEnabled()) {
                mLogger.error("[UserServiceImpl] [save] :: create customer failure");
            }
            return false;
        }
        return true;
    }

    @Override
    public boolean save(long id, String name, String email) {
        try {
            Customer customer = findById(id);
            customer.setName(name);
            customer.setEmail(email);
            customerRepository.save(customer);
        }  catch (Exception e) {
            if (mLogger.isErrorEnabled()) {
                mLogger.error("[UserServiceImpl] [save] :: update customer failure");
            }
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteById(long id) {
        try {
            customerRepository.deleteById(id);
        }  catch (Exception e) {
            if (mLogger.isErrorEnabled()) {
                mLogger.error("[UserServiceImpl] [deleteById] :: delete customer failure,id is {}",id);
            }
            return false;
        }
        return true;
    }
}

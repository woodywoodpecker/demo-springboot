package com.py4j.demospringboot.application;

import com.py4j.demospringboot.application.po.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {

}

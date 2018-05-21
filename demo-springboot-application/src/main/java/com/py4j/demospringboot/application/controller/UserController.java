package com.py4j.demospringboot.application.controller;

import com.py4j.demospringboot.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public Object getAllCustomers () {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Object getCustomerById (@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/{name}/{email}")
    public Object addCustomer (@PathVariable String email, @PathVariable String name) {
        return userService.save(name,email);
    }

    @DeleteMapping("/{id}")
    public Object delCustomer (@PathVariable Long id) {
        return userService.deleteById(id);
    }

    @PutMapping("/{id}/{name}/{email}")
    public Object updateCustomer (@PathVariable Long id, @PathVariable String name,@PathVariable String email) {
        return userService.save(id,name,email);
    }
}

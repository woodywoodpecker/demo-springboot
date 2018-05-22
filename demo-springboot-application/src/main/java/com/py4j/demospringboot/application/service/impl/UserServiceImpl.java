package com.py4j.demospringboot.application.service.impl;

import com.py4j.demospringboot.application.po.Customer;
import com.py4j.demospringboot.application.po.GithubUser;
import com.py4j.demospringboot.application.repository.CustomerRepository;
import com.py4j.demospringboot.application.service.GitHubLookupService;
import com.py4j.demospringboot.application.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

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

    @Autowired
    private GitHubLookupService mGitHubLookupService;

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

    @Override
    public List<GithubUser> getGithubUsers(int number) {
        if (number > 0) {
            try {
                long start = System.currentTimeMillis();
                List<GithubUser> users = new ArrayList<>();
                CompletableFuture<GithubUser>[] pages = new CompletableFuture[number];
                for (int i = 0; i < number; i++) {
                    CompletableFuture<GithubUser> page = mGitHubLookupService.findUser("00"+i);
                    pages[i] = page;
                }
                CompletableFuture.allOf(pages).join();
                /**
                 * 这个地方是比较容易踩到坑的，在异步调用的时候，不能先去尝试获取CompletableFuture里面的数据，
                 * 否则这个地方会按照同步处理；所以需要等到所有数据都回来之后，再去访问CompletableFuture的数据
                 */
                for (CompletableFuture<GithubUser> page : pages) {
                    users.add(page.get());
                }
                mLogger.info("[UserServiceImpl] [getGithubUsers] => Elapsed time: {}",(System.currentTimeMillis()-start));
                return users;
            } catch (Exception pE) {
                mLogger.error("[UserServiceImpl] [getGithubUsers] => get github user failure",pE);
            }
        }
        return Collections.emptyList();
    }
}

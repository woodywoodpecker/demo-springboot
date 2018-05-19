package com.py4j.demospringboot.application.controller;

import com.py4j.demospringboot.application.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author Warren
 * @CreateTime 19.May.2018
 * @Version V1.0
 */
@Controller
@RequestMapping("book")
public class BookController {

    private final Logger mLogger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getBookList(ModelMap map) {
        map.addAttribute("bookList",bookRepository.findAll());
        return "bookList";
    }

}

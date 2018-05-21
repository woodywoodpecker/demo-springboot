package com.py4j.demospringboot.application.controller;

import com.py4j.demospringboot.application.po.Book;
import com.py4j.demospringboot.application.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * @Author Warren
 * @CreateTime 19.May.2018
 * @Version V1.0
 */
@Controller
@RequestMapping("book")
public class BookController {

    private final Logger mLogger = LoggerFactory.getLogger(BookController.class);

    @Autowired()
    private BookService bookService;

    @RequestMapping
    public String getBookList(ModelMap map) {
        map.addAttribute("bookList",bookService.findAll());
        return "bookList";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createBookForm(ModelMap map) {
        map.addAttribute("book", new Book());
        map.addAttribute("action", "create");
        return "bookForm";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createBookForm(@Valid @ModelAttribute Book book, BindingResult bindingResult , ModelMap map) {
        if (bindingResult.hasErrors()) {
            map.addAttribute("book", book);
            map.addAttribute("action", "create");
            return "bookForm";
        }

        bookService.save(book);
        return "redirect:/book";
    }

    @RequestMapping(value = "/delete/{bookId}", method = RequestMethod.GET)
    public String deleteBook (@PathVariable Long bookId) {
        bookService.deleteById(bookId);
        return "redirect:/book";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable Long id, ModelMap map) {
        /*
            bookRepository.findById(id).get();
            这个地方可能出坑，在前端的thymeleaf操作bean的value的时候，是调用bean的Getter/Setter方法完成的
         */
        map.addAttribute("book", bookService.findById(id));
        map.addAttribute("action", "update");
        return "bookForm";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String putBook(@Valid @ModelAttribute Book book,BindingResult bindingResult, ModelMap map) {
        if (bindingResult.hasErrors()) {
            map.addAttribute("book", book);
            map.addAttribute("action", "update");
            return "bookForm";
        }

        bookService.save(book);
        return "redirect:/book";
    }
}

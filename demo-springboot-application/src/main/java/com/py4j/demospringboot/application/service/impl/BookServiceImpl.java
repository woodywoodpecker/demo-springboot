package com.py4j.demospringboot.application.service.impl;

import com.py4j.demospringboot.application.po.Book;
import com.py4j.demospringboot.application.repository.BookRepository;
import com.py4j.demospringboot.application.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Warren
 * @CreateTime 21.May.2018
 * @Version V1.0
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteById(long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book findById(long id) {
        return bookRepository.findById(id).get();
    }
}

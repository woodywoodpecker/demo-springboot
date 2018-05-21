package com.py4j.demospringboot.application.service;

import com.py4j.demospringboot.application.po.Book;

public interface BookService {

    Iterable<Book> findAll();

    void save (Book book);

    void deleteById(long id);

    Book findById(long id);

}

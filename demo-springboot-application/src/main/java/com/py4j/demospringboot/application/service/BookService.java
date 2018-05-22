package com.py4j.demospringboot.application.service;

import com.py4j.demospringboot.application.po.Book;

public interface BookService {

    Iterable<Book> findAll();

    Book save (Book book);

    void deleteById(long id);

    Book findById(long id);

}

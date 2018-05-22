package com.py4j.demospringboot.application.service.impl;

import com.py4j.demospringboot.application.jms.BookContentJmsService;
import com.py4j.demospringboot.application.po.Book;
import com.py4j.demospringboot.application.repository.BookRepository;
import com.py4j.demospringboot.application.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Author Warren
 * @CreateTime 21.May.2018
 * @Version V1.0
 */
@Service
@CacheConfig(cacheNames = "books")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookContentJmsService mBookContentJmsService;

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    /**
     * 这个地方可能踩到个坑，方法调用完以后一定要返回被更新的po，
     * 因为cache会把这个po作为新的value放进缓存，如果是void，那么
     * 在后面的Cacheable就会拿到一个null出来。
     */
    @CachePut(key="#book.id")
    @Override
    public Book save(Book book) {
        bookRepository.save(book);
        mBookContentJmsService.prepareBookInventory(book);
        return book;
    }

    @CacheEvict(key="#id")
    @Override
    public void deleteById(long id) {
        bookRepository.deleteById(id);
    }

    @Cacheable(key="#id")
    @Override
    public Book findById(long id) {
        return bookRepository.findById(id).get();
    }
}

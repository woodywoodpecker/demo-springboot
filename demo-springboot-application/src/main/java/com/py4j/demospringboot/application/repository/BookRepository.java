package com.py4j.demospringboot.application.repository;

import com.py4j.demospringboot.application.po.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * @Author Warren
 * @CreateTime 19.May.2018
 * @Version V1.0
 */
public interface BookRepository extends CrudRepository<Book,Long> {

}

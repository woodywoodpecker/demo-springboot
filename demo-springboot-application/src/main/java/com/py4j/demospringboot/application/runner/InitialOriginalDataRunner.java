package com.py4j.demospringboot.application.runner;

import com.py4j.demospringboot.application.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Author Warren
 * @CreateTime 21.May.2018
 * @Version V1.0
 */
@Component
public class InitialOriginalDataRunner implements CommandLineRunner {

    @Autowired
    private BookService bookService;

    @Override
    public void run(String... args) throws Exception {
        //bookService.save(new Book("三国演义","罗贯中","描述了东汉末年乱世割据的故事"));
        //bookService.save(new Book("西游记","吴承恩","一段师徒四人西天取经，战胜妖魔鬼怪的故事"));
        //bookService.save(new Book("水浒传","施耐庵","宋朝的一群梁山好汉的故事，其实就是一群土匪"));
    }

}

package com.py4j.demospringboot.application.jms;

import com.py4j.demospringboot.application.po.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Author Warren
 * @CreateTime 22.May.2018
 * @Version V1.0
 */
@Component
public class Receiver {

    private final Logger mLogger = LoggerFactory.getLogger(Receiver.class);

    @JmsListener(destination = "bookContent" , containerFactory = "bookFactory")
    public void toNoticeBookFactory(Book book) {
        mLogger.info("[Receiver] [toNoticeBookFactory] => Received  <{}> , notice factory to modify",book);
    }

}

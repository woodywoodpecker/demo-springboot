package com.py4j.demospringboot.application.schedual;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author Warren
 * @CreateTime 21.May.2018
 * @Version V1.0
 */

@Component
public class QueueInfoJob {

    public final static long ONE_Minute =  60 * 1000;

    private final Logger mLogger = LoggerFactory.getLogger(this.getClass());

    private AtomicLong depth = new AtomicLong(0l);

    @Scheduled(fixedRate = ONE_Minute/4)
    public void printQueueDepth () {
        depth.set(depth.get()+1);
        mLogger.info("[QueueInfoJob] [printQueueDepth] => current queue depth is {}",depth.get());
    }

}

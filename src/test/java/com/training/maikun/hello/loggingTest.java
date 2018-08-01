package com.training.maikun.hello;

/**
 * @program: order
 * @Description: To test logging
 * @author: Mr.Cheng
 * @date: 2018/8/1 上午9:21
 */

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class loggingTest {
    private static Logger logger = LoggerFactory.getLogger(loggingTest.class);

    @Test
    public void testLogger(){
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
    }
}

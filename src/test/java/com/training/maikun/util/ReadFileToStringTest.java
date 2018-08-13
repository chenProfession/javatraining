package com.training.maikun.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * @program: order
 * @Description: test read file function
 * @author: Mr.Cheng
 * @date: 2018/8/12 下午5:54
 */
@Slf4j
public class ReadFileToStringTest {
    @Test
    public void testReadFileByPath() throws IOException {
        String result = ReadFileToString.LoadContentByPath(ReadFileToString.basicPath + "/json.txt");
        log.info(result);
        Assert.assertNotNull(result);
    }
}

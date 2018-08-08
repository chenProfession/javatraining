package com.training.maikun.util;

import java.io.*;

/**
 * @program: order
 * @Description: To read the file content to save into String
 * @author: Mr.Cheng
 * @date: 2018/8/9 上午2:57
 */
public class ReadFileToString {
    public static String LoadContentByPath(String path) throws IOException {
        InputStream is = new FileInputStream(path);
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        while ((line = in.readLine()) != null) {
            buffer.append(line);
        }
        return buffer.toString();
    }
}

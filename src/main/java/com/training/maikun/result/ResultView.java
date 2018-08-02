package com.training.maikun.result;


import lombok.Data;

/**
 * @program: order
 * @Description: To show the result of retrieving
 * @author: Mr.Cheng
 * @date: 2018/8/1 上午4:51
 */
@Data
public class ResultView<T> {

    /** code */
    private Integer code;

    /** message */
    private String msg;

    /** content of data */
    private T data;

}

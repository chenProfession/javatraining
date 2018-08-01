package com.training.maikun.result;


/**
 * @program: order
 * @Description: To show the result of retrieving
 * @author: Mr.Cheng
 * @date: 2018/8/1 上午4:51
 */

public class ResultView<T> {

    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体内容. */
    private T data;

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }
}

package com.training.maikun.result;

import org.springframework.stereotype.Service;

/**
 * @program: order
 * @Description: To implement Result Service
 * @author: Mr.Cheng
 * @date: 2018/8/8 上午1:15
 */
@Service
public class ResultServiceImpl implements ResultService {
    /**
     * @Description: to make the ResultView success
     * @Param: []
     * @return: com.training.maikun.result.ResultView
     * @Author: Mr.Cheng
     * @Date: 2018/8/3 下午5:31
     */
    @Override
    public ResultView getResultViewSuccess() {
        return null;
    }

    /**
     * @Description: to make the ResultView fail
     * @Param: []
     * @return: com.training.maikun.result.ResultView
     * @Author: Mr.Cheng
     * @Date: 2018/8/4 上午12:58
     */
    @Override
    public ResultView getResultViewFail() {
        return null;
    }
}

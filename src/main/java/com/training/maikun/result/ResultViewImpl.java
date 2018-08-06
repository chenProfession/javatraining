package com.training.maikun.result;

import com.training.maikun.products.view.ProductView;

import java.util.List;

/**
 * @program: order
 * @Description: To implement the interface of ResultView Service
 * @author: Mr.Cheng
 * @date: 2018/8/3 下午5:30
 */
public class ResultViewImpl implements ResultService {

    /**
    * @Description: to implement the method of getting ResultView
    * @Param: []
    * @return: com.training.maikun.result.ResultView
    * @Author: Mr.Cheng
    * @Date: 2018/8/4 上午1:01
    */ 
    @Override
    public ResultView getResultViewSuccess(List<ProductView> productViewList) {
        return null;
    }

    /**
    * @Description: to implement the method of getting fial
    * @Param: []
    * @return: com.training.maikun.result.ResultView
    * @Author: Mr.Cheng
    * @Date: 2018/8/4 上午1:02
    */ 
    @Override
    public ResultView getResultViewFail() {
        return null;
    }
}

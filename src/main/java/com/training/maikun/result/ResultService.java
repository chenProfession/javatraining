package com.training.maikun.result;

import com.training.maikun.products.view.ProductView;

import java.util.List;

public interface ResultService {

    /**
    * @Description: to make the ResultView success
    * @Param: []
    * @return: com.training.maikun.result.ResultView
    * @Author: Mr.Cheng
    * @Date: 2018/8/3 下午5:31
    */ 
    ResultView getResultViewSuccess(List<ProductView> productViewList);

    /**
    * @Description: to make the ResultView fail
    * @Param: []
    * @return: com.training.maikun.result.ResultView
    * @Author: Mr.Cheng
    * @Date: 2018/8/4 上午12:58
    */ 
    ResultView getResultViewFail();
}

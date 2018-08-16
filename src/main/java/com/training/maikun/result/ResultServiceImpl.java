package com.training.maikun.result;

import com.training.maikun.enums.ResultEnum;
import com.training.maikun.products.ProductCategory;
import com.training.maikun.products.ProductService;
import com.training.maikun.products.view.ProductInfoView;
import com.training.maikun.products.view.ProductView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @program: order
 * @Description: To implement Result Service
 * @author: Mr.Cheng
 * @date: 2018/8/8 上午1:15
 */
@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ProductService productService;
    /**
     * @Description: to make the ResultView success
     * @Param: []
     * @return: com.training.maikun.result.ResultView
     * @Author: Mr.Cheng
     * @Date: 2018/8/3 下午5:31
     */
    @Override
    public ResultView getResultViewSuccess() {
        /** retrieve the product info and product category **/
        List<ProductCategory> productCategoryList = productService.getProductCategory();

        /** the key of the map is category id and the value of the map is the list of product **/
        Map<Integer,Object> productInfoViewMapByCategory = productService.getProductInfoViewMapByCategory();

        /** make the Product View data **/
        List<ProductView> productViewList = new ArrayList();
        Iterator<ProductCategory> iteratorCategory = productCategoryList.iterator();
        while (iteratorCategory.hasNext()) {
            ProductCategory item = iteratorCategory.next();
            ProductView productView = new ProductView();
            productView.setCategoryName(item.getProductCategoryName());
            productView.setCategoryType(item.getProductCategoryType());
            productView.setProductInfoViewList((List<ProductInfoView>) productInfoViewMapByCategory.get(item.getCategoryId()));
            productViewList.add(productView);
        }

        /** make the result view **/
        ResultView resultView = new ResultView();
        resultView.setCode(0);
        resultView.setMsg(ResultEnum.SUCCESS.getMessage());
        resultView.setData(productViewList);

        return resultView;
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

        /** make the result view **/
        ResultView resultView = new ResultView();
        resultView.setCode(10);
        resultView.setMsg(ResultEnum.PRODUCT_NOT_EXIST.getMessage());
        resultView.setData(ResultEnum.PARAM_ERROR.getMessage());

        return resultView;
    }
}

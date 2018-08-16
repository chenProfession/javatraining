package com.training.maikun.products;

import com.training.maikun.enums.ResultEnum;
import com.training.maikun.products.view.ProductInfoView;
import com.training.maikun.products.view.ProductView;
import com.training.maikun.result.ResultView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @program: order
 * @Description: implement product service
 * @author: Mr.Cheng
 * @date: 2018/8/2 下午3:53
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    /**
    * @Description: implement the function of findupall
    * @Param: []
    * @return: java.util.List<com.training.maikun.products.ProductInfo>
    * @Author: Mr.Cheng
    * @Date: 2018/8/2 下午3:54
    */ 
    @Override
    public List<ProductInfo> findUpAll() {
        return productRepository.findAll();
    }

    /**
     * @Description: To get top ten products by ID
     * @Param: []
     * @return: int
     * @Author: Mr.Cheng
     * @Date: 2018/8/7 上午1:29
     */
    @Override
    public int getTopTenProducts() {
        return (int)productRepository.count();
    }

    /**
     * @param productInfoViewList
     * @Description: To get the View of product
     * @Param: []
     * @return: com.training.maikun.products.view.ProductView
     * @Author: Mr.Cheng
     * @Date: 2018/8/7 上午1:51
     */
    @Override
    public List<ProductView> getProductViewList(List<ProductInfoView> productInfoViewList) {
        return null;
    }

    /**
     * @Description: To get the View of product Information by category
     * @Param: []
     * @return: java.util.List<com.training.maikun.products.view.ProductInfoView>
     * @Author: Mr.Cheng
     * @Date: 2018/8/7 上午2:00
     */
    @Override
    public Map<Integer,Object> getProductInfoViewMapByCategory() {
        Map<Integer,Object> productInfoViewMapByCategory = new HashMap<>();
        List<ProductCategory> productCategoryList = productCategoryRepository.findAll();

        Iterator<ProductCategory> iteratorCategory = productCategoryList.iterator();
        while (iteratorCategory.hasNext()) {

            ProductCategory item = iteratorCategory.next();
            List<ProductInfoView> productInfoViewList = new ArrayList<>();
            List<ProductInfo> productInfoList = productRepository.findByCategoryType(item.getProductCategoryType());

            Iterator<ProductInfo> iteratorProductInfo = productInfoList.iterator();
            while(iteratorProductInfo.hasNext()){
                ProductInfo itemProductInfo = iteratorProductInfo.next();
                ProductInfoView productInfoView = new ProductInfoView();
                productInfoView.setProductId(itemProductInfo.getProductId());
                productInfoView.setProductName(itemProductInfo.getProductName());
                productInfoView.setProductPrice(itemProductInfo.getProductPrice());
                productInfoView.setProductIcon(itemProductInfo.getProductIcon());
                productInfoView.setProductDescription(itemProductInfo.getProductDescription());
                productInfoViewList.add(productInfoView);
            }
            productInfoViewMapByCategory.put(item.getCategoryId(),productInfoViewList);
        }
        return productInfoViewMapByCategory;
    }

    /**
     * @param productInfo
     * @Description: To insert the details of product
     * @Param: [productInfo]
     * @return: com.training.maikun.result.ResultView
     * @Author: Mr.Cheng
     * @Date: 2018/8/7 下午4:11
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultView insertProductInfo(ProductInfo productInfo) {
        productInfo = productRepository.findByProductId(productInfo.getProductId());
        ResultView resultView = new ResultView();
        if(productInfo == null){
            productRepository.saveAndFlush(productInfo);
            resultView.setCode(27);
            resultView.setMsg(ResultEnum.PRODUCT_CREATE_SUCCESS.getMessage());
            resultView.setData("you have added a product !");
        }else {
            resultView.setCode(28);
            resultView.setMsg(ResultEnum.PRODUCT_CREATE_ERROR.getMessage());
            resultView.setData("cannot added a product !");
        }

        return resultView;
    }

    /**
     * @param productId
     * @Description:
     * @Param: [productId]
     * @return: com.training.maikun.products.ProductInfo
     * @Author: Mr.Cheng
     * @Date: 2018/8/8 上午10:08
     */
    @Override
    public ProductInfo getProductInfo(String productId) {
        return productRepository.findByProductId(productId);
    }

    /**
     * @Description: To get the category of the prodcut
     * @Param: []
     * @return: com.training.maikun.products.ProductCategory
     * @Author: Mr.Cheng
     * @Date: 2018/8/8 下午8:12
     */
    @Override
    public List<ProductCategory> getProductCategory() {
        return productCategoryRepository.findAll();
    }

}

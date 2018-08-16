package com.training.maikun.products;

import com.training.maikun.util.DataMaker;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
//@DataJpaTest
@Slf4j
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    //@Autowired
    //private TestEntityManager entityManager;

    @Test
    public void testFindByCategoryType() throws Exception {
        List<ProductInfo> productInfoList = productRepository.findByCategoryType(11);
        System.out.println(productInfoList);
        Assert.assertNotNull(productInfoList);
    }

    @Test
    public void testFindByProductId() throws Exception {
        //this.entityManager.persist(DataMaker.makeProductInfo());
        ProductInfo productInfo = productRepository.findByProductId("test-first");
        assertThat(productInfo.getProductId()).isEqualTo("test-first");
    }

    @Test
    public void testSaveProductInfo() throws Exception {
        ProductInfo productInfo = DataMaker.makeProductInfo();
        Assert.assertNotNull(productRepository.saveAndFlush(productInfo));
    }

    @Test
    public void testSaveProductCategory() throws Exception {
        ProductCategory productCategory = DataMaker.makeProductCategoryList().get(1);
        Assert.assertNotNull(productCategoryRepository.saveAndFlush(productCategory));
    }

}
package com.imooc.testjava.dataobject.mapper;

import com.imooc.testjava.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //测试的时候去除webSocket
public class ProductCategoryMapperTest {
    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    public void insertByMap() {
        Map<String , Object> map = new HashMap<>();
        map.put("categoryName", "男装分类2");
        map.put("category_type", 65);
        int result = mapper.insertByMapper(map);
        Assert.assertEquals(1, result);
    }

    @Test
    public void insertByObject() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("女生分类222");
        productCategory.setCategoryType(34);
        int result = mapper.insertByObject(productCategory);
        Assert.assertEquals(1, result);
    }

    @Test
    public void findByCategoryType() {
        ProductCategory productCategory = mapper.findByCategoryType(65);
        Assert.assertNotNull(productCategory);
    }
    @Test
    public void findByCategoryName() {
        List<ProductCategory> productCategory = mapper.findByCategoryName("女生分类222");
        Assert.assertNotEquals(0, productCategory.size());
    }

    @Test
    public void updateByCategoryType() {
        int result = mapper.updateByCategoryType("女生分类55", 34);
        Assert.assertEquals(1, result);
    }

    @Test
    public void updateByObject() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("女生分类007");
        productCategory.setCategoryType(34);
        int result = mapper.updateByObject(productCategory);
        Assert.assertEquals(1, result);
    }

    @Test
    public void deleteByCategoryType() {
        int result = mapper.deleteByCategoryType(34);
        Assert.assertEquals(1, result);
    }

    @Test
    public void selectByCategoryType() {
        ProductCategory productCategory = mapper.selectByCategoryType(65);
        Assert.assertNotNull(productCategory);
    }
}
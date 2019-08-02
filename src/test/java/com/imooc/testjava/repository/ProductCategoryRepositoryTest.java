package com.imooc.testjava.repository;

import com.imooc.testjava.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(2, 3, 4);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, result.size());
    }

    @Test
    public void findOneTest() {
        ProductCategory productCategory = repository.getOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    @Transactional //事务 测试使用事务完全回滚
    public void saveTest() {
//        ProductCategory productCategory = new ProductCategory();
//        productCategory.setCategoryName("女生最爱");
//        productCategory.setCategoryType(21);
//        repository.save(productCategory);
        ProductCategory productCategory = new ProductCategory
                ("女生最爱2", 6);
        ProductCategory result = repository.save(productCategory);
//        Assert.assertNotNull(result);
        Assert.assertNotEquals(null, result);
    }

    @Test
    public void updateTest(){
        ProductCategory productCategory = repository.getOne(27);
        productCategory.setCategoryName("男生最爱22");
        productCategory.setCategoryType(42);
        repository.save(productCategory);
    }
}
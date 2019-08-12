package com.imooc.testjava.service.impl;

import com.imooc.testjava.dataobject.ProductCategory;
import com.imooc.testjava.dataobject.dao.ProductCategoryDao;
import com.imooc.testjava.repository.ProductCategoryRepository;
import com.imooc.testjava.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryRepository repository;
    @Override
    public ProductCategory getOne(Integer categoryId) {
        return repository.getOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
//        categoryDao.insertByObject()
        return repository.save(productCategory);
    }
}

package com.imooc.testjava.controller;

import com.imooc.testjava.dataobject.ProductCategory;
import com.imooc.testjava.dataobject.ProductInfo;
import com.imooc.testjava.enums.ProductStatusEnum;
import com.imooc.testjava.exception.SellException;
import com.imooc.testjava.from.ProductForm;
import com.imooc.testjava.service.CategoryService;
import com.imooc.testjava.util.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * 卖家类目
 */
@Controller
@Slf4j
@RequestMapping("/seller/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 类目列表
     * @param map
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map){
        List<ProductCategory> productCategoryList = categoryService.findAll();
        map.put("productCategoryList", productCategoryList);
        return new ModelAndView("category/list", map);
    }

    /**
     * 展示
     * @param categoryId
     * @param map
     * @return
     */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId", required = false) Integer categoryId,
                              Map<String, Object> map) {
        if (categoryId != null) {
            ProductCategory productCategory = categoryService.getOne(categoryId);
            map.put("productCategory", productCategory);
        }

        return new ModelAndView("category/index", map);
    }

    @PostMapping("/save")
    public ModelAndView save(@RequestParam(value = "categoryId", required = false) Integer categoryId,
                             @RequestParam(value = "categoryName") String categoryName,
                             @RequestParam(value = "categoryType") Integer categoryType,
                             Map<String, Object> map) {

        ProductCategory category = new ProductCategory();
        if (!StringUtils.isEmpty(categoryId)) {
            category = categoryService.getOne(categoryId);
        }
        category.setCategoryName(categoryName);
        category.setCategoryType(categoryType);
        try {
             categoryService.save(category);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/category/list");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/sell/seller/category/list");
        return new ModelAndView("common/success", map);
    }
}

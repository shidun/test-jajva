package com.imooc.testjava.controller;

import com.imooc.testjava.VO.ProductInfoVO;
import com.imooc.testjava.VO.ProductVO;
import com.imooc.testjava.VO.ResultVO;
import com.imooc.testjava.dataobject.ProductCategory;
import com.imooc.testjava.dataobject.ProductInfo;
import com.imooc.testjava.service.CategoryService;
import com.imooc.testjava.service.ProductService;
import com.imooc.testjava.util.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 */

@RestController //返回json
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/test")
    public ResultVO test() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(10);
        return resultVO;
    }

    @GetMapping("/list")
//    @Cacheable(cacheNames = "product", key = "123")
    @Cacheable(cacheNames = "product", key = "#sellerId", condition = "#sellerId.length() > 3", unless = "#result.getCode() != 0")
    public ResultVO getList(@RequestParam("sellerId") String sellerId) {
//    public ResultVO getList() {
        //查询所有的上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //传统方法获取商品的类目Id
//        List<Integer> categoryTypeList = new ArrayList<>();
//        for (ProductInfo productInfo : productInfoList) {
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        //精简方法（java8 lambda）
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType()).collect(Collectors.toList());
        //查询类目(一次性查询)
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        //数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

//        ResultVO resultVO = new ResultVO();
//        ProductVO productVO = new ProductVO();
//        ProductInfoVO productInfoVO = new ProductInfoVO();
//        productVO.setProductInfoVOList(Arrays.asList(productInfoVO));
//        resultVO.setData(Arrays.asList(productVO));

//        resultVO.setCode(0);
//        resultVO.setMsg("成功");
//        resultVO.setData(productVOList);
        return ResultVOUtil.success(productVOList);
    }
}

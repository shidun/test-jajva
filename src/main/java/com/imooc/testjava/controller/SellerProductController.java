package com.imooc.testjava.controller;

import com.imooc.testjava.dataobject.ProductInfo;
import com.imooc.testjava.service.ProductService;
import com.lly835.bestpay.rest.type.Get;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/seller/product")
public class SellerProductController {

    @Autowired
    private ProductService productService;
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String , Object> map) {
        PageRequest request = new PageRequest(page - 1, size);
        Page<ProductInfo> productInfoPage = productService.findAll(request);
        map.put("currentPage", page);
        map.put("size", size);
        map.put("productInfoPage", productInfoPage);
        return new ModelAndView("product/list", map);
    }

    /**
     * 商品下架
     */
    @GetMapping("/off_sale")
    public ModelAndView down(@RequestParam("productId") String productId,
                             Map<String, Object> map) {
        ProductInfo productInfo = productService.getOne(productId);
        productService.downProduct(productInfo);
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }
    /**
     * 商品上架
     */
    @GetMapping("/on_sale")
    public ModelAndView up(@RequestParam("productId") String productId,
                             Map<String, Object> map) {
        ProductInfo productInfo = productService.getOne(productId);
        productService.upProduct(productInfo);
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }
}

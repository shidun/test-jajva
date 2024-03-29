package com.imooc.testjava.controller;

import com.imooc.testjava.dataobject.ProductCategory;
import com.imooc.testjava.dataobject.ProductInfo;
import com.imooc.testjava.enums.ProductStatusEnum;
import com.imooc.testjava.exception.SellException;
import com.imooc.testjava.from.ProductForm;
import com.imooc.testjava.service.CategoryService;
import com.imooc.testjava.service.ProductService;
import com.imooc.testjava.util.KeyUtil;
import com.imooc.testjava.service.WebSocket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/seller/product")
public class SellerProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private WebSocket webSocket;

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

    @GetMapping("/test")
    public ModelAndView test(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String , Object> map) {

        map.put("msg", "取消成功");
        map.put("url", "/sell/seller/order/list");
        webSocket.sendMessage("有新订单");
        return new ModelAndView("common/success", map);
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

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId", required = false) String productId,
                              Map<String, Object> map) {
        if (!StringUtils.isEmpty(productId)) {
            ProductInfo productInfo = productService.getOne(productId);
            map.put("productInfo", productInfo);
        }
        //查询所有的类目
        List<ProductCategory> categoryServices = categoryService.findAll();
        map.put("categoryServices", categoryServices);
        return new ModelAndView("product/index", map);
    }

    /**
     * 保存和更新
     * @param form
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping("/save")
//    @CachePut(cacheNames = "product", key = "123") //更新redis
//    @CacheEvict(cacheNames = "product", key = "123") //删除redis
    public ModelAndView save(@Valid ProductForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);
        }
        ProductInfo productInfo = new ProductInfo();

        if (!StringUtils.isEmpty(form.getProductId())) {
            productInfo = productService.getOne(form.getProductId());
        } else {
            form.setProductId(KeyUtil.genUniqueKey());
            productInfo.setProductStatus(ProductStatusEnum.Down.getCode());
            productInfo.setCreateTime(new Date());
        }
        BeanUtils.copyProperties(form, productInfo);
//        productInfo.setCreateTime(new Date());
        try {
            ProductInfo result = productService.save(productInfo);
        } catch (SellException e) {
            log.error("【卖家端取消订单】 查询订单为空");
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }
}

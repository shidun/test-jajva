package com.imooc.testjava.controller;

import com.imooc.testjava.service.SeckillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skill")
@Slf4j
public class SeckillController {
    @Autowired
    private SeckillService seckillService;

    /**
     * 查询秒杀活动特价商品的信息
     * @param productId
     * @return
     */
    @GetMapping("/query/{productId}")
    public String query(@PathVariable String productId) {
        return seckillService.querySeckillProductInfo(productId);
    }

    /**
     * 秒杀，没有抢到提示“没有抢到哦” 抢到返回剩余的库存量
     */
    @GetMapping("/order/{productId}")
    public String skill(@PathVariable String productId) {
        log.info("skill request,productId:" + productId);
        seckillService.orderProductMockDiffUser(productId);
        return seckillService.querySeckillProductInfo(productId);
    }
}

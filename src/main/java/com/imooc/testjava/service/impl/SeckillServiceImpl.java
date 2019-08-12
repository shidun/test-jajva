package com.imooc.testjava.service.impl;

import com.imooc.testjava.exception.SellException;
import com.imooc.testjava.service.RedisLock;
import com.imooc.testjava.service.SeckillService;
import com.imooc.testjava.util.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.TIMEOUT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class SeckillServiceImpl implements SeckillService {
    private static final int TIMEOUT = 10 * 1000; //redis锁超时时间
    @Autowired
    private RedisLock redisLock;

//    public String aaa = "123;";
    static Map<String, Integer> products;
    static Map<String, Integer> stock;
    static Map<String, String > orders;
    static
    {
        products = new HashMap<>();
        stock = new HashMap<>();
        orders = new HashMap<>();
        products.put("123456", 10000);
        stock.put("123456", 10000);
    }

    private String queryMap(String productId) {
        return "七夕活动，限量版祥瑞特价，限量份" +
                products.get(productId)
                + "还剩：" + stock.get(productId) + "份"
                + "该商品成功下单的数目："
                + orders.size() + "次";
    }

    public String querySeckillProductInfo(String productId) {
//        String  aa =this.aaa;
        return this.queryMap(productId);
    }

    public void orderProductMockDiffUser(String productId) {
        //加锁
        long time = System.currentTimeMillis() + TIMEOUT;
        if (!redisLock.lock(productId, String.valueOf(time))) {
            log.error("锁被其他拿走了  请继续重试!");
            throw new SellException(101, "锁被其他拿走了  请继续重试!");
        }

        //查询该商品库存，为0则活动结束
        int stockNum = stock.get(productId);
        if (stockNum <= 0) {
            throw new SellException(100, "活动结束");
        } else {
            //下单
            orders.put(KeyUtil.genUniqueKey(), productId);
            //减库存
            stockNum = stockNum - 1;
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            stock.put(productId, stockNum);
        }

        //解锁
        redisLock.unlock(productId, String.valueOf(time));
    }
}

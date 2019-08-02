package com.imooc.testjava.repository;

import com.imooc.testjava.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("12345");
        orderDetail.setOrderId("22221");
        orderDetail.setProductName("7.31商品");
        orderDetail.setProductPrice(new BigDecimal(11));
        orderDetail.setProductQuantity(11);
        orderDetail.setProductId("12345");
        orderDetail.setProductIcon("http://xxxxx");
        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderIdTest() {
        List<OrderDetail> orderDetailList = repository.findByOrderId("22221");
        Assert.assertNotEquals(0, orderDetailList.size());
    }
}
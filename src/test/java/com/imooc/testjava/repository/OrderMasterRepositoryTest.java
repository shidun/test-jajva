package com.imooc.testjava.repository;

import com.imooc.testjava.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("22221");
        orderMaster.setBuyerName("shidun");
        orderMaster.setBuyerOpenid("oybUM6J4tdDskJihTCMO4TfB8ss4");
        orderMaster.setBuyerPhone("12345611");
        orderMaster.setBuyerAdress("杭州市");
        orderMaster.setOrderAmout(new BigDecimal(12));
        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenidTest() {
        //PageRequest(int page, int size)
        PageRequest request = new PageRequest(0, 2);
        Page<OrderMaster> orderMasterPage = repository.findByBuyerOpenid("oybUM6J4tdDskJihTCMO4TfB8ss4", request);
        Assert.assertNotEquals(0, orderMasterPage.getTotalElements());
    }
}
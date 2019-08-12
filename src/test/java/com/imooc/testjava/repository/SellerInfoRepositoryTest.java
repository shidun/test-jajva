package com.imooc.testjava.repository;

import com.imooc.testjava.dataobject.SellerInfo;
import com.imooc.testjava.util.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRepositoryTest {
    @Autowired
    private SellerInfoRepository repository;

    @Test
    public void save() {
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId(KeyUtil.genUniqueKey());
        sellerInfo.setUsername("ssss");
        sellerInfo.setPassword("12345");
        sellerInfo.setOpenid("sdasda21");
        SellerInfo result = repository.save(sellerInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOpenid(){
        SellerInfo sellerInfo = repository.findByOpenid("sdasda21");
        Assert.assertEquals("sdasda21", sellerInfo.getOpenid());
    }
}
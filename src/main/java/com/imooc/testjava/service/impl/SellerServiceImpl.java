package com.imooc.testjava.service.impl;

import com.imooc.testjava.dataobject.SellerInfo;
import com.imooc.testjava.repository.SellerInfoRepository;
import com.imooc.testjava.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}

package com.imooc.testjava.service;

import com.imooc.testjava.dataobject.SellerInfo;

public interface SellerService {

    SellerInfo findSellerInfoByOpenid(String openid);
}

package com.imooc.testjava.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    private String mpAppId;
    private String mpAppSercre;
    private String mchId;
    private String mchKey;
    /**
     * 商户证书地址
     */
    private String keyPath;
    private String notifyUrl;
}
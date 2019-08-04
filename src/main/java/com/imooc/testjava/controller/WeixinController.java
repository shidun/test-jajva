package com.imooc.testjava.controller;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {
    @Autowired
    private WxMpService wxMpService;

    //使用第三方sdk
    @GetMapping("/authorize")
    public void authSdk(@RequestParam("returnUrl") String returnUrl) {
//        WxMpService wxMpService = new WxMpServiceImpl();
        String url = returnUrl;
        wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_USERINFO, null);

    }


    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code) {
        /**
         * 下面方法微信回调拿到code
         *  https://open.weixin.qq.com/connect/oauth2/authorize?
         *  appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&
         *  scope=SCOPE&state=STATE#wechat_redirect
         */
        log.info("进入微信auth...");
        log.info("code={}", code);

        /**
         * https://api.weixin.qq.com/sns/oauth2/access_token?
         * appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
         */
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

        RestTemplate restTemplate = new RestTemplate();
        /**
         * result:
         * {
         *     "access_token":"ACCESS_TOKEN",
         *     "expires_in":7200,
         *     "refresh_token":"REFRESH_TOKEN",
         *     "openid":"OPENID",
         *     "scope":"SCOPE"
         * }
         */
        restTemplate.getForObject(url, String.class);
    }
}

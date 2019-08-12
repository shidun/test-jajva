package com.imooc.testjava.controller;

import com.imooc.testjava.config.ProjectUrlConfig;
import com.imooc.testjava.enums.ResultEnum;
import com.imooc.testjava.exception.SellException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;

//@RestController  //只会返回json 无法跳转
@Controller
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {
    @Autowired
    private WxMpService wxMpService;
    @Autowired
    private WxMpService wxOpenService;
    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    //使用第三方sdk
    @GetMapping("/authorize")
    public String authSdk(@RequestParam("returnUrl") String returnUrl) {
//        WxMpService wxMpService = new WxMpServiceImpl();
        String url = projectUrlConfig.getWechatMpAuthorize() + "/sell/weixin/auth";
        String result =wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_USERINFO, URLEncoder.encode(returnUrl));
        log.info("【微信网页授权获取code】，result={}", result);
        return "redirect:" + result;
    }

    @GetMapping("/auth")
    public String auth(@RequestParam("code") String code,
                     @RequestParam("state") String returnUrl) {
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

        //code去获取token
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            log.error("【微信网页授权】{}，", e);
            throw new SellException(ResultEnum.WX_ERROR.getCode(), e.getError().getErrorMsg());
        }
        String openid  = wxMpOAuth2AccessToken.getOpenId();
        return "redirect" + returnUrl + "?openid=" + openid;
    }

    /**
     * 微信开发平台第三方登录相关
     */
    @GetMapping("/qrAuthorize")
    public String qrAuthorize(@RequestParam("returnUrl") String returnUrl) {
        String url = projectUrlConfig.getWechatOpenAuthorize() + "/sell/weixin/auth";
        String redirect = wxOpenService.buildQrConnectUrl(url, WxConsts.QrConnectScope.SNSAPI_LOGIN, URLEncoder.encode(returnUrl));
        return "redirect:" + redirect;
    }

    @GetMapping("/qrUserInfo")
    public String qrUserInfo(@RequestParam("code") String code,
                             @RequestParam("state") String returnUrl) {
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxOpenService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            log.error("【微信网页授权2】{}，", e);
            throw new SellException(ResultEnum.WX_ERROR.getCode(), e.getError().getErrorMsg());
        }
        String openid = wxMpOAuth2AccessToken.getOpenId();
        return "redirect" + returnUrl + "?openid=" + openid;
    }
}

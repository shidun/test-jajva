package com.imooc.testjava.aspect;

import com.imooc.testjava.constant.CookieConstant;
import com.imooc.testjava.constant.RedisConstant;
import com.imooc.testjava.exception.SellerAuthorizeException;
import com.imooc.testjava.util.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 卖家
 */
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 切controller.Seller开头的controller的所有方法 除了SellerUserController
     */
    @Pointcut("execution(public * com.imooc.testjava.controller.Seller*.*(..))" +
        "&& !execution(public * com.imooc.testjava.controller.SellerUserController.*(..))")
    public void verify() {
    }

    @Before("verify()")
    public void doVerify() {
        //获取request
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //查询cookie
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie == null) {
            log.info("【登陆校验】 cookie查不到token");
            throw new SellerAuthorizeException();
        }

        //去查redis
        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
        if (StringUtils.isEmpty(tokenValue)) {
            log.info("【登陆校验】 redis查不到token");
            throw new SellerAuthorizeException();
        }
    }
}

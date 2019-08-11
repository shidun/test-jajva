package com.imooc.testjava.handler;

import com.imooc.testjava.exception.SellerAuthorizeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class SellerExceptionHandler {

    //拦截登陆异常
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException() {
        Map<String , Object> map = new HashMap<>();
        map.put("msg", "退出成功");
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success", map);
//        return new ModelAndView("redirect:");
    }
}

package com.imooc.testjava.handler;

import com.imooc.testjava.VO.ResultVO;
import com.imooc.testjava.exception.ResponseBankException;
import com.imooc.testjava.exception.SellException;
import com.imooc.testjava.exception.SellerAuthorizeException;
import com.imooc.testjava.util.ResultVOUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class SellerExceptionHandler {

    //拦截登陆异常
    @ExceptionHandler(value = SellerAuthorizeException.class)
//    @ResponseStatus(HttpStatus.FORBIDDEN) //捕获该异常后 改变http的状态码
    public ModelAndView handlerAuthorizeException() {
        Map<String , Object> map = new HashMap<>();
        map.put("msg", "退出成功");
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success", map);
//        return new ModelAndView("redirect:");
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody  //和@ControllerAdvice组合成 restController
    public ResultVO handlerSellException(Exception e) {
        return ResultVOUtil.error(-1, e.getMessage(), null);
    }

    @ExceptionHandler(value = ResponseBankException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN) //捕获该异常后 改变http的状态码
    public void hanlderResponseBankException() {

    }
}

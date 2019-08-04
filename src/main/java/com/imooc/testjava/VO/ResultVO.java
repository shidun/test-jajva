package com.imooc.testjava.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Http请求返回的最外层对象
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL) //过滤空值
public class ResultVO<T> {
    //错误码
    private Integer code;
    private String msg = "";
    private T data;
}

package com.imooc.testjava.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * Http请求返回的最外层对象
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL) //过滤空值
public class ResultVO<T> implements Serializable {
    private static final long serialVersionUID = 12L;
    //错误码
    private Integer code;
    private String msg = "";
    private T data;
}

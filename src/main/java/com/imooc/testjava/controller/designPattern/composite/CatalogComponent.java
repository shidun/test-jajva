package com.imooc.testjava.controller.designPattern.composite;

/**
 * @author : ShiDun
 * @date : 2019/12/18
 */
public abstract class CatalogComponent {
    public void add(CatalogComponent catalogComponent) {
        throw new UnsupportedOperationException("不支持添加");
    }
    public void remove(CatalogComponent catalogComponent) {
        throw new UnsupportedOperationException("不支持删除");
    }
    public String getName(CatalogComponent catalogComponent) {
        throw new UnsupportedOperationException("不支持获取名字");
    }
    public Integer getPrice(CatalogComponent catalogComponent) {
        throw new UnsupportedOperationException("不支持获取价格");
    }
    public void print() {
        throw new UnsupportedOperationException("不支持打印");
    }
}

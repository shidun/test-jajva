package com.imooc.testjava.controller.designPattern.composite;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ShiDun
 * @date : 2019/12/18
 */
@Data
public class CourseCatalog extends CatalogComponent {
    private final List<CatalogComponent> list = new ArrayList();
    private String name;
    private Integer level;

    public CourseCatalog(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void add(CatalogComponent catalogComponent) {
        list.add(catalogComponent);
    }

    @Override
    public String getName(CatalogComponent catalogComponent) {
        return this.name;
    }

    @Override
    public void remove(CatalogComponent catalogComponent) {
        list.remove(catalogComponent);
    }

    @Override
    public void print() {
        System.out.println(this.name);
        for (CatalogComponent catalogComponent : list) {
            for (int i = 0; i < level; i++) {
                System.out.print("  ");
            }
            catalogComponent.print();
        }
    }
}

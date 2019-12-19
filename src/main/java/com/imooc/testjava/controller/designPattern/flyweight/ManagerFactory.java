package com.imooc.testjava.controller.designPattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : ShiDun
 * @date : 2019/12/18
 */
public class ManagerFactory {
    private static final Map<String, Employee> managers = new HashMap<String, Employee>();

    public Employee getManager(String department) {
        Manager manager = (Manager) managers.get(department);
        if (manager == null) {
            System.out.print("创建部门:"+department);
            manager = new Manager(department);
            String content = department + "部门发表演讲....";
            System.out.println(content);
            manager.setReportContent(content);
            managers.put(department, manager);
        }
        return manager;
    }
}

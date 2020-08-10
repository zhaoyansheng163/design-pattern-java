package com.example.design.VistorPattern;

import java.util.Random;

/**
 * @author zhaoyansheng
 * @package com.example.design.VistorPattern
 * @date 2020/8/10
 * @description 描述
 */
// 员工基类
public abstract class Staff {

    public String name;
    public int kpi;// 员工KPI

    public Staff(String name) {
        this.name = name;
        kpi = new Random().nextInt(10);
    }
    // 核心方法，接受Visitor的访问
    public abstract void accept(Visitor visitor);
}
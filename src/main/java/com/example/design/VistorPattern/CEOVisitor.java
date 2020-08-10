package com.example.design.VistorPattern;

/**
 * @author zhaoyansheng
 * @package com.example.design.VistorPattern
 * @date 2020/8/10
 * @description 描述
 */
// CEO访问者
public class CEOVisitor implements Visitor {
    @Override
    public void visit(Engineer engineer) {
        System.out.println("工程师: " + engineer.name + ", KPI: " + engineer.kpi);
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("经理: " + manager.name + ", KPI: " + manager.kpi +
                ", 新产品数量: " + manager.getProducts());
    }
}
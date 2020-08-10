package com.example.design.VistorPattern;

/**
 * @author zhaoyansheng
 * @package com.example.design.VistorPattern
 * @date 2020/8/10
 * @description 描述
 */
public interface Visitor {

    // 访问工程师类型
    void visit(Engineer engineer);

    // 访问经理类型
    void visit(Manager manager);
}
package com.example.design.VistorPattern;

/**
 * @author zhaoyansheng
 * @package com.example.design.VistorPattern
 * @date 2020/8/10
 * @description 描述
 */
//参考：https://www.jianshu.com/p/1f1049d0a0f4
public class Client {

    public static void main(String[] args) {
        // 构建报表
        BusinessReport report = new BusinessReport();
        System.out.println("=========== CEO看报表 ===========");
        report.showReport(new CEOVisitor());
        System.out.println("=========== CTO看报表 ===========");
        report.showReport(new CTOVisitor());
    }
}
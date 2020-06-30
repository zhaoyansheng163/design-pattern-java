/**
 * @author zhaoyansheng
 * @package com.example.design.ChainofResponsibility
 * @date 2020/6/30
 * @description 描述
 */
package com.example.design.ChainofResponsibility;
//责任链模式  https://www.jianshu.com/p/9f7d9775bdda
//现实中，请假的OA申请，请假天数如果是半天到1天，可能直接主管批准即可；
//        如果是1到3天的假期，需要部门经理批准；
//        如果是3天到30天，则需要总经理审批；
//        大于30天，正常不会批准。
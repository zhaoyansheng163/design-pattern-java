package com.example.design.ChainofResponsibility;

//现实中，请假的OA申请，请假天数如果是半天到1天，可能直接主管批准即可；
//        如果是1到3天的假期，需要部门经理批准；
//        如果是3天到30天，则需要总经理审批；
//        大于30天，正常不会批准。
public class ResponsibilityTest {
    public static void main(String[] args) {
        LeaveRequest request = LeaveRequest.builder().leaveDays(10).name("小明").build();


        AbstractLeaveHandler directLeaderLeaveHandler = new DirectLeaderLeaveHandler("直接主管");
        DeptManagerLeaveHandler deptManagerLeaveHandler = new DeptManagerLeaveHandler("经理");
        GManagerLeaveHandler gManagerLeaveHandler = new GManagerLeaveHandler("总经理");

        directLeaderLeaveHandler.setNextHandler(deptManagerLeaveHandler);
        deptManagerLeaveHandler.setNextHandler(gManagerLeaveHandler);

        directLeaderLeaveHandler.handlerRequest(request);


    }
}

package com.example.design.Mediator;

public class SCPlane extends Plane {
    public void readyState(String state) {
        //如果跑道闲置，则调用此方法，待起飞
        System.out.println(state + "，请川航好起飞准备");
    }

    public void flyState(String state, Dispatcher dispatcher) {
        //通过传入指令，准备起飞或起飞
        System.out.println("川航已离地，"+state);
        //通过中介者通知其他飞机使用跑道
        dispatcher.SCPlaneFly(state);
    }
}


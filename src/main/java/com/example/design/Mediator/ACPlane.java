package com.example.design.Mediator;

public class ACPlane extends Plane {
    public void readyState(String state) {
        System.out.println(state + "，请国航做好起飞准备");
    }

    public void flyState(String state, Dispatcher dispatcher) {
        System.out.println("国航已离地，"+state);
        dispatcher.ACPlaneFly(state);
    }
}

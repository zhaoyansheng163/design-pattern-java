package com.example.design.Mediator;

public class SZPlane extends Plane {
    public void readyState(String state) {
        System.out.println(state + "，请深航做好起飞准备");
    }

    public void flyState(String state, Dispatcher dispatcher) {
        System.out.println("深航已离地，"+state);
        dispatcher.SZPlaneFly(state);
    }
}


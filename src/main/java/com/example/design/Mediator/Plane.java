package com.example.design.Mediator;

public abstract class Plane {
    //跑道为闲置状态时，使飞机进入待飞状态
    public abstract void readyState(String state);
    //飞机起飞
    public abstract void flyState(String state, Dispatcher dispatcher);
}

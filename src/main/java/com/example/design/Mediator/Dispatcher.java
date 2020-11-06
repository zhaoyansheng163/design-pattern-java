package com.example.design.Mediator;

public abstract class Dispatcher {
    //保留所有飞机的引用是为了当接收指令时可以唤醒其他飞机的操作
    SCPlane sc;
    SZPlane sz;
    ACPlane ac;

    public Dispatcher(SCPlane sc,SZPlane sz,ACPlane ac){
        super();
        this.ac = ac;
        this.sc = sc;
        this.sz = sz;
    }

    public abstract void SCPlaneFly(String state);
    public abstract void SZPlaneFly(String state);
    public abstract void ACPlaneFly(String state);
}


package com.example.design.Mediator;

public class AirDispatcher extends Dispatcher {

    public AirDispatcher(SCPlane sc, SZPlane sz, ACPlane ac) {
        super(sc, sz, ac);
    }

    public void SCPlaneFly(String state) {//川航起飞后，使其他飞机进入待飞状态
        sz.readyState(state);//调用深航待飞方法
    }

    public void SZPlaneFly(String state) {
        ac.readyState(state);
    }

    public void ACPlaneFly(String state) {
        sz.readyState(state);
    }
}


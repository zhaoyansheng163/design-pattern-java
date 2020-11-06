package com.example.design.Mediator;

public class mediatorTest {
    public static void main(String[] args) {
        SCPlane sc = new SCPlane();
        SZPlane sz = new SZPlane();
        ACPlane ac = new ACPlane();

        AirDispatcher airDispatcher = new AirDispatcher(sc,sz,ac);

        sc.flyState("跑道已空出",airDispatcher);
        System.out.println("*********fly分割线*********");
        sz.flyState("跑道已空出",airDispatcher);
    }
}

package com.example.design.ProxyPattern;

public class ProxyTest {
    public static void main(String[] args) {
        AbstractObject proxy = new ProxyObject(new RealObject());
        proxy.operation();
    }
}

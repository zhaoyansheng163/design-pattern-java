package com.example.design.ObserverPattern;

/**
 * 观察者超类
 */
public interface Observer {

    public void update(float temp, float humidity, float pressure);
}

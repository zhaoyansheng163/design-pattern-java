package com.example.design.observor3;

import java.util.ArrayList;
import java.util.List;
/*
 * 天气预报核心类WeatherData：
 * 1）包含最新的天气信息
 * 2）观察者：List集合
 * 3）当数据有更新时，通知所有的接入方看到最新的信息
 * 使用观察者模式的好处：新增或移除一个接入方，不需要修改被观察方（Subject及WeatherData）
 */

interface Observer{  //角色1：观察者接口，由观察者来实现
    //接口方法参数为气象信息
    public void update(float temperature,float pressure,float humidity);
}

interface Subject{  //角色2：被观察者接口，由WeatherData类实现
    //管理观察者
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);

    //通知观察者
    public void notifyObservers();
}

class WeatherData implements Subject{  //角色3：具体被观察者——被观察者接口的实现类
    private float temperature;
    private float pressure;
    private float humidity;
    private List<Observer> observers;  //聚合，关键

    public WeatherData() {  //构造方法
        observers=new ArrayList<Observer>();
    }

    public void publishWetherData(float temperature,float pressure,float humidity) {  //数据更新方法
        this.temperature=temperature;
        this.pressure=pressure;
        this.humidity=humidity;
        notifyObservers();  //调用接口方法，将最新信息推送给接入方CurrentCondition
    }

    //以下3个是接口方法
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    @Override
    public void removeObserver(Observer observer) {
        if(observers.contains(observer)) {
            observers.remove(observer);
        }
    }
    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update(temperature, pressure, humidity);
        }
    }
}
class CurrentCondition implements Observer{ //角色4：具体观察者（现状）——观察者或接入方——观察者接口实现
    private float temperature; //温度
    private float pressure; //气压
    private float humidity; //湿度

    @Override
    public void update(float temperature,float pressure,float humidity) {  //接口方法
        this.temperature=temperature;
        this.pressure=pressure;
        this.humidity=humidity;
        display(); //显示
    }
    public void display() {
        System.out.println("");
        System.out.println("=====观察者观察到的气象数据=====");
        System.out.println("*******Today mTemperatuer："+temperature+"************");
        System.out.println("*******Today mPressure："+pressure+"************");
        System.out.println("*******Today mHumidity："+humidity+"************");
    }
}
class BaiduSite implements Observer{   //与CurrentCondition平行
    private float temperature;
    private float pressure;
    private float humidity;

    @Override
    public void update(float temperature,float pressure,float humidity) {
        this.temperature=temperature;
        this.pressure=pressure;
        this.humidity=humidity;
        display();
    }

    public void display() {
        System.out.println();
        System.out.println("=====百度网站观察到的气象数据=====");
        System.out.println("*******百度气温："+temperature+"************");
        System.out.println("*******百度气压："+pressure+"************");
        System.out.println("*******百度湿度："+humidity+"************");
    }
}

public class Test {  //客户者
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();  //创建被观察者

        //创建2个具体观察者
        CurrentCondition currentCondition = new CurrentCondition();
        BaiduSite baiduSite = new BaiduSite();

        //注册观察者
        weatherData.registerObserver(currentCondition);
        weatherData.registerObserver(baiduSite);
        //weatherData.removeObserver(baiduSite);

        //测试
        System.out.println("我（被观察者）准备发布气象数据，请各位观察...");
        weatherData.publishWetherData(10f, 100f,30.3f);
    }
}
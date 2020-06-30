package com.example.design.ObserverPattern;

/**
 * 显示当前天气的仪器 - 观察者的具体类 在LED上显示
 */
public class NowConditionDisplayLed implements Observer {
    private float temperature;
    private float humidity;
    private WeatherData weatherData;

    public NowConditionDisplayLed(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("[LED display] 当前温度:" + temperature + " 当前湿度: " + humidity);
    }
}
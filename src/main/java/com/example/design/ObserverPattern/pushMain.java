package com.example.design.ObserverPattern;

public class pushMain {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        NowConditionDisplay nowConditionDisplay = new NowConditionDisplay(weatherData);
        //NowConditionDisplayLed nowConditionDisplayled = new NowConditionDisplayLed(weatherData);   //追加观察者

        weatherData.setMeasurements(20, 10, 29.2f);
    }
}

package com.example.design.singleton;

/**
 * @author zhaoyansheng
 * @package com.example.design.singleton
 * @date 2020/6/29
 * @description 描述
 */
//饿汉式单例,启动时加载  线程安全
public class Singleton {
    private static Singleton ourInstance = new Singleton();

    public static Singleton getInstance() {
        return ourInstance;
    }

    private Singleton() {
    }
}

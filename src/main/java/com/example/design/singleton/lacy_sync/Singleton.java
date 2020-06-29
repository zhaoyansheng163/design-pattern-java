package com.example.design.singleton.lacy_sync;

/**
 * @author zhaoyansheng
 * @package com.example.design.singleton
 * @date 2020/6/29
 * @description 描述
 */
//懒汉式单例，增加同步锁
public class Singleton {
    private static Singleton ourInstance = null;

    public synchronized static Singleton getInstance() {
        if (ourInstance == null) {
            ourInstance = new Singleton();
        }
        return ourInstance;
    }

    private Singleton() {
    }
}

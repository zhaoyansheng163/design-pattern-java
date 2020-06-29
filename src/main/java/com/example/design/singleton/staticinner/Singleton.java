package com.example.design.singleton.staticinner;

/**
 * @author zhaoyansheng
 * @package com.example.design.singleton
 * @date 2020/6/29
 * @description 描述
 */
//静态内部类
public class Singleton {
    private Singleton() {
    }
    private static class SingletonHolder {
        private static final Singleton singleton = new Singleton();
    }
    public static Singleton getInstance() {
        return SingletonHolder.singleton;
    }
}

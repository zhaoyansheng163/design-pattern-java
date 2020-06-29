package com.example.design.singleton.lacy;

/**
 * @author zhaoyansheng
 * @package com.example.design.singleton
 * @date 2020/6/29
 * @description 描述
 */
//懒汉式单例，使用的时候才加载，非线程安全
public class Singleton {
    private static Singleton ourInstance = null;

    public static Singleton getInstance() {

        if(ourInstance == null ){
            ourInstance = new Singleton();
            return ourInstance;
        }
        return ourInstance;
    }

    private Singleton() {
    }
}

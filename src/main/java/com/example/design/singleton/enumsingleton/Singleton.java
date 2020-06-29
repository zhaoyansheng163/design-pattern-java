package com.example.design.singleton.enumsingleton;

/**
 * @author zhaoyansheng
 * @package com.example.design.singleton
 * @date 2020/6/29
 * @description 描述
 */
//枚举单例：简单、线程安全、防止破坏单例
public enum Singleton {
    INSTANCE;
    public void  init() {
        System.out.println("资源初始化。。。");
    }
}

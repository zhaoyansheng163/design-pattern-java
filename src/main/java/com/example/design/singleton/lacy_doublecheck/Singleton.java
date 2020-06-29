package com.example.design.singleton.lacy_doublecheck;

/**
 * @author zhaoyansheng
 * @package com.example.design.singleton
 * @date 2020/6/29
 * @description 描述
 */
//懒汉式单例，双重检查  线程安全
public class Singleton {
    private static volatile Singleton singleton = null;

    public static Singleton getInstance() {
        if (singleton == null) {   //这里是为了，初始化过的不用再次进入同步
            synchronized (Singleton.class) {
                if (singleton == null) {   //这里的检查，是因为  singleton = new Singleton();  这个不是原子操作，是三步操作，顺序无法保证
                                           //1、给singleton分配内存空间，
                                           //2、调用Singleton构造函数初始化Singleton ，
                                           //3、将singleton实例指向分配的内存空间（执行完这步singleton就不是null了）
                    singleton = new Singleton(); //这个不是原子操作，123存在重排序的优化，2、3的顺序是不能保证的。
                                                 // 执行的顺序可能是132
                                                 // private static Singleton singleton = null;  如果不加volitile，则顺序无法保证，
                                                 // 可能会出现在一个线程执行singleton = new Singleton(); 的时候，另外的线程在第一个判断时，不是null，直接返回了，
                                                  // 而此时，singleton并没有完成初始化，导致空指针异常
                }
            }
        }
        return singleton;
    }
    private Singleton() {
    }
}

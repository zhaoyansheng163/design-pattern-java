package com.example.design.proxy3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
 * 动态代理示例特性：
 * （1）只需要被代理类实现接口
 * （2）动态代理使用需要使用Java反射
 */

interface ITeacherDao {
    void teach(); //授课
    void sayHello(String name);
}

class TeacherDao implements ITeacherDao { //被代理类
    @Override
    public void teach() {
        System.out.println("老师授课中......");
    }

    @Override
    public void sayHello(String name) {
        // TODO Auto-generated method stub
        System.out.println("Hell,"+name);
    }

}

class ProxyFactory {

    private Object target;  //维护一个目标对象

    public ProxyFactory(Object target) { // 构造方法
        this.target = target;
    }

    // 给目标对象生成一个代理对象
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 目标对象所使用的类加载器
                target.getClass().getInterfaces(), // 目标对象实现的接口类型
                new InvocationHandler() { // 执行目标对象方法时
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("JDK代理开始......");
                        //反射调用目标对象的方法
                        Object returnVal = method.invoke(target, args);
                        System.out.println("JDK代理提交");
                        return returnVal;
                    }
                });
    }
}

public class Test {  //测试类
    public static void main(String[] args) {
        // 创建目标对象
        ITeacherDao target = new TeacherDao();
        // 创建目标对象的代理对象
        ITeacherDao proxyInstance = (ITeacherDao) new ProxyFactory(target).getProxyInstance();
        System.out.println("proxyInstance=" + proxyInstance.getClass());
        proxyInstance.teach();
        proxyInstance.sayHello("Tom");
    }

}

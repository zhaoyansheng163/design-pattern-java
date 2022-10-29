package com.example.design.proxy2;

/*
 * 代理模式的三个角色：抽象主题角色、真实主题角色和代理主题角色。
 * 代理模式有静态代理和动态代理两种使用方式。
 * 本例使用静态代理，其主要特性如下：
 * （1）在不修改目标对象功能的前提下，能通过代理对象对目标功能进行扩展，这是优点。
 * （2）代理类需要与目标类实现同一接口，这是要求。
 * （3）一旦接口增加方法，则需要同时维护目标对象和代理对象，这是缺点。
 */
interface ITeacherDao{  //角色1：被代理对象的抽象接口
    void teach();  //授课
}

class TeacherDao implements ITeacherDao{  //角色2：被代理类
    @Override
    public void teach() {
        System.out.println("老师授课中......");
    }
}

class TeacherDaoProxy implements ITeacherDao{  //角色3：代理类

    private ITeacherDao target;  //通过接口来聚合的目标（被代理）对象
    public TeacherDaoProxy(ITeacherDao target) {
        super();
        this.target=target;
    }

    @Override
    public void teach() {
        System.out.println("开始代理，完成某些操作......");
        target.teach();  //通过代理对象执行目标对象（被代理对象）的核心方法
        System.out.println("提交......");
    }
}

public class Client {
    public static void main(String[] args) {
        //创建目标对象（被代理对象）
        TeacherDao teacherDao = new TeacherDao();
        //创建代理对象
        TeacherDaoProxy teacherDaoProxy = new TeacherDaoProxy(teacherDao);
        //通过代理对象，调用被代理对象的方法
        teacherDaoProxy.teach();  //不同于teacherDao.teach();
    }
}

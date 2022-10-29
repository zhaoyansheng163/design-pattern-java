package com.example.design.bridge2;

/*
 * 桥接模式Bridge Pattern
 * 使用手机：分为外观类型和品牌两个维度
 * 设计要点：抽象的外形聚合品牌的实现，即实现化与抽象化脱耦
 *          各种品牌的手机都具有打电话等功能，因此，将品牌设计为接口Brand
 *          对不同的手机外观（折叠式、直立式等）进行抽象Phone，相对客户端而言，Phone起到桥接的作用
 */
interface Brand { //手机品牌接口，定义各种手机应该具有的功能
    public void open();
    public void call();
    public void close();
}

class Xiaomi implements Brand { //小米手机

    @Override
    public void open() {
        System.out.println("小米手机开机");
    }

    @Override
    public void call() {
        System.out.println("小米手机打电话");
    }

    @Override
    public void close() {
        System.out.println("小米手机关机");
    }
}

class Vivo implements Brand { //Vivo手机
    @Override
    public void open() {
        System.out.println("Vivo手机开机");
    }

    @Override
    public void call() {
        System.out.println("Vivo手机打电话");
    }

    @Override
    public void close() {
        System.out.println("Vivo手机关机");
    }
}

abstract class Phone { //外观抽象类
    private Brand brand; //聚合

    public Phone(Brand brand) { //构造方法
        this.brand = brand;
    }
    protected void open() {
        brand.open();
    }

    protected void call() {
        brand.call();
    }

    protected void close() {
        brand.close();
    }
}

class FolderPhone extends Phone { // 折叠式手机
    public FolderPhone(Brand brand) {
        super(brand);
    }
    @Override
    protected void open() {
        System.out.print("折叠式的");
        super.open();
    }
    @Override
    protected void call() {
        System.out.print("折叠式的");
        super.call();
    }
    @Override
    protected void close() {
        System.out.print("折叠式的");
        super.close();
    }
}

//类似地，可定义直立式手机

public class Client {  //客户端
    public static void main(String[] args) {
        //创建折叠式的小米手机
        Phone phone1 = new FolderPhone(new Xiaomi());
        phone1.open();
        phone1.call();
        phone1.close();

        //创建折叠式的Vivo手机
        System.out.println("====================");
        Phone phone2 = new FolderPhone(new Vivo());
        phone2.open();
        phone2.call();
        phone2.close();

        //类似地，可方便地扩展手机品牌或外观样式！
    }
}
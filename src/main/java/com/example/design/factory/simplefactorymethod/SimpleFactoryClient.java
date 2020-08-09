package com.example.design.factory.simplefactorymethod;


/**
 * 简单工厂模式客户端实现类
 * @author you
 * 参考：https://blog.csdn.net/jx1605/article/details/80524296
 *
 */
public class SimpleFactoryClient {

    public static void main(String[] args) {

		/* 假定客户需要一台22英寸三星显示器，带有Intel CPU，华硕主板的主机
		和一台24英寸戴尔显示器，带有AMD CPU，联想主板的主机。*/

        System.out.println("客户得到第一台电脑："+ComputerFactory.createComputer(1));

        System.out.println("客户得到第二台电脑："+ComputerFactory.createComputer(2));

    }
}

package com.example.design.builder;

/**
 * @author zhaoyansheng
 * @package com.example.design.builder1
 * @date 2020/6/29
 * @description 描述
 */
//参考 https://zhuanlan.zhihu.com/p/58093669
public class test {
    public static void main(String[] args) {
        Computer computer=new Computer.Builder("因特尔","三星")
                .setDisplay("三星24寸")
                .setKeyboard("罗技")
                .setUsbCount(2)
                .build();
        System.out.println(computer.getCpu());
    }
}

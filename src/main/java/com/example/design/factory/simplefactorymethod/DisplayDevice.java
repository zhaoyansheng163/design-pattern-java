package com.example.design.factory.simplefactorymethod;

/**
 * 显示器
 * @author you
 *
 */
public class DisplayDevice {

    //产品型号
    private String productModel;

    //显示器长度
    private double size;

    /**
     * 构造方法
     * @param productModel 产品型号
     * @param size 显示器长度
     */
    public DisplayDevice(String productModel,double size) {
        // TODO Auto-generated constructor stub

        this.productModel = productModel;
        this.size = size;

    }

    public String getOwners()
    {
        return "显示器型号："+this.productModel+";长度:"+this.size+"英寸";
    }

}
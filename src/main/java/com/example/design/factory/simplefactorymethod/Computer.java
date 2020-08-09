package com.example.design.factory.simplefactorymethod;


/**
 * 主机
 * @author you
 *
 */
public class Computer {

    //主板型号
    private String mainBoardModel;

    //cpu型号
    private String cpuModel;

    /**
     * 构造方法
     * @param mainBoardModel 主板型号
     * @param cpuModel cpu型号
     */
    public Computer(String mainBoardModel,String cpuModel) {
        // TODO Auto-generated constructor stub
        this.mainBoardModel = mainBoardModel;
        this.cpuModel = cpuModel;
    }

    public String getOwners()
    {
        return "主机主板型号："+this.mainBoardModel+";cpu型号:"+this.cpuModel ;
    }

}

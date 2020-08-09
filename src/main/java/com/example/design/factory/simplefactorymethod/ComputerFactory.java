package com.example.design.factory.simplefactorymethod;


/**
 * 电脑工厂
 * @author you
 *
 */
public class ComputerFactory {

    //主机信息
    private static Computer computer;

    //显示器信息
    private static DisplayDevice displayDevice;

    /**
     * 创建电脑
     * @param type 创建电脑的类型
     */
    public static String createComputer(int type)
    {
        switch (type) {
            case 1:
            {
                //22英寸三星显示器，带有Intel CPU，华硕主板的主机
                displayDevice = new DisplayDevice("Samsung", 22);
                computer = new Computer("Asus","Intel");
                return getOwners();
            }
            case 2:
            {
                //一台24英寸戴尔显示器，带有AMD CPU，联想主板的主机。
                displayDevice = new DisplayDevice("Dell", 24);
                computer = new Computer("Lenovo","AMD");
                return getOwners();
            }
            default:

                return "";
        }
    }

    public static String getOwners()
    {
        return displayDevice.getOwners()+";"+computer.getOwners();
    }



}

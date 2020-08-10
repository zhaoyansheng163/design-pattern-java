package com.example.design.AdaperPs2ToUSB.AdaperPs2ToUSBByClass;

/**
 * @author zhaoyansheng
 * @package com.example.design.AdaperPs2ToUSB
 * @date 2020/8/10
 * @description 描述
 */
//实例讲解：
//
//        　　我手中有个ps2插头的设备，但是主机上只有usb插头的插口，怎么办呢？弄个转换器，将ps2插头转换成为USB插头就可以使用了。
//
//        　　接口Ps2：描述ps2接口格式
//
//        　　接口Usb：描述USB接口格式
//
//        　　类Usber：是接口Usb的实现类，是具体的USB接口格式
//
//        　　Adapter：用于将ps2接口格式转换成为USB接口格式

public class Clienter {

    public static void main(String[] args) {
        Ps2 p = new Adapter();
        p.isPs2();
    }

}
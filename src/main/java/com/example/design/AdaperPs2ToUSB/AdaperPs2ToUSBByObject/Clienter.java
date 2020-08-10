package com.example.design.AdaperPs2ToUSB.AdaperPs2ToUSBByObject;

/**
 * @author zhaoyansheng
 * @package com.example.design.AdaperPs2ToUSB.AdaperPs2ToUSBByObject
 * @date 2020/8/10
 * @description 描述
 */
public class Clienter {

    public static void main(String[] args) {
        Ps2 p = new Adapter(new Usber());
        p.isPs2();
    }

}

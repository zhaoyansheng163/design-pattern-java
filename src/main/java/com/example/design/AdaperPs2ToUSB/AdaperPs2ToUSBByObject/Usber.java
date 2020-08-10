package com.example.design.AdaperPs2ToUSB.AdaperPs2ToUSBByObject;

/**
 * @author zhaoyansheng
 * @package com.example.design.AdaperPs2ToUSB
 * @date 2020/8/10
 * @description 描述
 */
public class Usber implements Usb {

    @Override
    public void isUsb() {
        System.out.println("USB口");
    }
}

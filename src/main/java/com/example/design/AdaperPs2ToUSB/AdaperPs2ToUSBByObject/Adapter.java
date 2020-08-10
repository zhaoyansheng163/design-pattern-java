package com.example.design.AdaperPs2ToUSB.AdaperPs2ToUSBByObject;



/**
 * @author zhaoyansheng
 * @package com.example.design.AdaperPs2ToUSB.AdaperPs2ToUSBByObject
 * @date 2020/8/10
 * @description 描述
 */
public class Adapter implements Ps2 {

    private Usb usb;
    public Adapter(Usb usb){
        this.usb = usb;
    }
    @Override
    public void isPs2() {
        usb.isUsb();
    }

}

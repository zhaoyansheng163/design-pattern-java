package com.example.design.AdaperPs2ToUSB.AdaperPs2ToUSBByClass;

/**
 * @author zhaoyansheng
 * @package com.example.design.AdaperPs2ToUSB
 * @date 2020/8/10
 * @description 描述
 */
public class Adapter extends Usber implements Ps2 {

    @Override
    public void isPs2() {
        isUsb();
    }

}
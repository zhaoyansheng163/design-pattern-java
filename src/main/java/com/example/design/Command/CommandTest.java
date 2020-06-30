package com.example.design.Command;

/**
 * @author zhaoyansheng
 * @package com.example.design.Command
 * @date 2020/6/30
 * @description 描述
 */
public class CommandTest {
    public static void main(String[] args) {
        //创建一个电视机
        Television tv = new Television();
        //创建一个遥控器
        TeleController teleController = new TeleController();

        teleController.switchCommand(new CCTV1Command(tv));
        teleController.switchCommand(new CCTV2Command(tv));
        System.out.println("------返回上一个卫视--------");
        //模拟遥控器返回键
        teleController.back();
    }

}

package com.example.design.facade2;

/*
 * 核心类：外观类Mainframe
 * 包含若干子系统：CPU、Memory、HardDisk和OS（组合关系）
 */
class CPU {    //子系统：CPU
    public void run() {
        System.out.println("CPU运行成功！");
    }
}

class Memory {    //子系统：内存
    public void check() {
        System.out.println("内存自检成功！");
    }
}

class HardDisk {    //子系统：硬盘
    public void read() {
        System.out.println("硬盘读取成功！");
    }
}

class OS {     //子系统：操作系统
    public void load() {
        System.out.println("Windows载入成功！");
    }
}

class Mainframe {  //外观类：主机箱
    private Memory memory;  //外观类组合了Memory
    private CPU cpu;   //外观类组合了CPU
    private HardDisk harddisk;  //外观类组合了HardDisk
    private OS windows;  //外观类组合了OS

    public Mainframe() {  //构造方法
        memory = new Memory();
        cpu = new CPU();
        harddisk = new HardDisk();
        windows = new OS();
    }

    public void on() {
        try {
            memory.check();
            cpu.run();
            harddisk.read();
            windows.load();
        } catch (Exception e) {
            System.out.println("启动失败");
        }
    }
}

public class Client {  //客户端只与外观类Mainframe打交道，屏蔽了各个子系统的内部细节

    public static void main(String[] args) {
        Mainframe mainframe = new Mainframe();
        mainframe.on();
        System.out.println("电脑启动成功!");
    }
}

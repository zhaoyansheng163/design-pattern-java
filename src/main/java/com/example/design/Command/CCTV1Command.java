package com.example.design.Command;

//播放cctv1的命令
public class CCTV1Command extends Command {
    public CCTV1Command(Television television) {
        super(television);
    }
    @Override
    void execute() {
        television.playCctv1();
    }
}
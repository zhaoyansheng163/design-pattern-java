package com.example.design.Command;

//播放cctv2的命令
public class CCTV2Command extends Command {
    public CCTV2Command(Television television) {
        super(television);
    }

    @Override
    void execute() {
        television.playCctv2();
    }
}
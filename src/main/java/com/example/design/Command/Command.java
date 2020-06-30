package com.example.design.Command;

public abstract class Command {
    //命令接收者：电视机
    protected Television television;

    public Command(Television television) {
        this.television = television;
    }

    //命令执行
    abstract void execute();
}


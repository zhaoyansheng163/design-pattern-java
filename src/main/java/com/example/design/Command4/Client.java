package com.example.design.Command4;
/*
 * 命令模式是在命令发送者与接收者之间增加一个请求者
 * 命令发送者聚合了命令接收者
 * 命令调用者聚合了命令发送者
 */
interface ICommand { // 抽象命令接口
    public void sweep(); // 打扫清洁
}

class Student { // 命令接收者
    public void sweep() {
        System.out.println("We are sweeping the floor.");
    }
}

class Teacher implements ICommand { //命令发送者
    private Student receiver = null; //聚合命令接收者

    public Teacher(Student receiver) { //构造器注入
        this.receiver = receiver;
    }

    @Override
    public void sweep() {
        receiver.sweep();
    }
}

class Invoker { //命令请求者
    private ICommand command; //聚合

    public Invoker(ICommand command) { //构造器注入
        this.command = command;
    }

    public void execute() {
        command.sweep();
    }
}

public class Client {
    public static void main(String[] args) {
        // 下面的代码是通过命令请求者执行命令（命令模式——非直接方式）
        Student student = new Student(); //创建命令接收者
        Teacher teacher = new Teacher(student); //创建命令发送者
        Invoker invoke = new Invoker(teacher); //将命令请求加到请求者对象
        invoke.execute(); //由请求者发送命令

        //下面的代码也能实现上面代码的功能，并未使用Invoker类（非命令模式——直接方式）
        /*Student student = new Student();
        Teacher teacher = new Teacher(student);
        teacher.sweep();*/
    }
}

package com.example.design.chain2;

/*
 * 主要角色（组长->主任->经理）逐级准许请假而形成一个责任链
 */

class Request{
    int day;  //请假天数
    Request(int day){
        this.day=day;
    }
}

abstract class Handler{  //处理请求的抽象类
    private Handler next; //后续处理者（因成员为自身类型而形成链）
    public void setNext(Handler next) {
        this.next=next;
    }
    public Handler getNext() {
        return next;
    }
    public abstract boolean handle(Request req); //是否已处理？
}

class ZuZhang extends Handler{  //子类
    static int limit=1;
    @Override
    public boolean handle(Request req) {
        if(req.day<=limit) {
            System.out.println("组长同意。");
            return true;
        }
        return getNext().handle(req);
    }
}
class ZhuRen extends Handler{
    static int limit=2;
    @Override
    public boolean handle(Request req) {
        if(req.day<=limit) {
            System.out.println("主任同意。");
            return true;
        }
        return getNext().handle(req);
    }
}
class JingLi extends Handler{
    @Override
    public boolean handle(Request req) {
        System.out.println("经理同意。");
        return true;
    }
}

class DutyChain{  //责任链
    //定义不同的处理者
    private Handler one=new ZuZhang();
    private Handler two=new ZhuRen();
    private Handler three=new JingLi();

    public void createChain() {  //创建责任链
        //定义结点关系
        one.setNext(two);
        two.setNext(three);
    }
    public void handle(Request req) {  //处理请求
        one.handle(req);  //从基层开始
    }
}

public class Client {  //客户端
    public static void main(String[] args) {
        //创建一个责任链
        DutyChain dutyChain = new DutyChain();
        dutyChain.createChain();
        //设置不同的请假天数进行测试
        Request request = new Request(2);
        dutyChain.handle(request);

        Request request1 = new Request(1);
        dutyChain.handle(request1);
    }
}

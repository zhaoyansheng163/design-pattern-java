package com.example.design.strategy3;
/*
 * 策略模式示例
 * 角色1：抽象策略接口Strategy
 * 角色2：具体策略类StrategyA、StrategyB，...
 * 角色3：上下文环境类Context，聚合了策略接口类型的对象，定义了使用策略的方法
 * 功能：上下文对象的行为随着策略对象的改变而改变
 */

interface Strategy { //抽象策略接口
    public void speak();
}
class ConcreteStrategyA implements Strategy {  //具体策略类
    @Override
    public void speak() {
        System.out.println("Speak English.");
    }
}
class ConcreteStrategyB implements Strategy {   //具体策略类
    @Override
    public void speak() {
        System.out.println("Speak Chinese.");
    }
}

class Context {  //上下文环境类
    Strategy strategy;  //聚合了抽象策略
    public Context(Strategy strategy) {  //构造方法
        this.strategy = strategy;
    }

    public void execute() {  //使用策略
        strategy.speak();
    }
}

public class Client {  //客户端只需与上下文对象打交道，并选择具体策略
    public static void main(String[] args) {
        //创建一个具体策略
        Strategy a=new ConcreteStrategyA();
        //创建上下文对象并选用（执行）对应的策略
        new Context(a).execute();

        Strategy b=new ConcreteStrategyB();
        new Context(b).execute();
    }
}

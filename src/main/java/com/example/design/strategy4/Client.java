package com.example.design.strategy4;

/*
 * 设计要点：
 * （1）回调类的回调方法的参数是接口类型。
 * （2）使用回调类的类实现该接口，而不是被调用者实现。
 * （3）回调的含义是：抽象策略Strategy是上文，具体策略是下文。
 * 通常情形是上文调用下文，本案例则是下文调用上文。
 */
class Strategy{   //回调类（抽象策略）
    static interface Person{   //回调接口
        public void speak();
    }
    public void execute(Person person) {  //回调方法
        person.speak();
    }
}
public class Client {  //客户端
    public static void main(String[] args) {
        //创建回调对象（上文）
        Strategy strategy=new Strategy();
        //具体策略作为下文，动态地让一个对象在许多行为中选择一种就是下文调用上文（即回调）
        strategy.execute(new Strategy.Person() {  //匿名方式实现接口
            @Override
            public void speak() {
                System.out.println("Speak English.");
            }
        });
        strategy.execute(new Strategy.Person() {   //匿名方式实现接口
            @Override
            public void speak() {
                System.out.println("Speak Chinese.");
            }
        });
    }
}

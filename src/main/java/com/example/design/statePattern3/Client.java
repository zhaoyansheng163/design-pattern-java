package com.example.design.statePattern3;

import java.util.Random;

/*
 * 状态模式：抽奖活动（RaffleActivity）与状态（State）分离。
 * 四个状态子类NoRaffleState、CanRaffleState、DispenseState
 *           和DispenseOutState继承抽象类State分别聚合了活动
 * 活动类RaffleActivity又聚合了状态对象
 * raffle：抽奖；dispense：分发
 */
abstract class State { // 状态抽象类
    public abstract void deduceMoney();  // 扣积分
    public abstract boolean raffle();  // 是否中奖
    public abstract void dispensePrize();  // 发奖
}

class RaffleActivity { // 抽奖活动

    private State state; // 活动的当前状态
    private int count=0; // 奖品数量
    // 定义四种状态
    private State noRaffleState = new NoRaffleState(this);  //不能抽奖
    private State canRaffleState=new CanRaffleState(this);  //可以抽奖
    private State dispenseState=new DispenseState(this);  //发放奖品
    private State dispenseOutState=new DispenseOutState(this);  //奖品发放完毕

    public RaffleActivity(int count) {  //构造器
        //初始设置为不能抽奖状态（因为扣了积分才能抽奖）
        state = getNoRaffleState();
        this.count=count;  //奖品数量
    }

    //与三种状态抽象方法相应的方法
    public void deduceMoney() {  //扣积分
        state.deduceMoney();
    }
    public void raffle() {  //抽奖
        if(state.raffle()) {  //抽中时
            state.dispensePrize();  //领奖
        }
    }

    //状态属性state的setter/getter
    public void setState(State state) {  //设置活动的状态
        this.state=state;
    }
    public State getState() {  //获取活动的状态
        return state;
    }

    //四个获取不同状态的方法
    public State getNoRaffleState() {
        return noRaffleState;
    }
    public State getCanRaffleState() {
        return canRaffleState;
    }
    public State getDispenseState() {
        return dispenseState;
    }
    public State getDispenseOutState() {
        return dispenseOutState;
    }

    public void setCount(int count) {
        this.count=count;
    }
    public int getCount() {
        int currentCount=count;
        //每领一次奖品，需要做减一操作
        count--;
        return currentCount;
    }
}

class NoRaffleState extends State { // 未中奖状态
    // 初始化传入活动引用，扣除积分后改变其状态
    RaffleActivity activity;

    public NoRaffleState(RaffleActivity activity) { // 构造器
        this.activity = activity;
    }
    /*public RaffleActivity getActivity() {
        return activity;
    }
    public void setActivity(RaffleActivity activity) {
        this.activity = activity;
    }*/

    @Override
    public void deduceMoney() {
        System.out.println("扣除积分成功，你可以抽奖了...");
        activity.setState(activity.getCanRaffleState()); //设置成可抽奖状态
    }
    @Override
    public boolean raffle() {
        System.out.println("扣了积分才能抽奖哦。");
        return false;
    }
    @Override
    public void dispensePrize() {
        System.out.println("不能发放奖品。");
    }
}

class CanRaffleState extends State { // 可以抽奖状态
    RaffleActivity activity;

    public CanRaffleState(RaffleActivity activity) { // 构造器
        this.activity = activity;
    }
    @Override
    public void deduceMoney() {
        System.out.println("已经扣了积分...");
    }
    @Override
    public boolean raffle() {
        System.out.println("正在抽奖，请稍后...");
        Random random = new Random();
        int num = random.nextInt(10);
        //10%中奖概率
        if(num==8) {  //幸运（中奖）数字
            System.out.println("中奖号码num="+num);  //测试用
            //改变活动状态为发放奖品
            activity.setState(activity.getDispenseState());
            return true;
        }else {
            System.out.println("很遗憾，未能中奖。");
            //改变活动状态为不能抽奖
            activity.setState(activity.getNoRaffleState());
            return false;
        }
    }
    @Override
    public void dispensePrize() {
        System.out.println("没有中奖，不能发放奖品。");
    }
}

class DispenseState extends State { // 发放奖品
    RaffleActivity activity;

    public DispenseState(RaffleActivity activity) { // 构造器
        this.activity = activity;
    }

    @Override
    public void deduceMoney() {
        System.out.println("不能扣除积分。");
    }
    @Override
    public boolean raffle() {
        System.out.println("不能抽奖。");
        return false;
    }
    @Override
    public void dispensePrize() {
        if(activity.getCount()>0) {
            System.out.println("恭喜中奖了。");
            activity.setState(activity.getNoRaffleState());
        }else {
            System.out.println("很遗憾，奖品发放完了。");
            activity.setState(activity.getDispenseOutState());
        }

    }
}
class DispenseOutState extends State { // 奖品领完状态，抽奖活动结束
    RaffleActivity activity;

    public DispenseOutState(RaffleActivity activity) { // 构造器
        this.activity = activity;
    }

    @Override
    public void deduceMoney() {
        System.out.println("奖品领完了，请下次再参加活动...");
    }
    @Override
    public boolean raffle() {
        System.out.println("奖品领完了，请下次再参加活动...");
        return false;
    }
    @Override
    public void dispensePrize() {
        System.out.println("奖品领完了，请下次再参加活动...");
    }
}

public class Client {
    public static void main(String[] args) {
        //创建奖品池只有1件奖品的活动
        RaffleActivity activity = new RaffleActivity(1);
        //连续抽奖
        for(int i=0;i<20;i++) {  //中奖概率为10%，因此，循环终值不能过小
            System.out.println("======第"+(i+1)+"次抽奖=======");
            //抽奖活动第一步：扣积分
            activity.deduceMoney();
            //抽奖活动第二步：抽奖
            activity.raffle();
        }
    }
}

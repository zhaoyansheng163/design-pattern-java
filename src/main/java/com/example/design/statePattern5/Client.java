package com.example.design.statePattern5;

/*
 * 银行信用卡帐户在不同状态下的行为封装问题
 * 信用卡等级设为2000元
 * 抽象帐户类AccountState的子类NormalState、OverdraftState和RestrictedState
 */

abstract class AccountState{  //抽象的帐户状态
    protected Account acc;  //帐户
    public abstract void deposite(double amount);  //存款
    public abstract void withdraw(double amount);  //取款
    public abstract void computeInterset(); //计算利息
    public abstract void stateCheck();  //状态检查
}

class NormalState extends AccountState{  //通常状态

    public NormalState(Account acc) {
        this.acc=acc;
    }
    public NormalState(AccountState state) {
        this.acc=state.acc;
    }

    @Override
    public void deposite(double amount) {
        acc.setBalance(acc.getBalance()+amount);
        stateCheck();
    }

    @Override
    public void withdraw(double amount) {
        acc.setBalance(acc.getBalance()-amount);
        stateCheck();
    }

    @Override
    public void computeInterset() {
        System.out.println("正常状态，无须支付利息！");
    }

    @Override
    public void stateCheck() {
        if(acc.getBalance()>-2000 && acc.getBalance()<=0) {
            acc.setState(new OverdraftState(this));
        }else if(acc.getBalance()==-2000) {
            acc.setState(new RestrictedState(this));
        }else if(acc.getBalance()<-2000) {
            System.out.println("操作受限！");
        }
    }
}

class OverdraftState  extends AccountState{

    public  OverdraftState(AccountState state) {
        this.acc=state.acc;
    }

    //存款或取款都会引起余额的变化，因此，需要使用方法stateCheck()
    @Override
    public void deposite(double amount) {
        acc.setBalance(acc.getBalance()+amount);
        stateCheck();
    }
    @Override
    public void withdraw(double amount) {
        acc.setBalance(acc.getBalance()-amount);
        stateCheck();
    }

    @Override
    public void computeInterset() {
        System.out.println("计算利息！");
    }

    @Override
    public void stateCheck() {
        if(acc.getBalance()>0) {
            acc.setState(new NormalState(this));
        }else if(acc.getBalance()==-2000) {
            acc.setState(new RestrictedState(this));
        }else if(acc.getBalance()<-2000) {
            System.out.println("操作受限！");
        }
    }

}

class RestrictedState extends AccountState{

    public RestrictedState(AccountState state) {
        this.acc=state.acc;
    }

    @Override
    public void deposite(double amount) {
        acc.setBalance(acc.getBalance()+amount);
        stateCheck();
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("帐号受限，取款失败");
    }

    @Override
    public void computeInterset() {
        System.out.println("计算利息！");
    }

    @Override
    public void stateCheck() {  //存款或取款后都要执行的方法
        if(acc.getBalance()>0) {
            acc.setState(new NormalState(this));
        }else if(acc.getBalance()>-2000) {
            acc.setState(new OverdraftState(this));
        }
    }
}

class Account{  //作为环境类的银行帐户
    private AccountState state;  //帐户的当前状态，Account聚合AccountState
    private String owner; //开启名
    private double balance=0; //余额

    public Account(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
        this.state=new NormalState(this);  //设置初始状态
    }

    public AccountState getState() {
        return state;
    }

    public void setState(AccountState state) {
        this.state = state;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposite(double amount) {
        System.out.println(this.owner+"存款"+amount);
        state.deposite(amount);
        System.out.println("现在余额为"+this.balance);
        System.out.println("现在状态为"+this.state.getClass().getName());
        System.out.println("----------------------------");
    }

    public void withdraw(double amount) {
        System.out.println(this.owner+"取款"+amount);
        state.withdraw(amount);
        System.out.println("现在余额为"+this.balance);
        System.out.println("现在状态为"+this.state.getClass().getName());
        System.out.println("----------------------------");
    }

    public void computeInterest() {
        state.computeInterset();
    }

}

public class Client {  //客户端
    public static void main(String[] args) {
        Account account=new Account("张三",0.0);  //创建一个帐户
        account.deposite(1000);  //存款1000后为正常状态
        account.withdraw(2000);  //取款2000后为透支状态
        account.deposite(3000);  //存款3000后为正常状态
        account.withdraw(4000);  //取款4000后为受限状态
        account.withdraw(1000);  //受限状态，不能取款
        account.computeInterest();  //计算利息
    }
}
package com.example.design.decorator;

/*
 * 装饰者模式示例：星巴克咖啡订单
 * 点咖啡时，可以加调味品，还可以加点其它饮品
 * 订单费用计算方法：从一个具体的饮品（初始订单）开始计价，对此订单迭代计费。
 * Drink是抽象组件，Coffee是中间组件，Espresso、LongBlack和ShortBlack是具体组件
 * Decorator是抽象头饰类，Chocolate、Milk和Soy是具体装饰类
 */

abstract class Drink{  //抽象饮品类作为抽象组件

    private String des; //描述
    private float price;

    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public String getDes() {
        return des;
    }
    public void setDes(String des) {
        this.des = des;
    }
    public abstract float  cost(); //抽象方法，计算费用
}

class Coffee extends Drink{   //中间组件类
    @Override
    public float cost() {
        return super.getPrice();
    }
}

class Espresso extends Coffee{   //具体组件类
    public Espresso() {
        setPrice(6.0f);
        setDes("意大利咖啡");
    }
    @Override
    public float cost() {
        return 0;
    }
}
class LongBlack extends Coffee{   //具体组件类
    public LongBlack() {
        setPrice(5.0f);
        setDes("longblack");
    }
}
class ShortBlack extends Coffee{   //具体组件类
    public ShortBlack() {
        setPrice(4.0f);
        setDes("shortblack");
    }
}
class Decorator extends Drink{  //装饰者
    private Drink obj;
    public  Decorator(Drink obj) {
        this.obj=obj;
    }
    @Override
    public float cost() {
        return super.getPrice()+obj.cost();
    }
    @Override
    public String getDes() {
        // obj.getDes()输出被装饰者的信息
        return super.getDes()+"  "+getPrice()+" && "+obj.getDes();
    }
}

class Chocolate extends Decorator{  //具体装饰者
    public Chocolate(Drink obj) {
        super(obj);
        setDes("巧克力");
        setPrice(3.0f);
    }
}
class Milk extends Decorator{  //具体装饰者
    public Milk(Drink obj) {
        super(obj);
        setDes("牛奶");
        setPrice(2.0f);
    }
}
class Soy extends Decorator{  //具体装饰者
    public Soy(Drink obj) {
        super(obj);
        setDes("豆浆");
        setPrice(1.5f);
    }
}
public class Client {
    public static void main(String[] args) {
        //计算2份巧克力+一份牛奶的LongBlack

        //step1
        Drink order = new LongBlack();  //初始订单
        System.out.println("描述："+order.getDes());
        //System.out.println("费用："+order.getPrice());
        System.out.println("费用："+order.cost());
        System.out.println("======================");

        //step2
        order = new Milk(order);  //订单迭加
        System.out.println("order加一份牛奶后的费用："+order.cost());
        System.out.println("order加一份牛奶  描述="+order.getDes());
        System.out.println("========================================");

        //step3
        order = new Chocolate(order);
        System.out.println("order加一份牛奶 加一份巧克力 后的费用："+order.cost());
        System.out.println("order加一份牛奶 加一份巧克力  描述="+order.getDes());
        System.out.println("=================================================================");

        //step4
        order = new Chocolate(order);
        System.out.println("order加一份牛奶 加二份巧克力 后的费用："+order.cost());
        System.out.println("order加一份牛奶 加二份巧克力  描述="+order.getDes());
    }
}

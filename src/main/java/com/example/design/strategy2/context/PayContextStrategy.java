package com.example.design.strategy2.context;

import com.example.design.strategy2.PayStrategy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class PayContextStrategy {
//    @Autowired
//    private PaymentChannelMapper paymentChannelMapper;
    private static Map<String,PayStrategy> map = new HashMap<>();
    public static void register(String key,PayStrategy one){
        map.put(key,one);
    }
    public String toPayHtml(String payCode){
         //1.使用payCode参数查询数据库获取beanid
        //PaymentChannelEntity paymentChannel = paymentChannelMapper.getPaymentChannel(payCode);
        //PayStrategy payStrategyContent = new PayStrategy(springUtilsContext.getBean(PayChannelEnum.ALIPAY.getWay(),PayStrategy.class));
//        PaymentChannelEntity paymentChannel = null;   //此处需要根据payCode获取到beanid
//        if(paymentChannel==null){
//            return  "没有该渠道信息";
//        }
//        //2.获取到bean的id之后，使用spring容器获取实例对象
//        String strategyBeanId = paymentChannel.getStrategyBeanId();
//        if(StringUtils.isEmpty(strategyBeanId)){
//            return  "该渠道没有配置beanid";
//        }
        // 3.执行该实现的方法即可.... aliPayStrategy
        PayStrategy payStrategy= map.get(payCode);
        return  payStrategy.toPayHtml();
     }
     // 优化 支付渠道存放内存中...
}

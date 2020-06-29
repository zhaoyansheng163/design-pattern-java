package com.example.design.strategy.context;

//import com.cx.mapper.PaymentChannelMapper;

import com.example.design.strategy.PayStrategy;
import com.example.design.strategy.entity.PaymentChannelEntity;
import com.example.design.strategy.utils.PayChannelEnum;
import com.example.design.strategy.utils.SpringUtils;
import com.example.design.strategy.utils.SpringUtilsContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


@Component
public class PayContextStrategy {
//    @Autowired
//    private PaymentChannelMapper paymentChannelMapper;

    @Autowired
    private SpringUtilsContext springUtilsContext;
    @Autowired
    private SpringUtils springUtils;
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
        PayStrategy payStrategy=SpringUtils.getBean(payCode, PayStrategy.class);
        return  payStrategy.toPayHtml();
     }
     // 优化 支付渠道存放内存中...
}

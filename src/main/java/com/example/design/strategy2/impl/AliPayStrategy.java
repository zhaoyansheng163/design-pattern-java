package com.example.design.strategy2.impl;

import com.example.design.strategy2.PayStrategy;
import com.example.design.strategy2.context.PayContextStrategy;
import com.example.design.strategy2.enumutil.PayChannelEnum;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;


@Component
public class AliPayStrategy   implements PayStrategy, InitializingBean {
    public String toPayHtml() {
        return "调用支付宝支付接口...";
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        PayContextStrategy.register(PayChannelEnum.ALIPAY.getWay(),this);
    }
}

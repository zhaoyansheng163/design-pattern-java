package com.example.design.strategyautowired.impl;

import com.example.design.strategyautowired.PayStrategyAutoW;
import org.springframework.stereotype.Component;


@Component
public class AliPayAutoWStrategy implements PayStrategyAutoW {
    public String toPayHtml() {
        return "调用支付宝支付接口...";
    }

}

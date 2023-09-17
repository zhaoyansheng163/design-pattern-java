package com.example.design.strategyautowired.impl;

import com.example.design.strategyautowired.PayStrategyAutoW;
import org.springframework.stereotype.Component;


@Component("yy")
public class YinLianAutoWPayStrategy implements PayStrategyAutoW {
    public String toPayHtml() {
        return "调用银联支付接口...";
    }
}

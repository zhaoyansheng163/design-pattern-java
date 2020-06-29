package com.example.design.strategy.impl;

import com.example.design.strategy.PayStrategy;
import org.springframework.stereotype.Component;


@Component
public class YinLianPayStrategy implements PayStrategy {
    public String toPayHtml() {
        return "调用银联支付接口...";
    }
}

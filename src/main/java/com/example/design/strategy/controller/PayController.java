package com.example.design.strategy.controller;

import com.example.design.strategy.context.PayContextStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PayController {
    @Autowired
    private PayContextStrategy payContextStrategy;
    @RequestMapping("/toPayHtml")
    public  String toPayHtml(String payCode){
        if(StringUtils.isEmpty(payCode)){
            return "渠道code不能为空!";
        }
        return payContextStrategy.toPayHtml(payCode);
    }
}

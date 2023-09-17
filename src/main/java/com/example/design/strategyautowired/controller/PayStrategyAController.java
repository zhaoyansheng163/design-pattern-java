package com.example.design.strategyautowired.controller;

import com.example.design.strategyautowired.PayStrategyAutoW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class PayStrategyAController {
    @Autowired
    private Map<String,PayStrategyAutoW> payStrategyAutoWS;
    @RequestMapping("/toPayAutoWHtml")
    public  String toPayHtml(String payCode){
        if(StringUtils.isEmpty(payCode)){
            return "渠道code不能为空!";
        }
        return payStrategyAutoWS.get(payCode).toPayHtml();
    }
}

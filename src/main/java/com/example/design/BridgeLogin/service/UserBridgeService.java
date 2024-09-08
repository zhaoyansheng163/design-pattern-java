package com.example.design.BridgeLogin.service;


import com.example.design.AdapterLogin.dto.UserInfo;
import com.example.design.BridgeLogin.factory.RegisterLoginComponentFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hyy
 * @Description
 * @create 2023-12-15 18:08
 */
@Service
public class UserBridgeService {

    public String login(String account, String password) {
        //每次执行login的时候都需要创建两个对象,可能会引起频繁垃圾回收
        AbstractRegisterLoginComponent registerLoginComponent = RegisterLoginComponentFactory.getComponent("Default");
        return registerLoginComponent.login(account, password);
    }

    public String register(UserInfo userInfo) {
        AbstractRegisterLoginComponent registerLoginComponent = RegisterLoginComponentFactory.getComponent("Default");
        return registerLoginComponent.register(userInfo);
    }

    public String login3rd(HttpServletRequest request, String type) {
        AbstractRegisterLoginComponent registerLoginComponent = RegisterLoginComponentFactory.getComponent(type);
        return registerLoginComponent.login3rd(request);
    }
}
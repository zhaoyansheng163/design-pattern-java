package com.example.design.BridgeLogin.service;



import com.example.design.AdapterLogin.dto.UserInfo;
import com.example.design.BridgeLogin.IRegisterLoginFunction;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hyy
 * @Description
 * @create 2023-12-15 13:32
 */
public class RegisterLoginComponent extends AbstractRegisterLoginComponent {

    public RegisterLoginComponent(IRegisterLoginFunction funcInterface) {
        super(funcInterface);
    }

    @Override
    protected String login(String userName, String password) {
        return funcInterface.login(userName, password);
    }

    @Override
    protected String register(UserInfo userInfo) {
        return funcInterface.register(userInfo);
    }

    @Override
    protected boolean checkUserExists(String userName) {
        return funcInterface.checkUserExists(userName);
    }

    @Override
    protected String login3rd(HttpServletRequest request) {
        return funcInterface.login3rd(request);
    }
}
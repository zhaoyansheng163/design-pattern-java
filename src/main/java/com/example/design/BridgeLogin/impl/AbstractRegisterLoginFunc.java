package com.example.design.BridgeLogin.impl;


import com.example.design.AdapterLogin.dto.UserInfo;
import com.example.design.BridgeLogin.IRegisterLoginFunction;
import com.example.design.BridgeLogin.Mapper.UserMapper;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author hyy
 * @Description
 * @create 2023-12-15 17:40
 */
public abstract class AbstractRegisterLoginFunc implements IRegisterLoginFunction {

    protected String commonLogin(String account, String password, UserMapper userRepo) {
        UserInfo userInfo = userRepo.findByNameAndPassword(account, password);
        if (Objects.isNull(userInfo)) {
            return "account / password ERROR!";
        }
        return "Login Success!";
    }

    protected String commonRegister(UserInfo userInfo, UserMapper userRepo) {
        if (commonCheckUserExists(userInfo.getUserName(), userRepo)) {
            throw new RuntimeException("User already registered.");
        }
        userRepo.insert(userInfo);
        return "Register Success!";
    }

    protected boolean commonCheckUserExists(String userName, UserMapper userRepo) {
        UserInfo user = userRepo.findByUserName(userName);
        return null != user;
    }

    public String login(String account, String password) {
        throw new UnsupportedOperationException();
    }

    public String register(UserInfo userInfo) {
        throw new UnsupportedOperationException();
    }

    public boolean checkUserExists(String userName) {
        throw new UnsupportedOperationException();
    }

    public String login3rd(HttpServletRequest request) {
        throw new UnsupportedOperationException();
    }
}
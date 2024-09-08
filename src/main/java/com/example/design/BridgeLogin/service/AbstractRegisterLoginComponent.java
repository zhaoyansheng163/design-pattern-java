package com.example.design.BridgeLogin.service;



import com.example.design.AdapterLogin.dto.UserInfo;
import com.example.design.BridgeLogin.IRegisterLoginFunction;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hyy
 * @Description
 * @create 2023-12-15 13:31
 */
public abstract class AbstractRegisterLoginComponent {

    // 桥接模式的桥所在
    protected IRegisterLoginFunction funcInterface;

    public AbstractRegisterLoginComponent(IRegisterLoginFunction funcInterface) {
        validate(funcInterface);
        this.funcInterface = funcInterface;
    }

    protected final void validate(IRegisterLoginFunction funcInterface) {
        if (!(funcInterface instanceof IRegisterLoginFunction)) {
            throw new UnsupportedOperationException("Unknown register login function type!");
        }
    }

    protected abstract String login(String userName, String password);

    protected abstract String register(UserInfo userInfo);

    protected abstract boolean checkUserExists(String userName);

    protected abstract String login3rd(HttpServletRequest request);
}
package com.example.design.AdapterLogin.controller;

import com.example.design.AdapterLogin.Login3rdAdapter;
import com.example.design.AdapterLogin.dto.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hyy
 * @Description
 * @create 2023-12-14 23:14
 */

@RestController
@RequestMapping("/adapter")
public class UserAdapterController {

    @Autowired
    private Login3rdAdapter login3rdAdapter;

    @GetMapping("/gitee")
    public String gitee(String code, String state) {
        return login3rdAdapter.loginByGitee(code, state);
    }

    @PostMapping("/login")
    public String login(String account, String password) {
        return login3rdAdapter.login(account, password);
    }

    @PostMapping("/register")
    public String register(@RequestBody UserInfo userInfo) {
        return login3rdAdapter.register(userInfo);
    }
}
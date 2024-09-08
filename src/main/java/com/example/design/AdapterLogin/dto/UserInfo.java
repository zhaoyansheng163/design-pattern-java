package com.example.design.AdapterLogin.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * @author hyy
 * @Description
 * @create 2023-12-14 00:16
 */

@Data
@Builder
public class UserInfo {

    private Integer id;

    private String userName;

    private String password;

    private Integer age;

    private String email;

    @Tolerate
    UserInfo() {
    }
}
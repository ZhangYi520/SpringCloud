package com.zy.common.vo;

import lombok.Data;

/**
 * @program: SpringCloud
 * @description: 登录参数类
 * @author: zhang yi
 * @create: 2020-05-08 14:15
 */
@Data
public class LoginVo {

    private String account;
    private String pwd;
    private boolean remenbme;

}

package com.zy.common.base.util;

import java.util.UUID;

/**
 * @program: SpringCloud
 * @description: uuid工具类
 * @author: zhang yi
 * @create: 2020-04-17 13:49
 */
public class UUIDUtils {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void main(String[] args) {
        System.out.println("格式前的UUID ： " + UUID.randomUUID().toString());
        System.out.println("格式化后的UUID ：" + getUUID());
    }

}

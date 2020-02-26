package com.zy.socket.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User1 implements Serializable {
    String id;
    String userName;
    String password;
}

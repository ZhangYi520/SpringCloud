package com.zy.common.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Article {
    private String uuid;

    private String articleImg;

    private String title;

    private String content;

    private String tags;

    private String specialColumn;

    private String type;

    private String form;

    private String status;

    private String createBy;

    private Date createTime;

    private Date updateTime;

}
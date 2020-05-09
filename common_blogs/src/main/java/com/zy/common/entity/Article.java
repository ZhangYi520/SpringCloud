package com.zy.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
@Data
public class Article {
    private String uuid;

    private String articleImg;

    private String title;

    private String content;

    private String vocType;

    private String vocForm;

    private String status;

    private String createBy;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    private Integer readNum;

}
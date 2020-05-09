package com.zy.common.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @program: SpringCloud
 * @description: 我的博客列表界面，文章数据vo类
 * @author: zhang yi
 * @create: 2020-04-21 14:01
 */
@Data
public class MyBlogsListVo {
    /**文字id*/
    private String articleUuid;

    /**文章类型code*/
    private String vocCode;

    /**文章类型name*/
    private String vocTypeName;

    /**文章标题*/
    private String title;

    /**文章内容，这里显示是摘要*/
    private String content;

    /**创建时间*/
    private LocalDateTime createTime;

    /**阅读数*/
    private Integer readNum;

    /**留言数*/
    private Integer commentNum;

    /**创建用户id*/
    private String createBy;

    /**用户名*/
    private String userName;
}

package com.zy.common.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @program: SpringCloud
 * @description: 查看文章vo类
 * @author: zhang yi
 * @create: 2020-04-22 09:41
 */
@Data
public class ArticleLookVo {
    /**文章id*/
    private String articleUuid;
    /**文章图片*/
    private String articleImg;
    /**标题*/
    private String title;
    /**内容*/
    private String content;
    /**最后修改时间*/
    private LocalDateTime updateTime;
    /**阅读数*/
    private Integer readNum;
    /**作者id*/
    private String userUuid;
    /**作者名字*/
    private String userName;
    /**分类id*/
    private String vocUuid;
    /**分类代码*/
    private String vocCode;
    /**分类名字*/
    private String vocName;
}

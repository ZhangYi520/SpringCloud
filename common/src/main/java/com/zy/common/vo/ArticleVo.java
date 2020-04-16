package com.zy.common.vo;

import com.zy.common.entity.Article;
import com.zy.common.entity.VocTags;
import lombok.Data;

import java.util.List;

/**
 * @program: SpringCloud
 * @description: 文章vo类
 * @author: zhang yi
 * @create: 2020-04-10 16:36
 */
@Data
public class ArticleVo extends Article {

//    /**
//     * 标题
//     */
//    private String title;

//    /**
//     * 内容
//     */
//    private String content;

    /**
     * 标签集合
     */
    private List<VocTags> tags;

    /**
     * 分类专栏
     */
    private List<String> specialColumn;

//    /**
//     * 文章类型
//     */
//    private String type;
//
//    /**
//     * 发布形式
//     */
//    private String form;
}

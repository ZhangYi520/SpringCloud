package com.zy.common.Service.impl;

import com.netflix.discovery.converters.Auto;
import com.zy.common.Service.ArticleService;
import com.zy.common.base.util.BeanUtils;
import com.zy.common.base.util.ReturnResult;
import com.zy.common.base.util.UUIDUtils;
import com.zy.common.dao.ArticleLabelMapper;
import com.zy.common.dao.ArticleMapper;
import com.zy.common.dao.ArticleSpecialColumnMapper;
import com.zy.common.dao.VocTagsMapper;
import com.zy.common.entity.Article;
import com.zy.common.entity.ArticleLabel;
import com.zy.common.entity.ArticleSpecialColumn;
import com.zy.common.entity.VocTags;
import com.zy.common.vo.ArticleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @program: SpringCloud
 * @description: 文章表service层
 * @author: zhang yi
 * @create: 2020-04-16 14:37
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleLabelMapper articleLabelMapper;

    @Autowired
    private VocTagsMapper vocTagsMapper;

    @Autowired
    private ArticleSpecialColumnMapper articleSpecialColumnMapper;

    @Override
    @Transactional
    public ReturnResult saveArticle(ArticleVo vo) {
         /**1、添加文章基本信息*/
        Article article = new Article();
        BeanUtils.copyProperties(vo,article);
        article.setUuid(UUIDUtils.getUUID());
        article.setStatus("1");
        article.setCreateBy("asdsads");
        article.setCreateTime(new Date());
        article.setUpdateTime(new Date());
        articleMapper.insertSelective(article);

         /**2、添加文章标签信息,文章标签是独立的，每个用户添加文章时，先判断当前用户标签库中voc_tags是否存在，不存在则添加进去
          * (2.1)先插入文章标签的中间表
          * (2.2)插入标签库表，不存在才插入
          * */
        //前端的标签数据
        List<VocTags> tags = vo.getTags();
        List<ArticleLabel> labels=new ArrayList<>();
        tags.forEach(a ->{
            ArticleLabel res=new ArticleLabel();
            res.setUuid(UUIDUtils.getUUID());
            res.setArticleId(article.getUuid());
            res.setVocTagsId(a.getUuid());
            labels.add(res);
        });
        /**插入中间表*/
        articleLabelMapper.insertAll(labels);


        Iterator<VocTags> tagsiterator = tags.iterator();
        //数据库中存在的标签
        List<VocTags> existTags=vocTagsMapper.getAll();
        Iterator<VocTags> existTagsiterator = existTags.iterator();
        while (tagsiterator.hasNext()){
            VocTags apiTags = tagsiterator.next();
            while (existTagsiterator.hasNext()){
                VocTags dbTags = existTagsiterator.next();
                /**如果前端的标签存在数据库中，则删掉前端的标签，那么剩余的就是不存在的了*/
                if(dbTags.getUuid().equals(apiTags.getUuid())){
                    tagsiterator.remove();
                }
            }
        }

//        while (existTagsiterator.hasNext()){
//            VocTags dbTags = existTagsiterator.next();
//            while (tagsiterator.hasNext()){
//                VocTags apiTags = tagsiterator.next();
//                /**如果前端的标签存在数据库中，则删掉前端的标签，那么剩余的就是不存在的了*/
//                if(dbTags.getUuid().equals(apiTags.getUuid())){
//                    tagsiterator.remove();
//                }
//            }
//        }
        /**插入，这里已经过滤掉数据库中存在的了*/
        vocTagsMapper.insertNotExist(tags);


        /**3、添加文章分类专栏信息
         * 分类专栏在词汇voc表中，所以只插入中间表即可
         * */
        List<String> specialColumn = vo.getSpecialColumn();
        List<ArticleSpecialColumn> sc=new ArrayList<>();
        specialColumn.forEach(a ->{
            ArticleSpecialColumn res=new ArticleSpecialColumn();
            res.setUuid(UUIDUtils.getUUID());
            res.setArticleId(article.getUuid());
            res.setVocId(a);
            sc.add(res);
        });
        articleSpecialColumnMapper.insertAll(sc);


        return ReturnResult.ok("完成");
    }

    @Override
    public ReturnResult demo() {
        return articleMapper.testq();
    }
}


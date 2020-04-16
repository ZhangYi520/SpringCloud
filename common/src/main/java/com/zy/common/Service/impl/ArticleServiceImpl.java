package com.zy.common.Service.impl;

import com.zy.common.Service.ArticleService;
import com.zy.common.base.util.BeanUtils;
import com.zy.common.base.util.ReturnResult;
import com.zy.common.dao.ArticleLabelMapper;
import com.zy.common.dao.ArticleMapper;
import com.zy.common.dao.VocTagsMapper;
import com.zy.common.entity.Article;
import com.zy.common.entity.ArticleLabel;
import com.zy.common.entity.VocTags;
import com.zy.common.vo.ArticleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Override
    public ReturnResult add(ArticleVo vo) {
         /**1、添加文章基本信息*/
        Article article = new Article();
        BeanUtils.copyProperties(vo,article);
        article.setUuid(UUID.randomUUID().toString().replace("-", ""));
        article.setStatus("1");
        article.setCreateBy("zy");
        article.setCreateTime(new Date());
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
            res.setUuid(UUID.randomUUID().toString().replace("-", ""));
            res.setArticleId(article.getUuid());
            res.setVocTagsId(a.getUuid());
            labels.add(res);
        });
//        articleLabelMapper.


        Iterator<VocTags> tagsiterator = tags.iterator();
        //数据库中存在的标签
        List<VocTags> existTags=vocTagsMapper.getAll();
        Iterator<VocTags> existTagsiterator = existTags.iterator();
        while (existTagsiterator.hasNext()){
            VocTags next = existTagsiterator.next();
            while (tagsiterator.hasNext()){
                VocTags next1 = tagsiterator.next();
            }

        }

        vocTagsMapper.insertNotExist(tags);

//
//        List<ArticleLabel> labelList=new ArrayList<>();
//        tags.forEach(a ->{
//            ArticleLabel label=new ArticleLabel();
//            label.setUuid(UUID.randomUUID().toString().replace("-", ""));
//            label.setArticleId(article.getUuid());
//            label.setVocTagsId(a.getUuid());
//            labelList.add(label);
//        });




        /**3、添加文章分类专栏信息
         * 分类专栏在词汇voc表中，所以只插入中间表即可
         * */
        List<String> specialColumn = vo.getSpecialColumn();
        return null;
    }
}


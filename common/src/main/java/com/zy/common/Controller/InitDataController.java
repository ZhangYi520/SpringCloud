package com.zy.common.controller;

import com.zy.common.Service.impl.VocServiceImpl;
import com.zy.common.base.com.ComVoc;
import com.zy.common.base.util.RedisUtil;
import com.zy.common.entity.Voc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 初始化静态数据
 */
@RestController
@RequestMapping("/initData")
//@CrossOrigin(origins = "*", maxAge = 3600)//就是这个注解
public class InitDataController {
    @Autowired
    RedisUtil redisUtil;

    @Autowired
    private VocServiceImpl vocServiceImpl;



    @GetMapping("/flzl")
    public List<Voc> flzl() {
        try {
//            return vocServiceImpl.getSonListByVocCode(ComVoc.FLZL);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/wzlx")
    public List<Voc> wzlx() {
        try {
            return vocServiceImpl.getSonListByVocCode(ComVoc.WZLX);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/fbxs")
    public List<Voc> fbxs() {
        try {
            return vocServiceImpl.getSonListByVocCode(ComVoc.FBXS);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/getWriteBlogsData")
    public Map<String,List<Voc>> getWriteBlogsData() {
        try {
            Map<String,List<Voc>> map = new HashMap<>();
//            map.put("flzl",vocServiceImpl.getSonListByVocCode(ComVoc.FLZL));
//            map.put("wzlx",vocServiceImpl.getSonListByVocCode(ComVoc.WZLX));
//            map.put("fbxs",vocServiceImpl.getSonListByVocCode(ComVoc.FBXS));
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

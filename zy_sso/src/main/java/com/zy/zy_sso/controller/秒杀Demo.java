package com.zy.zy_sso.controller;

import com.zy.zy_sso.entity.MiaoshaGoods;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;

/**
 * @program: SpringCloud
 * @description: 秒杀Demo
 * @author: zhang yi
 * @create: 2019-10-28 10:57
 */
public class 秒杀Demo {

}

//class saveRedis implements InitializingBean {
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        List<MiaoshaGoods> goodsList = goodsService.listGoodsVo();
//        if(goodsList == null) {
//            return;
//        }
//        for(MiaoshaGoods goods : goodsList) {
//            redisService.set(GoodsKey.getMiaoshaGoodsStock, ""+goods.getId(), goods.getStockCount());
//            // 如果是分布式系统 可以交给 redis 去做
//            localOverMap.put(goods.getId(), false);
//        }
//
//    }
//}
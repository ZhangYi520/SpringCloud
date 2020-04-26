package com.zy.common.base.com;

/**
 * 静态数据
 */
public class Cons {


    public static String STATUS = "1";

    /**
     * 分类专栏
     * FLZL_VUE:vue
     * FLZL_JAVA:java
     */
    public static String FLZL = "FLZL";

    public enum FLZL {
        FLZL_VUE, FLZL_JAVA
    }


    /**
     * 文章类型
     * WZLX
     * WZLX_FY:翻译
     * WZLX_YC:原创
     * WZLX_ZZ:转载
     */
    public static String WZLX = "WZLX";

    public enum WZLX {
        WZLX_FY, WZLX_YC, WZLX_ZZ
    }

    /**
     * 发布形式
     * FBXS_FSKJ:粉丝可见
     * FBXS_GK:公开
     * FBXS_SM:私密
     * FBXS_VIPKJ:vip可见
     */
    public static String FBXS = "FBXS";

    public enum FBXS {
        FBXS_FSKJ, FBXS_GK, FBXS_SM, FBXS_VIPKJ
    }

    /**
     * 文章的各种状态常量
     * redNum：阅读数
     * FB：发布
     * CG：草稿
     * SC：删除
     */
    public static interface ARTICLE_STATUS{
        public static String FB="1";
        public static String CG="2";
        public static String SC="3";

        public static Integer READNUM=0;
    }

}

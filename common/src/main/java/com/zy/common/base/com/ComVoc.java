package com.zy.common.base.com;

/**
 * 静态数据
 */
public class ComVoc {

    //    static class name{
//        static String name="zy";
//    }

    public static String STATUS = "1";

    /**
     * 分类专栏
     * FLZL_VUE:vue
     * FLZL_JAVA:java
     */
//    public static String FLZL = "flzl";
    public enum  FLZL{
//        public static String VUE = "flzl_vue";
//        public static String JAVA = "flzl_java";
        VUE, JAVA
    }

    public static void main(String[] args) {
        System.out.println(FLZL.JAVA);
    }


    /**
     * 文章类型
     * WZLX
     * WZLX_FY:翻译
     * WZLX_YC:原创
     * WZLX_ZZ:转载
     */
    public static String WZLX = "wzlx";
    public static String WZLX_FY = "wzlx_fy";
    public static String WZLX_YC = "wzlx_yc";
    public static String WZLX_ZZ = "wzlx_zz";

    /**
     * 发布形式
     * FBXS_FSKJ:粉丝可见
     * FBXS_GK:公开
     * FBXS_SM:私密
     * FBXS_VIPKJ:vip可见
     */
    public static String FBXS = "fbxs";
    public static String FBXS_ = "fbxs_fskj";
    public static String FBXS_GK = "fbxs_gk";
    public static String FBXS_SM = "fbxs_sm";
    public static String FBXS_VIPKJ = "fbxs_vipkj";
    public enum FBXS{
        FSKJ,GK,SM,VIPKJ
    }
}

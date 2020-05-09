package com.zy.common_login.base.utils;

/**
 * @program: SpringCloud
 * @description: json 转换 map 工具类
 * @author: zhang yi
 * @create: 2020-05-09 10:39
 */
import java.util.List;
import java.util.Map;

public class JsonToMap {

    private static String jsonStr = "{\"list\":[{\"aNum\":3,\"bNum\":1}],\"resCode\":\"0\",\"resMessage\":\"成功\"}";

    public static void main(String[] args) {
        toMap(jsonStr);
//        try {
//            Map<String, Object> resMap = JsonUtil.strJson2Map(jsonStr);
//            List<Map<String, Object>> resList = (List<Map<String, Object>>) resMap.get("list");
//            for (int i = 0; i < resList.size(); i++) {
//                Map<String, Object> res = (Map<String, Object>) resList.get(i);
//                String aNum = (String) res.get("aNum");
//                double totalActualDouble = Double.parseDouble(aNum);
//                System.out.println(totalActualDouble);
//            }
//            System.out.println(resMap);
//        } catch (Exception e) {
//            System.out.println("Exception:" + e.getMessage());
//        }
    }

    public static Map<String, Object> toMap(String json){

        try {
            Map<String, Object> resMap = JsonUtil.strJson2Map(json);
//            List<Map<String, Object>> resList = (List<Map<String, Object>>) resMap.get("list");
//            for (int i = 0; i < resList.size(); i++) {
//                Map<String, Object> res = (Map<String, Object>) resList.get(i);
//                String aNum = (String) res.get("aNum");
//                double totalActualDouble = Double.parseDouble(aNum);
//                System.out.println(totalActualDouble);
//            }
//            System.out.println(resMap);
            return resMap;
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
        return null;
    }
}

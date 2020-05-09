package com.zy.common_login.base.utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
/**
 * @program: SpringCloud
 * @description: json工具类
 * @author: zhang yi
 * @create: 2020-05-09 10:40
 */
public class JsonUtil {
    private static List<Map<String, Object>> json2List(Object json) {
        JSONArray jsonArr = (JSONArray) json;
        List<Map<String, Object>> arrList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < jsonArr.size(); ++i) {
            arrList.add(strJson2Map(jsonArr.getString(i)));
        }
        return arrList;
    }

    public static Map<String, Object> strJson2Map(String json) {
        JSONObject jsonObject = JSONObject.parseObject(json);
        Map<String, Object> resMap = new HashMap<String, Object>();
        Iterator<Entry<String, Object>> it = jsonObject.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> param = (Map.Entry<String, Object>) it.next();
            if (param.getValue() instanceof JSONObject) {
                resMap.put(param.getKey(), strJson2Map(param.getValue().toString()));
            } else if (param.getValue() instanceof JSONArray) {
                resMap.put(param.getKey(), json2List(param.getValue()));
            } else {
                resMap.put(param.getKey(), JSONObject.toJSONString(param.getValue(), SerializerFeature.WriteClassName));
            }
        }
        return resMap;
    }
}

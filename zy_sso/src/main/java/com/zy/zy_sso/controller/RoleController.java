package com.zy.zy_sso.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class RoleController {
    @GetMapping("/demo")
    public Map<String,Integer> demo(){
        Map<String,Integer> map=new LinkedHashMap<String,Integer>();
        map.put("01",1);
        map.put("02",1);
        map.put("03",1);
        map.put("04",1);
        map.put("05",1);
        map.put("06",1);
        map.put("07",1);
        map.put("08",1);
        map.put("09",1);
        map.put("10",1);
        map.put("11",1);
        map.put("12",1);
        return map;
    }
}

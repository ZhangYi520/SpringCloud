package com.zy.zy_sso.entity;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.*;

/**
 * @program: SpringCloud
 * @description:
 * @author: zhang yi
 * @create: 2019-11-07 14:40
 */

public class getComUtil {

    public static void main(String[] args) throws Exception{
        String packageName = "com.zy.zy_sso.entity";
        //全类名集合  com.zy.xxx
        List<String> classNamesPackage = getClassNamefFromPachage(packageName);
        //单独类名集合 xxx
        List<String> classNames=new ArrayList<>();
        //map结果集
        Map<String,Object> map=new HashMap<>();

        if (classNamesPackage != null) {
            //遍历当前包的class对象
            for (int i = 0; i <classNamesPackage.size() ; i++) {
                Class cls = Class.forName(classNamesPackage.get(i));//获取当前类的Class对象

                String[] split = classNamesPackage.get(i).split("\\.");//拆分，应为类型是com.zy.xxx.xxx.xxx的形式，按照“.”拆分，最后那个就是类名了
                classNames.add(split[split.length-1]);//获取最后一个

                Com anno = (Com) cls.getAnnotation(Com.class);//获取Com注解

                if(anno!=null) {//判断类是否有Com注解，如果有，就操作
                    //获取当前类的name值
                    String value = anno.name();
                    //判断是否有name值
                    if ("".equals(value)) {//没有
                        value = toLowerCaseFirstOne(classNames.get(i));//首字母转换成小写
                        map.put(value,cls.newInstance());
                    }else{//有
                        map.put(value,cls.newInstance());
                    }
                }
            }
        }

        map.forEach((a,b)->{
            System.out.println(a+":"+b);
        });

    }

    /**
     * 获取指定包下面的所有类
     * @param packageName 包名
     * @return 类的完整名称 （不包括后缀）
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private static List<String> getClassNamefFromPachage(String packageName) throws IOException, ClassNotFoundException {
        Enumeration<URL> iterator = Thread.currentThread().getContextClassLoader().getResources(packageName.replace(".", "/"));
        List<String>list = new ArrayList<String>();

        URL url = null;
        File file = null;
        File[] fls = null;
        Class<?> c = null;
        String className = null;
        String classFullName = null;
        while(iterator.hasMoreElements()) {
            url = iterator.nextElement();
            if ("file".equals(url.getProtocol())) {
                file = new File(url.getPath());
                System.out.println(file);
                if (file.isDirectory()){
                    fls= file.listFiles();
                    for(File fl :fls) {
                        className = fl.getName();
                        className = className.substring(0,className.lastIndexOf(".")); //获取该类的类名 person
                        classFullName = packageName+"."+className;//该类的完整名称,例如com.xx.person
                        c=Thread.currentThread().getContextClassLoader().loadClass(classFullName);
                        list.add(classFullName);
                    }
                }
            }
        }

        return list;

    }

    //首字母转小写
    public static String toLowerCaseFirstOne(String s){
        if(Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }

}

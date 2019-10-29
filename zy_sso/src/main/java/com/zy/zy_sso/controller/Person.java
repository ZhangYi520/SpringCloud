package com.zy.zy_sso.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class Note {
    public static void main(String[] args) {
        List<Person> personList=new ArrayList<Person>();
        Person p1=new Person();
        Person p2=new Person();
        Person p3=new Person();
        Person p4=new Person();
        Person p5=new Person();
        Person p6=new Person();
        Person p7=new Person();
        Person p8=new Person();
        Person p9=new Person();
        Person p10=new Person();

        p1.setId(1);p1.setName("zya");p1.setPid(0);
        p2.setId(2);p2.setName("zyb");p2.setPid(0);
        p3.setId(3);p3.setName("zyc");p3.setPid(0);
        p4.setId(11);p4.setName("zyd");p4.setPid(1);
        p5.setId(12);p5.setName("zye");p5.setPid(2);
        p6.setId(13);p6.setName("zyf");p6.setPid(3);
        p7.setId(21);p7.setName("zyg");p7.setPid(21);
        p8.setId(22);p8.setName("zyh");p8.setPid(22);
        p9.setId(23);p9.setName("zyi");p9.setPid(23);
        p10.setId(31);p10.setName("zyj");p10.setPid(11);
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
        personList.add(p5);
        personList.add(p6);
        personList.add(p7);
        personList.add(p8);
        personList.add(p9);
        personList.add(p10);
        System.out.println(JSON.toJSON(personList));
        //循环转换
        List<Person> l1 = listtotree(personList);
        //递归转换
//        List<Person> l2 = listtotreeDg(personList);


        System.out.println(JSON.toJSON(l1));
//        System.out.println(JSON.toJSON(l2));
    }

    /**
     * 循环转换
     * @param personList
     * @return
     */
    public static List<Person> listtotree(List<Person> personList){
        List<Person> list = new ArrayList<Person>();
        for (Person per:personList) {
            if(per.getPid()==0) {
                list.add(per);
            }
            for (Person per2 : personList) {
                if (per.getId() == per2.getPid()) {
                    if(per.getPerson()==null){
                        per.setPerson(new ArrayList<Person>());
                    }
                    per.getPerson().add(per2);
                }
            }
        }
        return list;
    }

    /****************************************************************************
     * 递归转换
     * @param personList
     * @return
     */
    public static List<Person> listtotreeDg(List<Person> personList){
        List<Person> list = new ArrayList<Person>();
        for (Person person : personList) {
            if(person.getPid()==0){
                list.add(findChildren(person,personList));
            }
        }
        return list;
    }

    private static Person findChildren(Person person, List<Person> personList) {
        for (Person list : personList) {
            if(person.getId()==list.getPid()){
                if(person.getPerson()==null){
                    person.setPerson(new ArrayList<Person>());
                }
                person.getPerson().add(findChildren(list,personList));
            }
        }
        return person;
    }
    /****************************************************************************/

}

@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class Person{
    private Integer id;
    private Integer pid;
    private String name;
    private List<Person> person;


    public static void main(String[] args) {
//        int index=1;//换行标识
//        boolean flag=true;//质素标识
//        for (int i = 2; i <= 500; i++) {//从这里面找出质素
//            for (int j = 2; j <= i-1; j++) {//这个是进行质素进行逻辑处理的除数，就是从2开始一直到它本身-1的这些数，每个都除一次，发现余数==0，就不是质数，然后break.
//                if(i%j==0){//不是质素
//                    flag=false;
//                    break;
//                }else{
//                    flag=true;
//                }
//            }
//            if(flag){//质数打印
//                flag=false;
//                System.out.print(i+" ");
//                index++;
//                if(index%20==0){
//                    System.out.println();
//                }
//            }
//        }
//        System.out.println(a());
//        9223372036854775807
        BigInteger b=new BigInteger("1111111111111111111");

        System.out.println(b);
    }

    public static int a(){
        int i=1;
        try {
            i=2;
            return i;
        }finally {
            i=3;
            System.out.println("finally"+i);
            return  i;
        }
    }
}